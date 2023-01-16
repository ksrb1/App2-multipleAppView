package com.example.assessment1calculatorapp

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //assigning all of the animations so i can use them later on
        val animation1 = AnimationUtils.loadAnimation(this,R.anim.anim)
        val animation2 = AnimationUtils.loadAnimation(this,R.anim.anim2)
        val animation3 = AnimationUtils.loadAnimation(this, R.anim.anim3)
        val animation4 = AnimationUtils.loadAnimation(this, R.anim.anim4)
        val animation5 = AnimationUtils.loadAnimation(this, R.anim.anim5)
        val animation6 = AnimationUtils.loadAnimation(this, R.anim.anim6)
        val animation7 = AnimationUtils.loadAnimation(this, R.anim.anim7)
        val animation8 = AnimationUtils.loadAnimation(this, R.anim.anim8)



        //making some variable ands and value that ill use later on,
        val popupMain = findViewById<LinearLayout>(R.id.popup1)
        val popupMain2 = findViewById<LinearLayout>(R.id.popup2)
        var buttonEnabler1 = false
        var buttonEnabler2 = false

        val mDialog = Dialog(this)
        mDialog.setContentView(R.layout.how_it_works)
        mDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)



        var openedBefore = false;

        if(!openedBefore){
            Handler(Looper.getMainLooper()).postDelayed({
                mDialog.show()
                Handler(Looper.getMainLooper()).postDelayed({
                    mDialog.hide()
                    openedBefore = true
                }, 5500)
            }, 300)
        }
        howItWorksBtn.setOnClickListener {
            mDialog.show()
            Handler(Looper.getMainLooper()).postDelayed({
                mDialog.hide()
            }, 5500)
        }

        settingsBtn.setOnClickListener{
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        ingredientsBtn.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        //function hows the combine button, it only activates when two inputs for the calculator has been inputted,
        fun buttonChecker1(){
            buttonEnabler2 = true
            if (buttonEnabler1){
                Handler(Looper.getMainLooper()).postDelayed({
                    combineBtn.startAnimation(animation5)
                    combineBtn.visibility = View.VISIBLE
                }, 400)
            }
        }

        fun buttonChecker2(){
            buttonEnabler1 = true
            if (buttonEnabler2){
                Handler(Looper.getMainLooper()).postDelayed({
                    combineBtn.startAnimation(animation5)
                    combineBtn.visibility = View.VISIBLE
                }, 400)
            }
        }

        //some of the code here were needed in the previous versions of my app, i made it so it would close the other
        //popup menu that was already opened you wanted to choose an option for the second popup menu
        optionOne.setOnClickListener {
            if(popupMain.visibility == View.GONE){
                popupMain.startAnimation(animation1)
                popupMain.visibility = View.VISIBLE
            } else if(popupMain.visibility == View.VISIBLE){
                popupMain.visibility = View.GONE
            }
            if (popupMain2.visibility == View.VISIBLE){
                popupMain2.visibility = View.GONE
            }
        }

        optionTwo.setOnClickListener {
            if(popupMain2.visibility == View.GONE){
                popupMain2.startAnimation(animation2)
                popupMain2.visibility = View.VISIBLE
            } else if(popupMain2.visibility == View.VISIBLE){
                popupMain2.visibility = View.GONE
            }
            if (popupMain.visibility == View.VISIBLE){
                popupMain.visibility = View.GONE
            }
        }

        //this is the variable that allows me to check what the user chose
        var optOneVal = ""
        var optTwoVal = ""

        //code that runs when combine button is pressed
        combineBtn.setOnClickListener {
            //was using this during testing, basically makes it so all of the popup main not visible anymore
            popupMain.visibility = View.GONE
            popupMain2.visibility = View.GONE
            combineBtn.visibility = View.GONE

            optionOne.startAnimation(animation6)
            optionTwo.startAnimation(animation6)
            Handler(Looper.getMainLooper()).postDelayed({
                optionOne.clearAnimation()
                optionTwo.clearAnimation()
                findViewById<ConstraintLayout>(R.id.outputMain).startAnimation(animation7)
                findViewById<ConstraintLayout>(R.id.outputMain).visibility = View.VISIBLE
            }, 500)


            //checks the value then assigns output depending on value
            if(optOneVal == "meat" && optTwoVal == "stick" ){
                outputImg.setImageResource(R.drawable.kebab)
                outputText2.text = "kebabs"
            } else if(optOneVal == "meat" && optTwoVal == "vegetables" ){
                outputImg.setImageResource(R.drawable.peirogies)
                outputText2.text = "Pierogies"
            } else if(optOneVal == "meat" && optTwoVal == "eggs" ){
                outputImg.setImageResource(R.drawable.bacon_and_eggs)
                outputText2.text = "Bacon and Eggs"
            }else if(optOneVal == "fish" && optTwoVal == "stick" ){
                outputImg.setImageResource(R.drawable.fish_sticks)
                outputText2.text = "Fish Sticks"
            } else if(optOneVal == "fish" && optTwoVal == "vegetables" ){
                outputImg.setImageResource(R.drawable.sushi)
                outputText2.text = "Sushi"
            } else if(optOneVal == "fish" && optTwoVal == "eggs" ){
                outputImg.setImageResource(R.drawable.caviar)
                outputText2.text = "caviar"
            }else if(optOneVal == "berries" && optTwoVal == "stick" ){
                outputImg.setImageResource(R.drawable.roated_jam)
                outputText2.text = "Roasted Berries"
            } else if(optOneVal == "berries" && optTwoVal == "vegetables" ){
                outputImg.setImageResource(R.drawable.salad)
                outputText2.text = "Salad"
            } else if(optOneVal == "berries" && optTwoVal == "eggs" ){
                outputImg.setImageResource(R.drawable.fruit_crepe)
                outputText2.text = "Fruit Crepe"
            }

            //this code was for the previous version where you were still able to click on the options screen that would
            //enable the popup menu, but now the output screen would cover it so this code is basically useless
            optionOne.isClickable = false
            optionTwo.isClickable = false


            //code that runs after 3 second when the combine button is pressed
            Handler(Looper.getMainLooper()).postDelayed({
                findViewById<ConstraintLayout>(R.id.outputMain).startAnimation(animation8)
                findViewById<ConstraintLayout>(R.id.outputMain).visibility = View.GONE
                combineBtn.isClickable = true
                optionOne.isClickable = true
                optionTwo.isClickable = true
                optionOne.setImageResource(R.drawable.empty_box)
                optionTwo.setImageResource(R.drawable.empty_box)
                optOneVal = ""
                optTwoVal = ""
                buttonEnabler1 = false
                buttonEnabler2 = false
            }, 2500)
        }


        //code that change the image resource

        findViewById<ImageView>(R.id.meatImg).setOnClickListener {
            popupMain.startAnimation(animation4)
            popupMain.visibility = View.GONE
            Handler(Looper.getMainLooper()).postDelayed({
                optionOne.setImageResource(R.drawable.meat)
            }, 300)
            optOneVal = "meat"
            buttonChecker1()
        }

        findViewById<ImageView>(R.id.fishImg).setOnClickListener {
            popupMain.startAnimation(animation4)
            popupMain.visibility = View.GONE
            Handler(Looper.getMainLooper()).postDelayed({
                optionOne.setImageResource(R.drawable.fish)
            }, 300)
            optOneVal = "fish"
            buttonChecker1()
        }

        findViewById<ImageView>(R.id.berriesImg).setOnClickListener {
            popupMain.startAnimation(animation4)
            popupMain.visibility = View.GONE
            Handler(Looper.getMainLooper()).postDelayed({
                optionOne.setImageResource(R.drawable.berries)
            }, 300)
            optOneVal = "berries"
            buttonChecker1()
        }

        findViewById<ImageView>(R.id.eggsImg).setOnClickListener {
            popupMain2.startAnimation(animation3)
            popupMain2.visibility = View.GONE
            Handler(Looper.getMainLooper()).postDelayed({
                optionTwo.setImageResource(R.drawable.eggs)
            }, 300)
            optTwoVal = "eggs"
            buttonChecker2()

        }

        findViewById<ImageView>(R.id.stickImg).setOnClickListener {
            popupMain2.startAnimation(animation3)
            popupMain2.visibility = View.GONE
            Handler(Looper.getMainLooper()).postDelayed({
                optionTwo.setImageResource(R.drawable.stick)
            }, 300)
            optTwoVal = "stick"
            buttonChecker2()
        }

        findViewById<ImageView>(R.id.vegetableImg).setOnClickListener {
            popupMain2.startAnimation(animation3)
            popupMain2.visibility = View.GONE
            Handler(Looper.getMainLooper()).postDelayed({
                optionTwo.setImageResource(R.drawable.vegetables)
            }, 300)
            optTwoVal = "vegetables"
            buttonChecker2()
        }

        //new code below
        val pref = "mixerPreference"
        val key = "background"

        val sp = getSharedPreferences(pref, 0)
        val value = sp.getBoolean(key, true)
        //switch2.isChecked = value

        if (value) {
            background.background =
                ResourcesCompat.getDrawable(resources, R.drawable.background, null)
        }
        else {
            background.background =
                ResourcesCompat.getDrawable(resources, R.drawable.lightmode, null)
        }




    }

    }




