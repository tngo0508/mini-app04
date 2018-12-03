package edu.fullerton.cpsc411.mini_app04

import androidx.databinding.ObservableDouble
import androidx.lifecycle.ViewModel

class SimpleViewModel: ViewModel() {
    val netSpeed = 0.0
    val fileSize = 0.0
    val transferTime = ObservableDouble()

    fun onTextChange() {
        transferTime.set(netSpeed * Math.pow(2.0, 20.0) * 8.0 / (fileSize * Math.pow(10.0, 6.0)))
    }
}