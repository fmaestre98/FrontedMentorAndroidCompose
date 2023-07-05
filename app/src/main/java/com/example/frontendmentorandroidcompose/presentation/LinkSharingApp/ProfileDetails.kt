package com.example.frontendmentorandroidcompose.presentation.LinkSharingApp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontendmentorandroidcompose.R
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme

@Composable
fun ProfileDetails() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .clip(RoundedCornerShape(8.dp))
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .fillMaxWidth()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(text = "Profile Details", fontWeight = FontWeight.Bold, fontSize = 26.sp)
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Add your details to create a personal",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Text(
                    text = "touch to your profile",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(35.dp))

                ProfilePicture()
                FormData()
            }
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 1.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.White)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(vertical = 25.dp, horizontal = 10.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF623BFF)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Save", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun FormData(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFAFA))
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {

            Text(text = "First name*", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = "Ben", onValueChange = {}, colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedTextColor = Color.Gray
                ), shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Last name*", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = "Wright", onValueChange = {}, colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedTextColor = Color.Gray
                ), shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Email", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = "ben@example.com", onValueChange = {}, colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    unfocusedTextColor = Color.Gray
                ), shape = RoundedCornerShape(8.dp)
            )

        }
    }

}

@Composable
fun ProfilePicture(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFAFA))
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Profile Picture",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFEFECFF))
                    .width(240.dp)
                    .height(220.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pasage),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "+ Upload Image",
                    color = Color(0xFF603CFD),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Image must be below 1024x1024px. Use PNG,",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.LightGray
            )
            Text(
                text = "JPG, or BMP format",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.LightGray
            )

        }
    }
}


@Preview
@Composable
fun ProfileDetailsPrev() {
    FrontendMentorAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            ProfileDetails()
        }
    }
}