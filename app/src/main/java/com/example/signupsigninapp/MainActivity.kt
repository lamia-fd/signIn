package com.example.signupsigninapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var but1 = findViewById<Button>(R.id.signIn)
        var but2 = findViewById<Button>(R.id.signUp)

        but1.setOnClickListener {
            var intent = Intent(applicationContext, SignIn::class.java)
            startActivity(intent)
        }
        but2.setOnClickListener {
            var intent = Intent(applicationContext, signUp::class.java)
            startActivity(intent)
        }


    }
}