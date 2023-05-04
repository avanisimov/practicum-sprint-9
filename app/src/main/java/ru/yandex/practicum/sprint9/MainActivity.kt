package ru.yandex.practicum.sprint9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(ThemeManager.currentTheme)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.classic).setOnClickListener {
            ThemeManager.currentTheme = R.style.Theme_Sprint9
            recreate()
        }
        findViewById<Button>(R.id.alternative).setOnClickListener {
            ThemeManager.currentTheme = R.style.Theme_Sprint9_Alternative
            recreate()
        }

    }
}

object ThemeManager {
    var currentTheme: Int = R.style.Theme_Sprint9
}