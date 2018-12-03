package edu.fullerton.cpsc411.mini_app04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragment_container) == null) {
            supportFragmentManager.transaction(allowStateLoss = true) {
                add(R.id.fragment_container, SimpleFragment())
            }

        }
    }
}
