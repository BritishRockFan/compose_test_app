package com.example.test_edu_project

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_edu_project.ui.theme.ButtonColor
import com.example.test_edu_project.ui.theme.DividerColor
import com.example.test_edu_project.ui.theme.GrayColor
import com.example.test_edu_project.ui.theme.PrimaryBackground
import com.example.test_edu_project.ui.theme.PrimaryTextColor

class SystemInfoActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val version: String? = intent.getStringExtra("version")
            val buildNumber: String? = intent.getStringExtra("buildNumber")
            val osVersion: String? = intent.getStringExtra("osVersion")

            Scaffold(modifier = Modifier
                .fillMaxSize()
                .background(PrimaryBackground), //primary background
                topBar = {
                    CenterAlignedTopAppBar(
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .height(64.dp),
                        colors =
                        TopAppBarDefaults.topAppBarColors(containerColor = PrimaryBackground),
                        title = {
                        Text(
                            text = stringResource(id = R.string.top_bar_title),
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 28.sp),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = PrimaryTextColor,
                        )
                    },
                        navigationIcon = {
                            IconButton(
                                modifier = Modifier
                                    .height(28.dp)
                                    .width(28.dp),
                                onClick = {
                                    onBackPressedDispatcher.onBackPressed()
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_back),
                                    contentDescription = null,
                                    tint = PrimaryTextColor)
                            }
                        }
                        )
                }
                ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(PrimaryBackground)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        OsInfoItem(
                            title = stringResource(id = R.string.app_version),
                            value = version!!, //Do not do that
                        )
                        Spacer(Modifier.height(8.dp))
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = DividerColor,
                        )
                        Spacer(Modifier.height(8.dp))
                        OsInfoItem(
                            title = stringResource(id = R.string.build_number),
                            value = buildNumber!!,
                        )
                        Spacer(Modifier.height(8.dp))
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = DividerColor,
                        )
                        Spacer(Modifier.height(8.dp))
                        OsInfoItem(
                            title = stringResource(id = R.string.os_version),
                            value = osVersion!!,
                        )
                        Spacer(Modifier.height(8.dp))
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = DividerColor,
                        )
                        Spacer(Modifier.height(36.dp))
                        TextButton(
                            modifier = Modifier
                                .height(40.dp)
                                .width(304.dp),
                            shape = RoundedCornerShape(100.dp),
                            enabled = true,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = ButtonColor
                            ),
                            onClick = {
                                Toast.makeText(baseContext, "Сообщение отправлено", Toast.LENGTH_LONG).show()
                            }) {
                            Text(text = stringResource(id = R.string.report_button))
                        }
                        Spacer(Modifier.weight(1f))
                        Text(
                            text = "АО «ЭР-Телеком Холдинг»",
                            color = GrayColor
                        )
                        Spacer(Modifier.height(8.dp))
                        Row {
                            Text(
                                text = "+7 342 000 00 00",
                                color = PrimaryTextColor
                            )
                            Spacer(Modifier.width(18.dp))
                            Text(text = "help@domru.ru", color = PrimaryTextColor)
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(text = "www.ertelecom.ru", color = PrimaryTextColor)
                    }
                }
            }
        }
    }

    @Composable
    private fun OsInfoItem(
        modifier: Modifier = Modifier,
        title: String,
        value: String
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 28.sp),
                color = PrimaryTextColor
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = value,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 28.sp),
                color = PrimaryTextColor
            )
        }
    }
}
