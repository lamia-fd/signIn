package com.example.signupsigninapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var name=intent.getStringExtra("name")
        var mobile=intent.getStringExtra("mobile")
       var loc= intent.getStringExtra("location")
      var pass=  intent.getStringExtra("pass")
        var info=intent.getStringExtra("text")

        var tv1=findViewById<TextView>(R.id.textView)

        tv1.text=name+mobile+loc

        var tv2=findViewById<TextView>(R.id.textView2)
        if(info!=null){
            tv2.text=info
        }



    }
}