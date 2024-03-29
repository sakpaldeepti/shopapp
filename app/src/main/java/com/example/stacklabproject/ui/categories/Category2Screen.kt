package com.example.stacklabproject.ui.categories


import ProductList
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.stacklabproject.ui.utils.CartItem
import com.example.stacklabproject.ui.utils.cartList
import com.example.stacklabproject.ui.utils.laptopList

@Composable
fun Category2Screen() {
    val context = LocalContext.current

    ProductList (
        products = laptopList,
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
fun PreviewScreenComposable() {
    Category2Screen()
}