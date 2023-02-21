package ru.yandex.practicum.sprint9

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.text.method.KeyListener
import android.util.Log
import android.util.Patterns
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vinNumber = findViewById<EditText>(R.id.vin_number)
        val email = findViewById<EditText>(R.id.email)
        val phoneNumber = findViewById<EditText>(R.id.phone_number)
        val money = findViewById<EditText>(R.id.money)
        email.addTextChangedListener {
            val matcher = Patterns.EMAIL_ADDRESS.matcher(it?.toString())
            email.setError(
                if (matcher.matches()) {
                    null
                } else {
                    "error"
                }
            )
        }

        phoneNumber.addTextChangedListener(PhoneNumberFormattingTextWatcher())


    }
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun showKeyboardWithDelay(view: View, delay: Long = 200) {
    val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    view.postDelayed(object : Runnable {
        override fun run() {
            view.requestFocus()
            imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }, delay)
}

fun Activity.hideKeyboard() {
    val view = this.currentFocus ?: View(this)
    view.hideKeyboard()
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(this.windowToken, 0)
}