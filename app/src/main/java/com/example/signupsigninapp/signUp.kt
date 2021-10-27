package com.example.signupsigninapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class signUp : AppCompatActivity() {
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        
       var dbh=Helper(this)
        
        var etName=findViewById<EditText>(R.id.tvName)
        var etMobil=findViewById<EditText>(R.id.tvMobile)
        var etLocation=findViewById<EditText>(R.id.tvLocation)
        var etPass=findViewById<EditText>(R.id.tvPass)
        var but=findViewById<Button>(R.id.submit)
        
        but.setOnClickListener { 
            var name=etName.text.toString()
            var mobile=etMobil.text.toString()
            var location=etLocation.text.toString()
            var pass=etPass.text.toString()
            
            if(name.isNotBlank()&& mobile.isNotBlank() && location.isNotBlank() && pass.isNotBlank()){
               var status=dbh.addmember(name,mobile,location,pass)
                if(status<1){
                    Toast.makeText(applicationContext, "Fail to serve", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext, "Data is served", Toast.LENGTH_LONG).show()

                    var intent= Intent(applicationContext,MainActivity2::class.java)
                    intent.putExtra("name",name)
                    intent.putExtra("mobile",mobile)
                    intent.putExtra("location",location)
                    intent.putExtra("pass",pass)
                    startActivity(intent)
                }

            }else{
                Toast.makeText(applicationContext, "all filed are required", Toast.LENGTH_LONG).show()
            }
            
        }

    }
}