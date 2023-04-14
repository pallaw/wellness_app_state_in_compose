package com.example.stateinjetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateinjetpackcompose.WaterCounter
import com.example.stateinjetpackcompose.components.WellnessTaskList
import com.example.stateinjetpackcompose.data.WelnessTask
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        WaterCounter(modifier)

        var list = remember { getWellNessTasks().toMutableStateList() }

        WellnessTaskList(list = list, onClose = {list.remove(it)},)
    }

}

@Preview
@Composable
fun WellnessScreenPreview() {
    StateInJetpackComposeTheme {
        WellnessScreen()
    }
}

private fun getWellNessTasks() = List(20) {WelnessTask(it, "Task #{$it}")}