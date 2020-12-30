package ru.sulatskov.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetApp()
        }
    }
}