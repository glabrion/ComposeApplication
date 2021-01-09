package ru.sulatskov.composeapplication.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import ru.sulatskov.composeapplication.R
import ru.sulatskov.composeapplication.ui.screens.placeholder.PlaceholderScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.error.observe(this) {
            Toast.makeText(this, getString(R.string.error_internet_connection), Toast.LENGTH_SHORT).show()
            setContent {
                PlaceholderScreen()
            }
        }

        setContent {
            JetApp(viewModel, this)
        }
    }
}
