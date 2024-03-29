package com.example.stacklabproject.ui.home


//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stacklabproject.ui.categories.Category1Screen
import com.example.stacklabproject.ui.categories.Category2Screen
import com.example.stacklabproject.ui.utils.CustButton
import com.example.stacklabproject.ui.utils.cartList
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.background(color = Color(0xFFA895EE))) {
        // TabRow for selecting categories
        TabRow(selectedTabIndex = selectedTabIndex) {
            FancyTab(title = "Mobiles", onClick = { selectedTabIndex = 0 }, selected = selectedTabIndex == 0)
            FancyTab(title = "Laptops", onClick = { selectedTabIndex = 1 }, selected = selectedTabIndex == 1)
            // Add more tabs as needed
        }

        // Displaying the selected category screen
        when (selectedTabIndex) {
            0 -> Category1Screen()
            1 -> Category2Screen()
            // Add more cases for additional categories
        }

        // Bottom section (e.g., add to cart button)

            Spacer(modifier = Modifier.weight(1f))
            AddToCartButton(navController)

    }
}

@Composable
fun FancyTab(title: String, onClick: () -> Unit, selected: Boolean) {
    Tab(selected, onClick) {
        Column(
            Modifier
                .background(color = Color(0xFF3A3094))
                .padding(10.dp)
                .fillMaxHeight(1F)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                Modifier
                    .size(10.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(if (selected) Color.Transparent else Color.Unspecified)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun AddToCartButton(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val cartItemCount by remember { derivedStateOf { cartList.count() } }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustButton(
            onClick = { coroutineScope.launch {navController.navigate("cartScreen") } },
            title = "GO TO CART"
        )

    }
}





