package com.example.frontendmentorandroidcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.frontendmentorandroidcompose.presentation.EcommerceProductPage
import com.example.frontendmentorandroidcompose.presentation.ExamplesList
import com.example.frontendmentorandroidcompose.presentation.LinkSharingApp.LinkSharingApp
import com.example.frontendmentorandroidcompose.presentation.ResultSummaryComponent
import com.example.frontendmentorandroidcompose.presentation.TipCalculatorApp
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrontendMentorAndroidComposeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val currentBackStack by navController.currentBackStackEntryAsState()
                // Fetch your currentDestination:
                val currentDestination = currentBackStack?.destination

                val windowSize = calculateWindowSizeClass(this)

                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FrontExamplesNavHost(
                        navController = navController,
                        windowSize = windowSize,
                        modifier = Modifier.background(
                            Color.Transparent
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun FrontExamplesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    windowSize: WindowSizeClass,
) {
    NavHost(
        navController = navController,
        startDestination = "LIST",
        modifier = modifier
    ) {
        composable(route = "LIST") {
            ExamplesList(navController = navController)
        }

        composable(route = "Results summary component") {
            ResultSummaryComponent(windowSize = windowSize.widthSizeClass)
        }

        composable(
            route = "Tip calculator app",
        ) {
            TipCalculatorApp()
        }

        composable(
            route = "E-commerce product page",
        ) {
            EcommerceProductPage()
        }
        composable(
            route = "Link-sharing app",
        ) {
           LinkSharingApp()
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FrontendMentorAndroidComposeTheme {

    }
}