package com.example.stateinjetpackcompose.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class WelnessTask(
    val id: Int,
    val name: String,
    var initialChecked: Boolean = false
) {
    var checked by mutableStateOf(initialChecked)
}
