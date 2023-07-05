package com.example.frontendmentorandroidcompose.presentation.LinkSharingApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.frontendmentorandroidcompose.R
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme

@Composable
fun LinkSharingApp() {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    // Fetch your currentDestination:
    val currentDestination = currentBackStack?.destination
    Scaffold(modifier = Modifier.background(Color.DarkGray), topBar = {
        TopAppBarLinkSharing(currentDestination = currentDestination, toProfileDetails = {
            navController.navigate(
                "Profile details"
            )
        },
            toCustomizeLinks = {
                navController.navigate(
                    "Customize your Links"
                )
            }
        ) {
            navController.navigate(
                "Profile Preview"
            )
        }
    }) {
        LinkSharingNavHost(modifier = Modifier.padding(it), navController = navController)
    }

}

@Composable
fun LinkSharingNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "Customize your Links",
        modifier = modifier
    ) {
        composable(route = "Customize your Links") {
            CustomizeYourLinks()
        }

        composable(route = "Profile details") {
            ProfileDetails()
        }

        composable(
            route = "Profile Preview",
        ) {
            ProfilePreview()
        }
    }
}

@Composable
fun TopAppBarLinkSharing(
    modifier: Modifier = Modifier,
    toProfileDetails: () -> Unit,
    toCustomizeLinks: () -> Unit,
    currentDestination: NavDestination?,
    toProfilePreview: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.icontop),
            contentDescription = null, modifier = Modifier
                .height(50.dp)
                .width(60.dp)
                .padding(start = 15.dp)
        )
        Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = toCustomizeLinks, modifier = Modifier
                    .clip(
                        RoundedCornerShape(5.dp)
                    )
                    .background(
                        if (currentDestination?.route.equals("Customize your Links")) Color(
                            0xFFF0EAFF
                        ) else Color.White
                    )
                    .height(35.dp)
                    .width(55.dp)

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.meiconlink),
                    contentDescription = null,
                    modifier = Modifier.width(25.dp),
                    tint = if (currentDestination?.route.equals("Customize your Links")) Color(
                        0xFFFEFEFE
                    ) else Color.Gray
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            IconButton(
                onClick = toProfileDetails, modifier = Modifier
                    .clip(
                        RoundedCornerShape(5.dp)
                    )
                    .background(
                        if (currentDestination?.route.equals("Profile details")) Color(
                            0xFFF0EAFF
                        ) else Color.White
                    )
                    .height(35.dp)
                    .width(55.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.account_circle_fill0_wght400_grad0_opsz48),
                    contentDescription = null,
                    modifier = Modifier.width(20.dp),
                    tint = if (currentDestination?.route.equals("Profile details")) Color(0xFFFEFEFE) else Color.Gray
                )
            }
        }
        IconButton(
            onClick = toProfilePreview, modifier = Modifier
                .padding(end = 15.dp)
                .border(width = 1.dp, color = Color(0xFF623BFF), shape = RoundedCornerShape(5.dp))
                .height(35.dp)
                .width(55.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.visibility),
                contentDescription = null,
                modifier = Modifier.width(20.dp), tint = Color(0xFF623BFF)
            )
        }
    }
}


@Preview
@Composable
fun LinkSharingAppPrev() {
    FrontendMentorAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LinkSharingApp()
        }
    }
}