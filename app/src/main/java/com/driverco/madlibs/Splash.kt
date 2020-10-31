package com.driverco.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash : AppCompatActivity() {
    private val splashDur = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT*/
        setContentView(R.layout.activity_splash)
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this, StartHere::class.java)
                startActivity(intent)
                finish()
            }, splashDur.toLong())
        }
    }}