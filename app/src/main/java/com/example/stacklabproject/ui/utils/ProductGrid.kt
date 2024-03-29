import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.stacklabproject.ui.utils.Product

@Composable
fun ProductList(
    products: List<Product>,
    onAddToCartClick: (Product) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(products) { product ->
            ProductCard(
                productName = product.name,
                price = product.price,
                imageResId = product.imageResId,
                onAddToCartClick = { onAddToCartClick(product) }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}



@Composable
fun ProductCard(
    imageResId: Int,
    productName: String,
    price: String,
    onAddToCartClick: ()->Unit
) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFDFE9EB ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Price: $price",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.W600,
                modifier = Modifier
                    .align(Alignment.End)
            )


            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop

            )

            Text(
                text = productName,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { onAddToCartClick() },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF3A3094)),
            ) {
                Text(text = "Add to Cart")
            }
        }

    }
}
