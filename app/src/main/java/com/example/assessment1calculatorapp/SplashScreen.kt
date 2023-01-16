package com.example.assessment1calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.os.Looper
import android.os.Handler
import android.view.WindowManager
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val pref = "mixerPreference"
        val key = "background"

        val sp = getSharedPreferences(pref, 0)
        val value = sp.getBoolean(key, true)

        var color = "#000000"
        if (!value) {
            color = "#405587"
        }

        background.setBackgroundColor(Color.parseColor(color))

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1000)
    }
}