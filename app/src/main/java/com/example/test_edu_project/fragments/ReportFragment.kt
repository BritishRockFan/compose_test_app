package com.example.test_edu_project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.test_edu_project.screens.ReportScreen

class ReportFragment(
    val appVersion: String,
    val buildNumber: Int,
    val osVersion: String
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                ReportScreen(appVersion, buildNumber, osVersion)
            }
        }
    }
}