package ru.yandex.practicum.sprint9

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uiMode: Int = resources.configuration.uiMode

        val masked = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        Log.d("SPRINT_9", "uiMode $uiMode")
        Log.d("SPRINT_9", "$uiMode -> ${uiMode.toBinary()}")
        Log.d("SPRINT_9", "${Configuration.UI_MODE_NIGHT_MASK} -> ${Configuration.UI_MODE_NIGHT_MASK.toBinary()}")
        Log.d("SPRINT_9", "${Configuration.UI_MODE_NIGHT_YES} -> ${Configuration.UI_MODE_NIGHT_YES.toBinary()}")
        Log.d("SPRINT_9", "${masked} -> ${masked.toBinary()}")
        Log.d("SPRINT_9", "${masked == Configuration.UI_MODE_NIGHT_NO}")
    }

    private fun Int.toBinary(): String {
        return String.format("%8s", Integer.toBinaryString(this)).replace(' ', '0')
    }
}