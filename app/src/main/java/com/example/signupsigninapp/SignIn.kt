package com.example.signupsigninapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignIn : AppCompatActivity() {
    lateinit var dbh:Helper
    lateinit var etName:EditText
    lateinit var etPass:EditText
    lateinit var but:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        dbh= Helper(this)

        etName=findViewById(R.id.tvName2)
        etPass=findViewById(R.id.tvPass2)
        but=findViewById(R.id.button)

        but.setOnClickListener {
            var name=etName.text.toString()
            var pass=etPass.text.toString()
           var checkpass= dbh.checkPass(name)

            if(checkpass==pass){
                Toast.makeText(applicationContext,"Sign in successfully",Toast.LENGTH_LONG).show()
                var list=dbh.getMemberInfo(name)
                var intent= Intent(applicationContext,MainActivity2::class.java)
                intent.putExtra("name",name)
                intent.putExtra("text",list)
                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"$checkpass",Toast.LENGTH_LONG).show()

            }

        }


    }
}