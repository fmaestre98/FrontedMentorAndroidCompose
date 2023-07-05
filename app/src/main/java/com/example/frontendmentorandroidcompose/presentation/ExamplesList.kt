package com.example.frontendmentorandroidcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ExamplesList(modifier: Modifier = Modifier, navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(20.dp)
            .background(
                Color.Transparent
            )
    ) {
        Text(
            text = "Results summary component",
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { navController.navigate("Results summary component") })
        Text(
            text = "Tip calculator app",
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { navController.navigate("Tip calculator app") })

        Text(
            text = "E-commerce product page",
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { navController.navigate("E-commerce product page") })
        Text(
            text = "Link-sharing app",
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { navController.navigate("Link-sharing app") })


    }


}