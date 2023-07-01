package com.example.frontendmentorandroidcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.example.frontendmentorandroidcompose.R
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme

@OptIn(ExperimentalMotionApi::class)
@Composable
fun TipCalculatorApp() {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(Color(0xFFC5E4E7))
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MotionLayout(
            motionScene = MotionScene(content = motionScene),
            progress = (scrollState.value.toFloat()) / scrollState.maxValue.toFloat(),
            modifier = Modifier
                .fillMaxWidth().height(160.dp).defaultMinSize(minHeight = 30.dp)


        ) {


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .layoutId("box")
            )
            Text(
                text = "SPLI",
                fontSize = 24.sp,
                letterSpacing = 15.sp,
                color = Color(0xFF48686B),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.layoutId("first_text")
            )
            Text(
                text = "TTER",
                fontSize = 24.sp,
                letterSpacing = 15.sp,
                color = Color(0xFF48686B),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.layoutId("second_text")
            )


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                )
                .background(Color.White)

        ) {
            Bill(
                modifier = Modifier.padding(vertical = 22.dp, horizontal = 25.dp)
            )
            SelectTip(modifier = Modifier.padding(vertical = 8.dp, horizontal = 25.dp))

            NumberOfPeople(modifier = Modifier.padding(vertical = 18.dp, horizontal = 25.dp))

            CardResult(modifier = Modifier.padding(vertical = 16.dp, horizontal = 25.dp))

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bill(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Bill", fontSize = 18.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = "142.55",
            onValueChange = {},
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(60.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFF2F9FB)),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_attach_money_24),
                    contentDescription = null,
                    tint = Color.LightGray
                )
            },
            singleLine = true
        )
    }
}

@Composable
fun SelectTip(modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text(
            text = "Select Tip %",
            fontSize = 18.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF024A48)),
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "5%", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF024A48)),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "10%", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27C1AD)),
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "15%",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF024A48)
                )
            }
            Spacer(modifier = Modifier.width(18.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF024A48)),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "25%", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF024A48)),
                onClick = {},
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "50%", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(18.dp))
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD6E6E2)),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "    Custom",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(
                        0xFF036865
                    ),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberOfPeople(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Number of People", fontSize = 18.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = "5",
            onValueChange = {},
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(60.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            ),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFF2F9FB)),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = null,
                    tint = Color.LightGray
                )
            },
            singleLine = true
        )
    }
}

@Composable
fun CardResult(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color(0xFF024A48))
    ) {
        Column(
            modifier = Modifier.padding(top = 32.dp, bottom = 22.dp, start = 25.dp, end = 25.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(text = "Tip Amount", color = Color.White)
                    Text(text = "/ person", color = Color.LightGray)
                }
                Text(
                    text = "$4.27",
                    color = Color(0xFF27C1AD),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(text = "Total", color = Color.White)
                    Text(text = "/ person", color = Color.LightGray)
                }
                Text(
                    text = "$32,79",
                    color = Color(0xFF27C1AD),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27C1AD)),
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Reset",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF024A48)
                )
            }
        }
    }
}

@Preview
@Composable
fun TipCalculatorAppPrev() {
    FrontendMentorAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TipCalculatorApp()
        }
    }
}