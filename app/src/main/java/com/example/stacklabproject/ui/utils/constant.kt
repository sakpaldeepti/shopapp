package com.example.stacklabproject.ui.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustButton(onClick: () -> Unit,title:String){
    ElevatedButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(0.8f) // Adjust width as needed
            .height(80.dp)
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF3A3094)),

    ) {
        Text(
            title,
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White
        )
    }
}
