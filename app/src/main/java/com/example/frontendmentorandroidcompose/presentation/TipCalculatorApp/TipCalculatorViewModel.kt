package com.example.frontendmentorandroidcompose.presentation.TipCalculatorApp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject
import kotlin.math.nextUp

@HiltViewModel
class TipCalculatorViewModel @Inject constructor() : ViewModel() {

    var uiState = mutableStateOf(UiState())
        private set

    private val bill
        get() = uiState.value.bill

    private val tipPercent
        get() = uiState.value.tipPercent

    private val numberPeople
        get() = uiState.value.numberPeople

    private val tipAmount
        get() = uiState.value.tipAmount

    private val total
        get() = uiState.value.total

    fun onBillChange(newValue: String) {
        uiState.value =
            uiState.value.copy(bill = if (newValue.isEmpty()) 0f else newValue.toFloat())
    }

    fun onNumberPeopleChange(newValue: String) {
        uiState.value =
            uiState.value.copy(numberPeople = if (newValue.isEmpty()) 0 else newValue.toInt())
    }

    fun onTipPercentChange(newValue: String) {
        uiState.value =
            uiState.value.copy(tipPercent = if (newValue.isEmpty()) 1 else newValue.toInt())
    }


    fun resetCalculate() {
        var newTipAmount: Float = ((bill * tipPercent) / 100) / numberPeople
        newTipAmount = BigDecimal(newTipAmount.toDouble()).setScale(2, RoundingMode.HALF_UP).toFloat()
        var newTotal: Float = (bill + newTipAmount * numberPeople) / numberPeople
        newTotal = BigDecimal(newTotal.toDouble()).setScale(2, RoundingMode.HALF_UP).toFloat()
        uiState.value = uiState.value.copy(tipAmount = newTipAmount, total = newTotal)
    }
}

data class UiState(
    var bill: Float = 142.55f,
    var tipPercent: Int = 15,
    var numberPeople: Int = 5,
    var tipAmount: Float = 4.27f,
    var total: Float = 32.79f
)