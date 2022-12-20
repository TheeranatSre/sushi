package com.example.sushi.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sushi.R
import com.example.sushi.login.ui.main.LoginFragment
import java.lang.NullPointerException

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }
}