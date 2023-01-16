package com.example.assessment1calculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_settings.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        BackBtn2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val pref = "mixerPreference"
        val key = "background"

        val sp = getSharedPreferences(pref, 0)
        val value = sp.getBoolean(key, true)
        //switch2.isChecked = value

        if (value) {
            background2.background =
                ResourcesCompat.getDrawable(resources, R.drawable.darkbg, null)
        }
        else {
            background2.background =
                ResourcesCompat.getDrawable(resources, R.drawable.lightbg, null)
        }
    }
}