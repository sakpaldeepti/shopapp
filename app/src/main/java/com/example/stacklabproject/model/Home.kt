package com.example.stacklabproject.model

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stacklabproject.R
import com.example.stacklabproject.ui.cart.CartScreen
import com.example.stacklabproject.ui.home.HomeScreen

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val composeLayout = findViewById<ComposeView>(R.id.compose_view)
        composeLayout.setContent {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainScreen") {
                    composable("mainScreen") {
                        HomeScreen(navController)
                    }
                    composable("cartScreen") {
                        CartScreen(navController)
                    }
                }
        }
    }
}

@Preview
@Composable
fun PreviewNewScreenComposable() {
        HomeScreen(navController = rememberNavController())

}
