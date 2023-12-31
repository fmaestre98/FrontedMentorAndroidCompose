package com.example.frontendmentorandroidcompose.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.frontendmentorandroidcompose.R
import com.example.frontendmentorandroidcompose.presentation.TipCalculatorApp.TipCalculatorViewModel
import com.example.frontendmentorandroidcompose.ui.theme.FrontendMentorAndroidComposeTheme
import kotlin.reflect.KFunction0

@OptIn(ExperimentalMotionApi::class)
@Composable
fun TipCalculatorApp(viewModel: TipCalculatorViewModel = hiltViewModel()) {
    val uiState = viewModel.uiState
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
                .fillMaxWidth()
                .height(130.dp)
                .defaultMinSize(minHeight = 30.dp)


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
                bill = uiState.value.bill.toString(),
                onBillChange = viewModel::onBillChange,
                modifier = Modifier.padding(vertical = 22.dp, horizontal = 25.dp)
            )
            SelectTip(
                tipPercent = uiState.value.tipPercent,
                onTipPercentChange = viewModel::onTipPercentChange,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 25.dp)
            )

            NumberOfPeople(
                numberPeople = uiState.value.numberPeople.toString(),
                onNumberPeopleChange = viewModel::onNumberPeopleChange,
                modifier = Modifier.padding(vertical = 18.dp, horizontal = 25.dp)
            )

            CardResult(
                tipAmount = uiState.value.tipAmount.toString(),
                total = uiState.value.total.toString(),
                onReset = viewModel::resetCalculate,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 25.dp)
            )

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bill(modifier: Modifier = Modifier, bill: String, onBillChange: (String) -> Unit) {
    Column(
        modifier = modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Bill", fontSize = 18.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = bill,
            onValueChange = { onBillChange(it) },
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(60.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
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
fun SelectTip(
    modifier: Modifier = Modifier,
    tipPercent: Int,
    onTipPercentChange: (String) -> Unit
) {
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
                .height(45.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (tipPercent == 5) Color(
                        0xFF27C1AD
                    ) else Color(0xFF024A48)
                ),
                onClick = { onTipPercentChange("5") },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "5%",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (tipPercent == 5) Color(0xFF024A48) else Color.White
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { onTipPercentChange("10") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (tipPercent == 10) Color(
                        0xFF27C1AD
                    ) else Color(0xFF024A48)
                ),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "10%",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (tipPercent == 10) Color(0xFF024A48) else Color.White
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (tipPercent == 15) Color(
                        0xFF27C1AD
                    ) else Color(0xFF024A48)
                ),
                onClick = { onTipPercentChange("15") },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "15%",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (tipPercent == 15) Color(0xFF024A48) else Color.White
                )
            }
            Spacer(modifier = Modifier.width(18.dp))
            Button(
                onClick = { onTipPercentChange("25") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (tipPercent == 25) Color(
                        0xFF27C1AD
                    ) else Color(0xFF024A48)
                ),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "25%",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (tipPercent == 25) Color(0xFF024A48) else Color.White
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (tipPercent == 50) Color(
                        0xFF27C1AD
                    ) else Color(0xFF024A48)
                ),
                onClick = { onTipPercentChange("50") },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "50%",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (tipPercent == 50) Color(0xFF024A48) else Color.White
                )
            }
            Spacer(modifier = Modifier.width(18.dp))
            Spacer(modifier = Modifier.weight(1f))


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberOfPeople(
    modifier: Modifier = Modifier,
    numberPeople: String,
    onNumberPeopleChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Number of People", fontSize = 18.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = numberPeople,
            onValueChange = { onNumberPeopleChange(it) },
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth()
                .height(55.dp),
            textStyle = TextStyle(
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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
fun CardResult(
    modifier: Modifier = Modifier,
    total: String,
    tipAmount: String,
    onReset: KFunction0<Unit>
) {
    Card(
        modifier = modifier
            .fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = Color(0xFF024A48))
    ) {
        Column(
            modifier = Modifier.padding(top = 26.dp, bottom = 22.dp, start = 25.dp, end = 25.dp),
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
                    text = "$${tipAmount}",
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
                    text = "$${total}",
                    color = Color(0xFF27C1AD),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

            }

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF27C1AD)),
                onClick = { onReset() },
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