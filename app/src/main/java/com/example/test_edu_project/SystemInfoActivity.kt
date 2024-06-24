package com.example.test_edu_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_edu_project.ui.theme.Test_edu_projectTheme

class SystemInfoActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF000027)), //primary background
                contentWindowInsets = WindowInsets(0.dp),
                topBar = {
                    TopAppBar(
                        colors =
                        TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF000027)),
                        title = {
                        Text(
                            text = "Обратная связь",
                            style = TextStyle(fontSize = 20.sp, lineHeight = 28.sp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = Color(0xFFECEFF9), // primary text color

                        )
                    },
                        navigationIcon = {
                            IconButton(onClick = {
                                onBackPressedDispatcher.onBackPressed()
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_back),
                                    contentDescription = null,
                                    tint = Color(0xFFECEFF9))
                            }
                        }
                        )
                }
                ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF000027))
                ) {
                    Text(
                        text = "Another Activity",
                        modifier = Modifier.padding(innerPadding),
                        color = Color(0xFFD32F2F)
                    )
                    TextButton(
                        modifier = Modifier
                            .height(40.dp)
                            .width(304.dp),
                        shape = RoundedCornerShape(100.dp),
                        enabled = true,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0x33808093)
                        ),
                        onClick = {
                           Toast.makeText(baseContext, "Сообщение отправлено", Toast.LENGTH_LONG).show()
                        }) {
                        Text(text = "Сообщить о проблеме")
                    }
                }
            }
        }
    }
}
