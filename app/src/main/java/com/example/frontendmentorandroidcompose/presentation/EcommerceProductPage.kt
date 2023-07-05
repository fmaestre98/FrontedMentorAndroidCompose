package com.example.frontendmentorandroidcompose.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontendmentorandroidcompose.R
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EcommerceProductPage() {
    val sneakers = listOf(
        R.drawable.air_jordan,
        R.drawable.expansion,
        R.drawable.snakers2,
        R.drawable.snakers3,
        R.drawable.snakers4
    )
    Scaffold(topBar = { TopBar() }) {
        val scrollState= rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ImagesSlider(sneakers = sneakers)
            BodyText()
            AddToCartComponent()
        }
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagesSlider(modifier: Modifier = Modifier, sneakers: List<Int>) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(330.dp)
    ) {
        HorizontalPager(pageCount = sneakers.size, state = pagerState, key = { sneakers[it] }) {
            Image(
                painter = painterResource(id = sneakers[it]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        IconButton(
            onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            },
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.CenterEnd)
                .width(40.dp)
                .height(40.dp)
                .clip(
                    CircleShape
                ),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_forward_ios_fill0_wght400_grad0_opsz48),
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        }

        IconButton(
            onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                }
            },
            modifier = Modifier
                .padding(15.dp)
                .align(Alignment.CenterStart)
                .width(40.dp)
                .height(40.dp)
                .clip(
                    CircleShape
                ),
            colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back_ios_fill0_wght400_grad0_opsz48),
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}

@Composable
fun BodyText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 18.dp)
            .fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Text(
            text = "SNEAKER COMPANY",
            color = Color(0xFFFF7C1A),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Fall Limited Edition", fontSize = 26.sp, fontWeight = FontWeight.Bold)
            Text(text = "Sneakers", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "These low-profile snakers are you perfect",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Text(
                text = "casual wear companion. Featuring a durable",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Text(
                text = "rubber outer sole, they'll withstand everything",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Text(
                text = "the weather can offer.",
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )

        }
    }
}

@Composable
fun AddToCartComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 25.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "$125.00", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "50%",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .height(30.dp)
                        .width(55.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(
                            Color(0xA3FDD6B8)
                        ),
                    color = Color(0xFFFF7C1A),
                    textAlign = TextAlign.Center
                )
            }
            Text(
                text = "$250.00",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray,
                textDecoration = TextDecoration.LineThrough
            )

        }
        TextField(
            value = "0",
            onValueChange = {},
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(7.dp)),
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.remove_fill0_wght400_grad0_opsz48),
                        contentDescription = null,
                        tint = Color(0xFFFF7C1A),
                        modifier = Modifier.width(30.dp)
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color(0xFFFF7C1A)
                    )
                }
            },
            colors = TextFieldDefaults.colors(unfocusedContainerColor = Color(0xFFFCEFE3))
        )
        Button(
            onClick = {},
            modifier = Modifier
                .height(55.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7C1A)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
            Text(text = "Add to cart", fontSize = 20.sp, fontWeight = FontWeight.Bold,modifier= Modifier.padding(start = 10.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = "sneakers", fontWeight = FontWeight.Bold, fontSize = 26.sp, color = Color(
                    0xFF0E141A
                )
            )
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null, tint = Color.Gray)

            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Add Items")
            }
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Add Items")
            }
        },
    )
}


@Preview
@Composable
fun EcommerceProductPagePrev() {
    FrontendMentorAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            EcommerceProductPage()
        }
    }
}

