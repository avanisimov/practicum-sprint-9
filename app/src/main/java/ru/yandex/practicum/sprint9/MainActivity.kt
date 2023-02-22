package ru.yandex.practicum.sprint9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        var currentTheme = R.style.Theme_Sprint9
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SPRINT_9", "MainActivity $this $savedInstanceState")
        setTheme(currentTheme)
        setContentView(R.layout.activity_main)

//        findViewById<Button>(R.id.default_theme).setOnClickListener {
//            currentTheme = R.style.Theme_Sprint9
//
//            recreate()
//        }
//
//        findViewById<Button>(R.id.alternate_theme).setOnClickListener {
//            currentTheme = R.style.Theme_Sprint9_Alternate
//            recreate()
//        }

        val image = findViewById<ImageView>(R.id.image)
        Log.d("SPRINT_9", "image $image")

    }

}