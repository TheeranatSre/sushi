package com.example.sushi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import com.example.sushi.ui.main.MainFragment

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar!!.hide()
    }

    fun showDialog() {
        val fragmentManager = supportFragmentManager
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}