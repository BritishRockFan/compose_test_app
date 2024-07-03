package com.example.test_edu_project.screens

import android.widget.Toast
import androidx.activity.OnBackPressedDispatcher
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_edu_project.R
import com.example.test_edu_project.items.OsInfoItem
import com.example.test_edu_project.items.ReportButton
import com.example.test_edu_project.ui.theme.DividerColor
import com.example.test_edu_project.ui.theme.GrayColor
import com.example.test_edu_project.ui.theme.PrimaryBackground
import com.example.test_edu_project.ui.theme.PrimaryTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportScreen(
    appVersion: String,
    buildNumber: Int,
    osVersion: String
) {
    val context = LocalContext.current

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
                            OnBackPressedDispatcher().onBackPressed() //TODO
                        }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = null,
                            tint = PrimaryTextColor
                        )
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
                    value = appVersion
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
                    value = buildNumber.toString()
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
                    value = osVersion
                )
                Spacer(Modifier.height(8.dp))
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = DividerColor,
                )
                Spacer(Modifier.height(36.dp))
                ReportButton(onClick = {
                    Toast.makeText(context, R.string.toast_message, Toast.LENGTH_LONG).show()
                })
                Spacer(Modifier.weight(1f))
                Text(
                    text = stringResource(id = R.string.holding_name),
                    color = GrayColor
                )
                Spacer(Modifier.height(8.dp))
                Row {
                    Text(
                        text = stringResource(id = R.string.phone_number),
                        color = PrimaryTextColor
                    )
                    Spacer(Modifier.width(18.dp))
                    Text(
                        text = stringResource(id = R.string.help_email), 
                        color = PrimaryTextColor
                    )
                }
                Spacer(Modifier.height(8.dp))
                Text(
                    text = stringResource(id = R.string.ertelecom_site),
                    color = PrimaryTextColor
                )
            }
        }
    }
}