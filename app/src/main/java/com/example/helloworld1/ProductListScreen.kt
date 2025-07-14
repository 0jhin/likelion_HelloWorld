package com.example.helloworld1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource // 예시 이미지 로드를 위해
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// import com.yourpackage.R // 실제 R 파일을 임포트해야 합니다.

// 데이터 클래스 정의 (실제 앱에서는 더 많은 필드가 있을 수 있습니다)
data class ProductItem(
    val id: String,
    val title: String,
    val price: String,
    val location: String,
    val likes: Int,
    val imageUrl: Int // 예시로 Drawable 리소스 ID를 사용, 실제로는 String URL 사용
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(products: List<ProductItem>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("중고거래 물품") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp) // 아이템 간 간격
        ) {
            items(products) { product ->
                ProductCard(product = product)
            }
        }
    }
}

@Composable
fun ProductCard(product: ProductItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = { /* TODO: 물품 상세 화면으로 이동 로직 */ }
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 물품 이미지
            Image(
                painter = painterResource(id = product.imageUrl), // 실제 앱에서는 Coil/Glide 등으로 URL 이미지 로드
                contentDescription = product.title,
                modifier = Modifier
                    .size(100.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            // 물품 정보
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2 // 제목이 길 경우 2줄로 제한
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = product.location,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = product.price,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // 좋아요 아이콘 및 개수
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "좋아요",
                    tint = Color.Gray
                )
                Text(
                    text = product.likes.toString(),
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListScreenPreview() {
    // 예시 데이터
    val sampleProducts = listOf(
        ProductItem("1", "빈티지 카메라 판매합니다", "150,000원", "서울시 강남구", 12, android.R.drawable.ic_menu_camera),
        ProductItem("3", "노이즈 캔슬링 헤드폰", "220,000원", "부산시 해운대구", 25, android.R.drawable.ic_dialog_info), // 적절한 아이콘으로 교체 필요
        ProductItem("4", "게임용 노트북 급처", "750,000원", "인천시 남동구", 8, android.R.drawable.ic_dialog_dialer) // 적절한 아이콘으로 교체 필요
    )
    MaterialTheme {
        ProductListScreen(products = sampleProducts)
    }
}
