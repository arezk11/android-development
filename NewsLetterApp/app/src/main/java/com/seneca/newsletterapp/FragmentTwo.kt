//package com.seneca.newsletterapp
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import com.seneca.newsletterapp.R
//class FragmentTwo : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_two, container, false)
//
//        // Get references to views
//        val tvUserDetails = view.findViewById<TextView>(R.id.tvUserDetails)
//
//        // Retrieve data from Bundle
//        val name = arguments?.getString("name")
//        val email = arguments?.getString("email")
//        val gender = arguments?.getString("gender")
//        val familyEvents = arguments?.getBoolean("familyEvents")
//        val termsAccepted = arguments?.getBoolean("termsAccepted")
//
//        // Display user details
//        val userDetails = """
//            Name: $name
//            Email: $email
//            Gender: $gender
//            Family Events: ${if (familyEvents == true) "Yes" else "No"}
//            Terms Accepted: ${if (termsAccepted == true) "Yes" else "No"}
//        """.trimIndent()
//        tvUserDetails.text = userDetails
//
//        return view
//    }
//}
package com.seneca.newsletterapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentTwo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_two, container, false)

        // Get references to views
        val tvUserDetails = view.findViewById<TextView>(R.id.tvUserDetails)
        val btnGoToActivityTwo = view.findViewById<Button>(R.id.btnGoToActivityTwo)

        // Retrieve user data from the Bundle
        val name = arguments?.getString("name") ?: "Unknown"
        val email = arguments?.getString("email") ?: "Unknown"
        val gender = arguments?.getString("gender") ?: "Not specified"
        val familyEvents = if (arguments?.getBoolean("familyEvents") == true) "Yes" else "No"
        val termsAccepted = if (arguments?.getBoolean("termsAccepted") == true) "Yes" else "No"

        // Display the user details
        val userDetails = """
            Name: $name
            Email: $email
            Gender: $gender
            Family Events: $familyEvents
            Terms Accepted: $termsAccepted
        """.trimIndent()
        tvUserDetails.text = userDetails

        // Set click listener for activity two button
        btnGoToActivityTwo.setOnClickListener {
            val intent = Intent(requireContext(), ActivityTwo::class.java)
            intent.putExtra("userName", name)
            startActivity(intent)
        }

        return view
    }
}
