package com.driverco.madlibs

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MadStory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mad_story)
        val intent = intent
        val res = intent.getStringExtra("res")
        Log.d("last", "res is $res")
        val tv: TextView = findViewById(R.id.result)
        tv.text = Html.fromHtml(res, Html.FROM_HTML_MODE_COMPACT)
    }
    fun newStory(view: View?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}