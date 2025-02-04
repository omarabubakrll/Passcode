package com.passcode

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.view.View
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var passcode: String = ""
    private val fl1: FrameLayout by lazy { findViewById(R.id.fl1) }
    private val fl2: FrameLayout by lazy { findViewById(R.id.fl2) }
    private val fl3: FrameLayout by lazy { findViewById(R.id.fl3) }
    private val fl4: FrameLayout by lazy { findViewById(R.id.fl4) }
    private val btn01: CardView by lazy { findViewById(R.id.btn01) }
    private val btn02: CardView by lazy { findViewById(R.id.btn02) }
    private val btn03: CardView by lazy { findViewById(R.id.btn03) }
    private val btn04: CardView by lazy { findViewById(R.id.btn04) }
    private val btn05: CardView by lazy { findViewById(R.id.btn05) }
    private val btn06: CardView by lazy { findViewById(R.id.btn06) }
    private val btn07: CardView by lazy { findViewById(R.id.btn07) }
    private val btn08: CardView by lazy { findViewById(R.id.btn08) }
    private val btn09: CardView by lazy { findViewById(R.id.btn09) }
    private val btn00: CardView by lazy { findViewById(R.id.btn00) }
    private val btn001: CardView by lazy { findViewById(R.id.btn001) }
    private val btn002: CardView by lazy { findViewById(R.id.btn002) }

    private val handler = Handler(Looper.getMainLooper())
    private val runnable = Runnable { adapt() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        handler.postDelayed(runnable, 100)

        btn01.setOnClickListener(this)
        btn02.setOnClickListener(this)
        btn03.setOnClickListener(this)
        btn04.setOnClickListener(this)
        btn05.setOnClickListener(this)
        btn06.setOnClickListener(this)
        btn07.setOnClickListener(this)
        btn08.setOnClickListener(this)
        btn09.setOnClickListener(this)
        btn00.setOnClickListener(this)
        btn001.setOnClickListener(this)
        btn002.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn01 -> {
                passcode += "1"
            }
            R.id.btn02 -> {
                passcode += "2"
            }
            R.id.btn03 -> {
                passcode += "3"
            }
            R.id.btn04 -> {
                passcode += "4"
            }
            R.id.btn05 -> {
                passcode += "5"
            }
            R.id.btn06 -> {
                passcode += "6"
            }
            R.id.btn07 -> {
                passcode += "7"
            }
            R.id.btn08 -> {
                passcode += "8"
            }
            R.id.btn09 -> {
                passcode += "9"
            }
            R.id.btn00 -> {
                passcode += "0"
            }
            R.id.btn001 -> {
                passcode += "*"
            }
            R.id.btn002 -> {
                passcode += "#"
            }

        }
    }

    private fun adapt() {
        if (passcode.length == 1) {
            if (fl4.alpha == 1f) {
                fl4.animate().alpha(0f)
            }
            if (fl3.alpha == 1f) {
                fl3.animate().alpha(0f)
            }
            if (fl2.alpha == 1f) {
                fl2.animate().alpha(0f)
            }
            if (fl1.alpha == 0f) {
                fl1.animate().alpha(1f)
            }
            handler.postDelayed(runnable, 100)
        } else if (passcode.length == 2) {
            if (fl4.alpha == 1f) {
                fl4.animate().alpha(0f)
            }
            if (fl3.alpha == 1f) {
                fl3.animate().alpha(0f)
            }
            if (fl2.alpha == 0f) {
                fl2.animate().alpha(1f)
            }
            if (fl1.alpha == 0f) {
                fl1.animate().alpha(1f)
            }
            handler.postDelayed(runnable, 100)
        } else if (passcode.length == 3) {
            if (fl4.alpha == 1f) {
                fl4.animate().alpha(0f)
            }
            if (fl3.alpha == 0f) {
                fl3.animate().alpha(1f)
            }
            if (fl2.alpha == 0f) {
                fl2.animate().alpha(1f)
            }
            if (fl1.alpha == 0f) {
                fl1.animate().alpha(1f)
            }
            handler.postDelayed(runnable, 100)
        } else if (passcode.length == 4) {

            if (fl3.alpha == 0f) {
                fl3.animate().alpha(1f)
            }
            if (fl2.alpha == 0f) {
                fl2.animate().alpha(1f)
            }
            if (fl1.alpha == 0f) {
                fl1.animate().alpha(1f)
            }
            if (fl4.alpha == 0f) {
                fl4.animate().alpha(1f).withEndAction {
                    check()
                }
            } else {
                check()
            }

        } else if (passcode.isEmpty()) {
            if (fl4.alpha == 1f) {
                fl4.animate().alpha(0f)
            }
            if (fl3.alpha == 1f) {
                fl3.animate().alpha(0f)
            }
            if (fl2.alpha == 1f) {
                fl2.animate().alpha(0f)
            }
            if (fl1.alpha == 1f) {
                fl1.animate().alpha(0f)
            }
            handler.postDelayed(runnable, 100)
        } else if (passcode.length > 4) {
            passcode = passcode.substring(0, 4)
            handler.postDelayed(runnable, 100)
        }
    }


    private fun check() {
        if (passcode == "5417") {
            // finish()
        } else {
            fl4.animate().alpha(0f)
            fl3.animate().alpha(0f)
            fl2.animate().alpha(0f)
            fl1.animate().alpha(0f).withEndAction {
                fl1.setBackgroundColor(resources.getColor(R.color.red))
                fl2.setBackgroundColor(resources.getColor(R.color.red))
                fl3.setBackgroundColor(resources.getColor(R.color.red))
                fl4.setBackgroundColor(resources.getColor(R.color.red))
                fl1.animate().alpha(1f)
                fl2.animate().alpha(1f)
                fl3.animate().alpha(1f)
                fl4.animate().alpha(1f).withEndAction {
                    vibrate(applicationContext)
                    fl4.animate().alpha(0f)
                    fl3.animate().alpha(0f)
                    fl2.animate().alpha(0f)
                    fl1.animate().alpha(0f).withEndAction {
                        fl1.setBackgroundColor(resources.getColor(R.color.green))
                        fl2.setBackgroundColor(resources.getColor(R.color.green))
                        fl3.setBackgroundColor(resources.getColor(R.color.green))
                        fl4.setBackgroundColor(resources.getColor(R.color.green))
                        passcode = ""
                        handler.postDelayed(runnable, 100)
                    }
                }
            }
        }
    }

    private fun vibrate(context: Context, duration: Long = 500) {
        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val effect = VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE)
            vibrator.vibrate(effect)
        }
    }
}