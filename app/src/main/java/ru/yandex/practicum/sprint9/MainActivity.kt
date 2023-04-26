package ru.yandex.practicum.sprint9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton
import java.util.UUID
import kotlin.random.Random

class MainActivity : AppCompatActivity(), SingletonEventListener {

    companion object {
        const val TAG = "SPRINT_9"
    }

    private val data: MutableList<DataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.generate).setOnClickListener {
            Thread {
                (0..10000).forEach {
                    val item = DataItem(
                        id = UUID.randomUUID().toString(),
                        text = (0..Random.nextInt(1000)).map {
                            'c'
                        }.joinToString()
                    )
                    data.add(item)
                }
            }.start()
            Log.d(TAG, "data: ${data.size}")
        }
    }

    override fun onStart() {
        super.onStart()
        Singleton.addListener(this)
    }

    override fun onStop() {
        super.onStop()
        Singleton.removeListener(this)
    }

    override fun onSingletonEvent(event: SingletonEvent) {
        Log.d(TAG, "onSingletonEvent: $event")
    }

}

data class DataItem(
    val id: String,
    val text: String,
)

object Singleton {

    private val listeners = mutableListOf<SingletonEventListener>()

    fun addListener(listener: SingletonEventListener) {
        listeners.add(listener)
        Log.d(MainActivity.TAG, "=== listeners")
        listeners.forEach {
            Log.d(MainActivity.TAG, "listener: $it")
        }
    }

    fun removeListener(listener: SingletonEventListener){
        listeners.remove(listener)
    }

}

interface SingletonEventListener {
    fun onSingletonEvent(event: SingletonEvent)
}

class SingletonEvent(
    val data: String
)

