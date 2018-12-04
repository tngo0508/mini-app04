package edu.fullerton.cpsc411.mini_app04

import android.widget.TextView
import androidx.databinding.ObservableDouble
import androidx.lifecycle.ViewModel
import java.util.Locale.US

class SimpleViewModel: ViewModel() {
    var netSpeed = 100.0
    var fileSize = 100.0
    val transferTime = ObservableDouble()

    fun onNetSpeedChanged(s: CharSequence) {

        try {
            netSpeed = s.toString().toDouble()

            transferTime.set(toOneDec(calTransferTime(netSpeed, fileSize)).toDouble())
        } catch (e: NumberFormatException){
            defaultDisplay()
        }

    }

    fun onFileSizeChanged(s: CharSequence) {

        try {
            fileSize = s.toString().toDouble()

            transferTime.set(toOneDec(calTransferTime(netSpeed, fileSize)).toDouble())
        } catch (e: NumberFormatException) {
            defaultDisplay()
        }

    }
    private fun calTransferTime(networkSpeed: Double?, fileSize: Double?): Double {
        return networkSpeed!! * Math.pow(2.0, 20.0) * 8.0 / (fileSize!! * Math.pow(10.0, 6.0))
    }

    private fun toOneDec(num: Double?): String {
        return String.format(US, "%.1f", num)
    }

    private fun defaultDisplay() {
        transferTime.set(toOneDec(calTransferTime(100.0, 100.0)).toDouble())
    }
}