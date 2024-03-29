package com.example.stacklabproject.ui.categories


import ProductList
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.stacklabproject.ui.utils.CartItem
import com.example.stacklabproject.ui.utils.cartList
import com.example.stacklabproject.ui.utils.mobileList

@Composable
fun Category1Screen() {
    val context = LocalContext.current

    ProductList (
        products = mobileList,
        onAddToCartClick = { product ->
            cartList.add(CartItem(product))
            Toast.makeText(context,
                " ${product.name} added to cart",
                Toast.LENGTH_SHORT).show()
        }
    )
}


@Preview
@Composable
fun PreviewNewScreenComposable() {
    Category1Screen()
}


