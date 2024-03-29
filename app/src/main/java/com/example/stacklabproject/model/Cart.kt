package com.example.stacklabproject.model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import androidx.navigation.compose.rememberNavController
import com.example.stacklabproject.ui.cart.CartScreen

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {
            setContent {
                CartScreen(navController = rememberNavController())
            }
        }
    }


    @Preview
    @Composable
    fun PreviewScreenComposable() {
        CartScreen(navController = rememberNavController())
    }

}


