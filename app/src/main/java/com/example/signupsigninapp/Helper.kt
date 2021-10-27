package com.example.signupsigninapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Helper(context: Context):SQLiteOpenHelper(context,"member.db",null,1) {
    var sql: SQLiteDatabase = writableDatabase
    override fun onCreate(p: SQLiteDatabase?) {
        if (p != null) {
            p.execSQL("create table members(name text,mobile text , location text ,password text)")

        }

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addmember(name: String, mobile: String, location: String, pass: String): Long {
        val cv = ContentValues()
        cv.put("name", name)
        cv.put("mobile", mobile)
        cv.put("location", location)
        cv.put("password", pass)

        var status = sql.insert("members", null, cv)
        //  SOLiteDatabase.close()
        return status

    }

    @SuppressLint("Range")
    fun checkPass(name: String): String {
        var c: Cursor = sql.query("members", null, "name=?", arrayOf(name), null, null, null)
        c.moveToFirst()

        if (c.count <= 0) {
            return "the name dos not exist"
        }
        return c.getString(c.getColumnIndex("password"))
    }

    @SuppressLint("Range")
    fun getMemberInfo(name: String): String {

        val listOfInfo: ArrayList<Info> = ArrayList()
        var c: Cursor = sql.query("members", null, "name=?", arrayOf(name), null, null, null)

        c.moveToFirst()


        var mobile = c.getString(c.getColumnIndex("mobile"))
        var location = c.getString(c.getColumnIndex("location"))
        println(listOfInfo.add(Info(mobile, location)).hashCode())

        return "your \n mobile: $mobile \n location: $location"
    }
}