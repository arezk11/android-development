package com.seneca.newsletterapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        // Get the passed data
        val userName = intent.getStringExtra("userName") ?: "User"

        // Set the welcome message
        val welcomeMessage = findViewById<TextView>(R.id.tvWelcomeMessage)
        welcomeMessage.text = "Welcome to Activity Two, $userName!"
    }
}
