package com.example.test_edu_project

import android.content.Intent
import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_edu_project.ui.theme.Test_edu_projectTheme

class MainActivity : ComponentActivity() {

    var version = "3.10.7"
    var buildNumber = "300.183"
    var osVersion = "14.6"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF000027)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                problemButton(version = version, buildNumber = buildNumber, osVersion = osVersion)
            }
        }
    }

    @Composable
    private fun problemButton(
        version: String,
        buildNumber: String,
        osVersion: String
    ) {
        TextButton(
            modifier = Modifier
                .height(40.dp)
                .width(304.dp),
            shape = RoundedCornerShape(100.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0x33808093)
            ),
            onClick = { val navigate = Intent(this@MainActivity, SystemInfoActivity::class.java)
                navigate
                    .putExtra("version", version)
                    .putExtra("buildNumber", buildNumber)
                    .putExtra("osVersion", osVersion)
                startActivity(navigate)
            }) {
            Text(text = "Сообщить о проблеме")
        }
    }
}
