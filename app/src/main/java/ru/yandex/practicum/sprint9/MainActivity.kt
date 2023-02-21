package ru.yandex.practicum.sprint9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun Int.toBinary(): String {
        return String.format("%8s", Integer.toBinaryString(this)).replace(' ', '0')
    }
}