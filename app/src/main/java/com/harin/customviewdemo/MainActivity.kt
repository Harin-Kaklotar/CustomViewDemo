package com.harin.customviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var customView: CustomView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customView = findViewById(R.id.customView) as CustomView
        button = findViewById(R.id.btn_change_color) as Button

        button.setOnClickListener {
            customView.changeColor()
        }
    }
}