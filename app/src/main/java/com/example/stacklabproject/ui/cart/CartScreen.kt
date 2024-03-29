package com.example.stacklabproject.ui.cart


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.stacklabproject.ui.utils.CartItem
import com.example.stacklabproject.ui.utils.CartList
import com.example.stacklabproject.ui.utils.CustButton
import com.example.stacklabproject.ui.utils.ShoppingCartHeader
import com.example.stacklabproject.ui.utils.cartList

@Composable
fun CartScreen(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }
    val cartItemsState = remember { mutableStateListOf<CartItem>() }
    cartItemsState.clear()
    cartItemsState.addAll(cartList)
    val total by remember { derivedStateOf { calculateTotalPrice(cartItemsState) } }
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFC5BAEC))
    ) {
        ShoppingCartHeader(onBackClicked = { navController.navigate("mainScreen") })
        CartList(cartItems = cartItemsState) { product ->
            cartItemsState.remove(product)
            cartList.remove(product)
            Toast.makeText(context,
                " ${product.product.name} removed",
                Toast.LENGTH_SHORT).show()
        }
        Spacer(modifier = Modifier.weight(1f))

        HorizontalDivider(modifier = Modifier.fillMaxWidth(), color = Color.Black)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
//                .background(color = Color(0xFF897CB9))
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "SUBTOTAL:",
                fontSize = 22.sp,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF3A3094)
            )
            Spacer(modifier = Modifier.weight(1f)) // Add space between "Total" and total price
            Text(
                text = "$total",
                fontSize = 22.sp,
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF3A3094)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustButton(
                onClick = { showDialog = true },
                title = "CHECKOUT (${cartItemsState.size})"
            )
        }

        if (showDialog) {
            CheckoutPopup(onClose = {
                cartList.clear()
                showDialog = false
                navController.navigate("mainScreen")
            })
        }
    }
}

@Composable
fun CheckoutPopup(onClose: () -> Unit) {
    AlertDialog(
        onDismissRequest = onClose,
        text = { Text("The order has been placed successfully",
            fontWeight = FontWeight.Bold)},

        confirmButton = {
            TextButton(
                onClick = onClose
            ) {
                Text("OK")
            }
        }
    )
}


fun calculateTotalPrice(products: List<CartItem>): Int {
    return products.sumOf { it.product.price.replace(",", "").toInt() }
}
