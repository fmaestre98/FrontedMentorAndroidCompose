package com.example.frontendmentorandroidcompose.presentation.LinkSharingApp


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LinksAppViewModel @Inject constructor(): ViewModel() {

    private val _linksList: MutableList<Pair<String, String>> =
        mutableStateListOf(
            Pair("Github", "https://github.com/fmaestre98"),
            Pair("Youtube", "https://www.youtube.com/fmaeste98")
        )

    val linksList: List<Pair<String, String>> = _linksList

    fun addElement() {
        _linksList.add(Pair("Github", "https://github.com/fmaestre98"))
    }


    fun removeElement(index: Int) {
        _linksList.removeAt(index)
    }

}