package com.example.assessment1calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


       BackBtn.setOnClickListener{
           val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)
       }

        val pref = "mixerPreference"
        val key = "background"

        val sp = getSharedPreferences(pref, 0)
        val value = sp.getBoolean(key, true)
        switch3.isChecked = value

        switch3.setOnClickListener {
            val editor = getSharedPreferences(pref, 0).edit()
            editor.putBoolean(key, switch3.isChecked)
            editor.commit()


        }

    }
}