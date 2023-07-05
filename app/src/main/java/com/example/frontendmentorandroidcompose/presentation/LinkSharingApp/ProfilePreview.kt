package com.example.frontendmentorandroidcompose.presentation.LinkSharingApp

import android.graphics.drawable.AdaptiveIconDrawable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontendmentorandroidcompose.R
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme

@Composable
fun ProfilePreview() {

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            OutlinedButton(
                onClick = {
                },
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .weight(1f)
                    .height(40.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF623BFF)),
                border = BorderStroke(1.dp, color = Color(0xFF623BFF))


            ) {
                Text(text = "Back to Editor")
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .weight(1f)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF623BFF)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Share Link", fontSize = 16.sp)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Ben Wright", fontWeight = FontWeight.Bold, fontSize = 28.sp)
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "ben@example.com",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Gray
            )

            ButtonsLinksList()
        }
    }

}

@Composable
fun ButtonsLinksList(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth().padding(vertical = 25.dp, horizontal = 55.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(20.dp)) {
        ButtonLinksItem(
            backgroundColor = Color(0xFF181818),
            text = "GitHub",
            iconResource = R.drawable.github
        )
        ButtonLinksItem(
            backgroundColor = Color(0xFFE93A38),
            text = "Youtube",
            iconResource = R.drawable.youtube
        )
        ButtonLinksItem(
            backgroundColor = Color(0xFF2B69FE),
            text = "LinkedIn",
            iconResource = R.drawable.linkedin
        )
    }
}

@Composable
fun ButtonLinksItem(
    modifier: Modifier = Modifier,
    onTap: () -> Unit = {},
    backgroundColor: Color,
    text: String,
    iconResource: Int
) {
    Button(
        modifier = modifier.height(55.dp),
        onClick = onTap,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(35.dp).padding(end = 10.dp)
            )
            Text(text = text, color = Color.White, fontSize = 18.sp)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

    }
}

@Preview
@Composable
fun ProfilePreviewPrev() {
    FrontendMentorAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            ProfilePreview()
        }
    }
}