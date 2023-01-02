package com.example.sushi.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.sushi.login.LoginActivity
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
//        val intentToLogin = Intent(this, LoginActivity::class.java)
//        startActivity(intentToLogin)
    }
}