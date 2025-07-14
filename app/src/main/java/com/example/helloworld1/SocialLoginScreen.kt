package com.example.helloworld1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource // 아이콘 리소스 사용을 위해 추가


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SocialLoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "로그인",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("이메일 주소") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("비밀번호") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation() // 비밀번호 숨김 처리
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* TODO: 이메일/비밀번호 로그인 로직 구현 */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("로그인")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("또는", color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        // Google 로그인 버튼
        Button(
            onClick = { /* TODO: Google 로그인 로직 구현 */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
        ) {
            // 실제 프로젝트에서는 R.drawable.ic_google_logo 와 같이 리소스를 참조합니다.
            // 여기서는 예시로 플레이스홀더 아이콘을 사용합니다. (실제 아이콘으로 교체 필요)
            // Image(painter = painterResource(id = android.R.drawable.ic_menu_search), contentDescription = "Google 로고")
            Text("Google 계정으로 로그인", modifier = Modifier.padding(start = 8.dp))
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Facebook 로그인 버튼
        Button(
            onClick = { /* TODO: Facebook 로그인 로직 구현 */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1877F2)) // Facebook 파란색
        ) {
            // 실제 프로젝트에서는 R.drawable.ic_facebook_logo 와 같이 리소스를 참조합니다.
            // 여기서는 예시로 플레이스홀더 아이콘을 사용합니다. (실제 아이콘으로 교체 필요)
            // Image(painter = painterResource(id = android.R.drawable.ic_menu_share), contentDescription = "Facebook 로고")
            Text("Facebook 계정으로 로그인", modifier = Modifier.padding(start = 8.dp), color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        TextButton(onClick = { /* TODO: 회원가입 화면으로 이동 */ }) {
            Text("계정이 없으신가요? 가입하기")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SocialLoginScreenPreview() {
    MaterialTheme { // 앱의 테마를 적용하는 것이 좋습니다.
        SocialLoginScreen()
    }
}