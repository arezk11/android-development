package com.seneca.as1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        val firstName = findViewById<EditText>(R.id.firstName)
        val lastName = findViewById<EditText>(R.id.lastName)
        val email = findViewById<EditText>(R.id.email)
        val confirmEmail = findViewById<EditText>(R.id.confirmEmail)
        val password = findViewById<EditText>(R.id.password)
        val confirmPassword = findViewById<EditText>(R.id.confirmPassword)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val firstNameText = firstName.text.toString()
            val lastNameText = lastName.text.toString()
            val emailText = email.text.toString()
            val confirmEmailText = confirmEmail.text.toString()
            val passwordText = password.text.toString()
            val confirmPasswordText = confirmPassword.text.toString()

            // Basic validation
            if (firstNameText.isEmpty() || lastNameText.isEmpty() || emailText.isEmpty() ||
                confirmEmailText.isEmpty() || passwordText.isEmpty() || confirmPasswordText.isEmpty()) {
                firstName.error = "Required"
                lastName.error = "Required"
                email.error = "Required"
                confirmEmail.error = "Required"
                password.error = "Required"
                confirmPassword.error = "Required"
                return@setOnClickListener
            }

            // Check if email and confirm email match
            if (emailText != confirmEmailText) {
                confirmEmail.error = "Emails do not match"
                return@setOnClickListener
            }

            // Check if password and confirm password match
            if (passwordText != confirmPasswordText) {
                confirmPassword.error = "Passwords do not match"
                return@setOnClickListener
            }

            // Pass first name to ThankYouActivity
            val intent = Intent(this, ThankYouActivity::class.java)
            intent.putExtra("FIRST_NAME", firstNameText)
            startActivity(intent)
        }
    }
}
