package com.example.stacklabproject.ui.utils

import com.example.stacklabproject.R

val mobileList = listOf(
    Product("Redmi 10", "10,000", R.drawable.mobile1),
    Product("Redmi 7a", "20,000", R.drawable.mobile2),
    Product("Samsung A14", "30,000", R.drawable.mobile3),
    // Add more sample products as needed
)
val laptopList = listOf(
    Product("Dell 7500A", "65,000", R.drawable.laptop1),
    Product("HP 34000s", "78,000", R.drawable.laptop2)
    // Add more sample products as needed
)

//val cartListEx = listOf(
//    CartItem(Product("Dell 7500A", "65,000", R.drawable.laptop1)),
//    CartItem ( Product("Samsung A14", "30,000", R.drawable.mobile3))
//    // Add more sample products as needed
//)

val cartList: MutableList<CartItem> = mutableListOf()


data class Product(val name: String, val price: String, val imageResId: Int)

data class CartItem(val product: Product)
