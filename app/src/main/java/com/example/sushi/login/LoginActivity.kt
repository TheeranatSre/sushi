package com.example.sushi.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sushi.R
import java.lang.NullPointerException

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.login_screen)
    }
}