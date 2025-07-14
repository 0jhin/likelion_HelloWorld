package com.example.helloworld1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.helloworld1.ui.theme.HelloWorld1Theme
import com.example.helloworld1.LoginScreenWithRedButton
import com.example.helloworld1.LoginScreen
import androidx.compose.ui.res.painterResource // 아이콘 리소스 사용을 위해 추가
import com.example.helloworld1.SocialLoginScreen
class MainActivity : ComponentActivity() {

    var title = "안녕"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        //generate random number
        val random = (0..100).random()
        title = random.toString()


        setContent {
            HelloWorld1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "$title, $title, $title",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    LoginScreen()
    SocialLoginScreen()
}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorld1Theme {
        Greeting("Android")
    }
}


