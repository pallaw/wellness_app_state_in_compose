package com.example.stateinjetpackcompose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stateinjetpackcompose.ui.theme.StateInJetpackComposeTheme


@Composable
fun WellnessTaskListItem(
    taskName: String,
    onCloseTask: () -> Unit,
    modifier: Modifier = Modifier
) {
    var checkedStatus by rememberSaveable { mutableStateOf(false) }

    StatelessWellnessTaskListItem(
        taskName = taskName,
        checked = checkedStatus,
        onCheckedChange = { newValue -> checkedStatus = newValue },
        onClose = onCloseTask,
        modifier = modifier
    )
}

@Composable
fun StatelessWellnessTaskListItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = taskName, modifier = Modifier.weight(1.0f))
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskListItemPreview() {
    StateInJetpackComposeTheme {
        WellnessTaskListItem("what to do", {})
    }
}