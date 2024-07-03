package com.example.test_edu_project

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.example.test_edu_project.fragments.ReportFragment

class SystemInfoActivity : FragmentActivity() {

    private val appVersion = BuildConfig.VERSION_NAME
    private val buildNumber = BuildConfig.VERSION_CODE
    private val osVersion = Build.VERSION.RELEASE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(android.R.id.content, ReportFragment(appVersion, buildNumber, osVersion))
            }
        }
    }
}
