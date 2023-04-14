package com.example.stateinjetpackcompose.tasklist

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.stateinjetpackcompose.data.WelnessTask

class WellnessScreenViewModel: ViewModel() {

    private val _tasks = getWellNessTasks().toMutableStateList()
    val tasks: List<WelnessTask>
        get() = _tasks

    fun remove(item: WelnessTask) {
        _tasks.remove(item)
    }

    fun changeItemCheckedStatus(item: WelnessTask, checkStatus: Boolean) {
        _tasks.find { it.id == item.id }?.let { foundItem -> foundItem.checked = checkStatus }
    }

}

private fun getWellNessTasks() = List(20) { WelnessTask(it, "Task #{$it}") }