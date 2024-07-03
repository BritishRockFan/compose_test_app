package com.example.test_edu_project.items

import android.content.Intent
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.test_edu_project.R
import com.example.test_edu_project.SystemInfoActivity
import com.example.test_edu_project.ui.theme.ButtonColor

@Composable
fun ReportButton(
    onClick: () -> Unit
) {
    TextButton(
        modifier = Modifier
            .height(40.dp)
            .width(304.dp),
        shape = RoundedCornerShape(100.dp),
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonColor
        ),
        onClick = onClick ) {
        Text(text = stringResource(id = R.string.report_button))
    }
}