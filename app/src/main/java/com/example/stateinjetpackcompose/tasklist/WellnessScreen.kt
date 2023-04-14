package com.example.stateinjetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stateinjetpackcompose.WaterCounter
import com.example.stateinjetpackcompose.components.WellnessTaskList
import com.example.stateinjetpackcompose.tasklist.WellnessScreenViewModel
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme
@Composable
fun WellnessScreen(
    wellnessViewModel: WellnessScreenViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        WaterCounter(modifier)
        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onClose = { wellnessViewModel.remove(it) },
            onItemCheckedChange = {item, checkStatus -> wellnessViewModel.changeItemCheckedStatus(item, checkStatus)}
        )
    }

}

@Preview
@Composable
fun WellnessScreenPreview() {
    StateInJetpackComposeTheme {
        WellnessScreen()
    }
}

