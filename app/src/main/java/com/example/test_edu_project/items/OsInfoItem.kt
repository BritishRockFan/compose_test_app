package com.example.test_edu_project.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test_edu_project.ui.theme.PrimaryTextColor

@Composable
fun OsInfoItem(
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
                lineHeight = 28.sp
            ),
            color = PrimaryTextColor
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = value,
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 28.sp
            ),
            color = PrimaryTextColor
        )
    }
}