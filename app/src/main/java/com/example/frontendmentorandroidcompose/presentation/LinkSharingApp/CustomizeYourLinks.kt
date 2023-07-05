package com.example.frontendmentorandroidcompose.presentation.LinkSharingApp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.frontendmentorandroidcompose.R
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme

@Composable
fun CustomizeYourLinks(linksAppViewModel: LinksAppViewModel = viewModel()) {

    val linksList: List<Pair<String, String>> = linksAppViewModel.linksList
    Column(
        modifier = Modifier
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
                Text(text = "Customize your Links", fontWeight = FontWeight.Bold, fontSize = 26.sp)
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Add/Edit/Remove links below and then",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Text(
                    text = "share all your profiles with the world",
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(35.dp))
                OutlinedButton(
                    onClick = {
                        linksAppViewModel.addElement()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF623BFF)),
                    border = BorderStroke(1.dp, color = Color(0xFF623BFF))


                ) {
                    Text(text = "+ Add new link")
                }
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    itemsIndexed(linksList) { index, item ->
                        LinkItem(pair = item, index = index + 1, removeElement = linksAppViewModel::removeElement)
                }
                item {
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
                                .padding(vertical = 25.dp)
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
        }

    }

}
}

@Composable
fun LinkItem(
    modifier: Modifier = Modifier,
    pair: Pair<String, String>,
    index: Int,
    removeElement: (i: Int) -> Unit
) {
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.equal_fill0_wght400_grad0_opsz48),
                        contentDescription = null,
                        modifier = Modifier.width(25.dp),
                        tint = Color.Gray
                    )
                    Text(text = "Link #$index", color = Color.Gray)
                }
                Text(
                    text = "Remove",
                    color = Color.Gray,
                    modifier = Modifier.clickable {
                        removeElement(index - 1)
                    })

            }
            Text(text = "Plataform", color = Color.Gray)
            Demo_ExposedDropdownMenuBox(pair = pair)
            Text(text = "Link", color = Color.Gray)
            TextField(
                value = pair.second,
                onValueChange = {},
                colors = TextFieldDefaults.colors(unfocusedContainerColor = Color.White),
                maxLines = 1
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Demo_ExposedDropdownMenuBox(pair: Pair<String, String>) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    val socialMedia = listOf("Youtube", "LinkedIn", "Twiter", "Facebook", "Github", "Instagram")
    val socialMediaIcons = listOf(
        R.drawable.youtube,
        R.drawable.linkedin,
        R.drawable.twitter,
        R.drawable.facebook_circle,
        R.drawable.github,
        R.drawable.instagram_logo
    )
    var selectedText by remember { mutableStateOf(pair.first) }
    var selectedIconText by remember { mutableStateOf(socialMedia.indexOf(pair.first)) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp, vertical = 15.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = socialMediaIcons[selectedIconText]),
                        contentDescription = null,
                        modifier = Modifier.size(35.dp)
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                ),
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                socialMedia.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = socialMediaIcons[index]),
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)
                            )
                        },
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
                            selectedIconText = socialMedia.indexOf(item)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CustomizeYourLinksPrev() {
    FrontendMentorAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CustomizeYourLinks()
        }
    }
}