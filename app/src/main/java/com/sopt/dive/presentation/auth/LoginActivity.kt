package com.sopt.dive.presentation.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.core.ui.component.textfield.LabelTextField
import com.sopt.dive.core.ui.component.textfield.PasswordTextField

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiveTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun LoginScreen(modifier: Modifier = Modifier) {
    var idText by remember { mutableStateOf("") }
    var pwdText by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 18.dp, horizontal = 16.dp)
    ) {
        Text(
            text = "Welcome To SOPT",
            fontSize = 30.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(50.dp))

        Text(
            text = "ID",
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
        )

        LabelTextField(
            value = idText,
            onValueChange = { idText = it },
            placeholder = stringResource(R.string.id_hint)
        )

        Spacer(Modifier.height(30.dp))

        Text(
            text = "PW",
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
        )

        PasswordTextField(
            value = pwdText,
            onValueChange = { pwdText = it },
            placeholder = stringResource(R.string.pwd_hint)
        )
        
        Spacer(Modifier.weight(1f))

        Text(
            text = "Welcome To SOPT",
            fontSize = 18.sp,
            color = Color.White,
            style = TextStyle(fontWeight = FontWeight.Normal),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.Gray)
                .padding(vertical = 12.dp)
                .fillMaxWidth()
                .clickable(onClick = {})
        )
        
        Text(
            text = "회원가입하기",
            fontSize = 14.sp,
            style = TextStyle(fontWeight = FontWeight.Medium),
            color = Color.Gray,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 5.dp)
                .clickable(onClick = {})
                .padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    DiveTheme {
        LoginScreen()
    }
}