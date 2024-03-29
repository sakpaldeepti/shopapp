package com.example.stacklabproject.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview
//@Composable
//fun PreviewCartComposable() {
//    cartScrrenDisplay()
//}
//
//@Composable
//fun cartScrrenDisplay() {
//    CartList(cartItems = cartListEx){}
//}
@Composable
fun CartList(cartItems: MutableList<CartItem>, onRemove: (CartItem) -> Unit) {
        LazyColumn {
            items(cartItems) { cartItem ->
                CartProduct(
                    productName = cartItem.product.name,
                    price = cartItem.product.price,
                    imageResId = cartItem.product.imageResId,
                    onRemove = { onRemove(cartItem) }
                )
            };

        }
}
@Composable
fun CartProduct(
    imageResId: Int,
    productName: String,
    price: String,
    onRemove: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFDFE9EB),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = productName,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier =  Modifier
                    .fillMaxWidth(0.7f),
            )
            Spacer(modifier = Modifier.weight(1f))
            Column( Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center)
            {
            Text(
                text = "Price: $price",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.End,
            )
                Spacer(modifier = Modifier.weight(1f))
            TextButton(
                onClick = onRemove ,
            ) {
                Text(text = "Remove")
            }
        }
        }
    }
}



@Composable
fun ShoppingCartHeader(onBackClicked: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color(0xFF3A3094)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClicked) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.size(25.dp))
        }


        Text(
            text = "Cart",
            modifier = Modifier.padding(top = 8.dp),
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            color = Color.White
        )
    }
}
