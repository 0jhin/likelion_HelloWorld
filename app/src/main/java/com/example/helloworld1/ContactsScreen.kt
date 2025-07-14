package com.example.helloworld1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// import com.yourpackage.R // 실제 R 파일을 임포트해야 합니다.

// 연락처 데이터 클래스
data class Contact(
    val id: String,
    val name: String,
    val phoneNumber: String,
    val profileImageResId: Int? = null // 예시로 Drawable 리소스 ID, 실제로는 Uri
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen(contacts: List<Contact>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("연락처") },
                actions = {
                    IconButton(onClick = { /* TODO: 검색 기능 구현 */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "검색")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO: 새 연락처 추가 화면으로 이동 */ }) {
                Icon(Icons.Filled.Add, contentDescription = "새 연락처 추가")
            }
        }
    ) { innerPadding ->
        if (contacts.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("연락처가 없습니다.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(contacts) { contact ->
                    ContactItem(contact = contact, onClick = {
                        /* TODO: 연락처 상세 화면으로 이동 또는 전화 걸기 */
                    })
                    Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f))
                }
            }
        }
    }
}

@Composable
fun ContactItem(contact: Contact, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // 프로필 이미지 또는 아이콘
        if (contact.profileImageResId != null) {
            Image(
                painter = painterResource(id = contact.profileImageResId),
                contentDescription = "${contact.name} 프로필 사진",
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "기본 프로필 아이콘",
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.secondary
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // 이름 및 전화번호
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = contact.name,
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = contact.phoneNumber,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContactsScreenPreview_WithContacts() {
    val sampleContacts = listOf(
        Contact("1", "김철수", "010-1234-5678", android.R.drawable.sym_contact_card),
        Contact("2", "이영희", "010-8765-4321"),
        Contact("3", "박민준", "010-0000-1111", android.R.drawable.sym_def_app_icon),
        Contact("4", "최지우", "010-2222-3333")
    )
    MaterialTheme {
        ContactsScreen(contacts = sampleContacts)
    }
}

@Preview(showBackground = true,)
@Composable
fun ContactsScreenPreview_NoContacts() {
    MaterialTheme {
        ContactsScreen(contacts = emptyList())
    }
}
