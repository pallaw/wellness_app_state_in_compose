package com.example.stateinjetpackcompose.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stateinjetpackcompose.data.WelnessTask
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme

@Composable
fun WellnessTaskList(
    list: List<WelnessTask>,
    onClose: (WelnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list, key = {item -> item.id }) { item ->
            WellnessTaskListItem(taskName = item.name, onCloseTask = {onClose(item)})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskListPreview() {
    StateInJetpackComposeTheme {
        WellnessTaskList(
            list = List(20){number -> WelnessTask(number, "Task #{$number}") },
            {}
        )
    }
}

