package com.example.frontendmentorandroidcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontendmentorandroidcompose.R
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme


@Composable
fun ResultSummaryComponent(modifier: Modifier = Modifier, windowSize: WindowWidthSizeClass) {
    if (windowSize == WindowWidthSizeClass.Medium || windowSize == WindowWidthSizeClass.Expanded) {
        Row(modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
            Scored(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Column(modifier= Modifier.weight(1f)) {
                Summary(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(30.dp)
                )

                Button(
                    colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF303B5A)),
                    onClick = { },
                    modifier = Modifier
                        .padding(vertical = 25.dp, horizontal = 25.dp)
                        .fillMaxWidth()
                        .height(65.dp),

                    ) {
                    Text(text = "Continue", fontSize = 18.sp, color = Color(0xFFBFAAFE))
                }
            }

        }


    } else {
        Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Scored(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(.9f)
            )
            Summary(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(20.dp)
            )

            Button(
                colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF303B5A)),
                onClick = { },
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 25.dp)
                    .fillMaxWidth()
                    .height(65.dp)
                    .weight(.2f),

                ) {
                Text(text = "Continue", fontSize = 18.sp, color = Color(0xFFBFAAFE))
            }

        }

    }

}

@Composable
fun Scored(modifier: Modifier = Modifier) {
    val colorsCard = arrayOf(
        0.0f to Color(0xFF6644FA),
        1f to Color(0xFF302CE9)
    )
    val colorsCircle = arrayOf(
        0.0f to Color(0xFF4A22CA),
        1f to Color(0xFF4734F1)
    )
    Card(
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 38.dp,
            bottomEnd = 38.dp
        ), modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(colorStops = colorsCard))
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = "Your Result",
                color = Color(0xFFBFAAFE),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .height(145.dp)
                    .width(145.dp)
                    .background(Brush.verticalGradient(colorStops = colorsCircle)),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        text = "76",
                        fontSize = 50.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,

                        )
                    Text(text = "of 100", color = Color(0xFF5B4EE2), fontSize = 16.sp)
                }

            }
            Text(
                text = "Great",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Column {
                Text(
                    text = "You scored higher than 65% of the",
                    color = Color(0xFFBFAAFE),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = "people who have taken these tests.",
                    color = Color(0xFFBFAAFE),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

        }
    }

}

@Composable
fun Summary(modifier: Modifier = Modifier) {
    val scrollState= rememberScrollState()
    Column(modifier = modifier.verticalScroll(scrollState), verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(text = "Summary", fontWeight = FontWeight.Bold, fontSize = 20.sp)

        SumaryItem(
            drawableRes = R.drawable.bolt,
            text = "Reaction",
            score = 80,
            backgroundColor = Color(0xFFFFF7F5),
            tintColor = Color(0xFFE45A5E)
        )
        SumaryItem(
            drawableRes = R.drawable.memory,
            text = "Memory",
            score = 92,
            backgroundColor = Color(0xFFFFFCF1),
            tintColor = Color(
                0xFFF1D25F
            )
        )
        SumaryItem(
            drawableRes = R.drawable.quick_phrases,
            text = "Verbal",
            score = 61,
            backgroundColor = Color(0xFFF2FBFA),
            tintColor = Color(0xFF16EED6)
        )
        SumaryItem(
            drawableRes = R.drawable.visibility,
            text = "Visual",
            score = 72,
            backgroundColor = Color(0xFFF3F3FF),
            tintColor = Color(0xFF3232F3)
        )
    }

}

@Composable
fun SumaryItem(
    modifier: Modifier = Modifier,
    drawableRes: Int,
    text: String,
    score: Int,
    backgroundColor: Color,
    tintColor: Color
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(id = drawableRes),
                modifier = Modifier.width(22.dp),
                contentDescription = null,
                tint = tintColor,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = text, color = tintColor, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = score.toString(), fontWeight = FontWeight.Bold)
            Text(text = " / 100", color = Color.Gray, fontWeight = FontWeight.Bold)
        }

    }
}


@Preview
@Composable
fun ResultSumaryComponentPrev() {
    FrontendMentorAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ResultSummaryComponent(windowSize = WindowWidthSizeClass.Compact)

        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun ResultSumaryComponentPrevExpanded() {
    FrontendMentorAndroidComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ResultSummaryComponent(windowSize = WindowWidthSizeClass.Expanded)

        }
    }
}

