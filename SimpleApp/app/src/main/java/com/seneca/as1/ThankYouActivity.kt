package com.seneca.as1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThankYouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank_you)

        // Get the first name from the Intent
        val firstName = intent.getStringExtra("FIRST_NAME")

        // Display the message with the user's first name
        val thankYouMessage = findViewById<TextView>(R.id.thankYouMessage)
        thankYouMessage.text = "Thanks for Registration, $firstName"
    }
}
