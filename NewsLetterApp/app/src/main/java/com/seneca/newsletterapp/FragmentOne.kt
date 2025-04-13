package com.seneca.newsletterapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import androidx.navigation.fragment.findNavController

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_one, container, false)

        // Get references to views
        val etName = view.findViewById<EditText>(R.id.etName)
        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val rgGender = view.findViewById<RadioGroup>(R.id.rgGender)
        val switchFamilyEvents = view.findViewById<Switch>(R.id.switchFamilyEvents)
        val cbTerms = view.findViewById<CheckBox>(R.id.cbTerms)
        val btnRegister = view.findViewById<Button>(R.id.btnRegister)

        // Set click listener for the Register button
        btnRegister.setOnClickListener {

            // Get user input
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val gender = when (rgGender.checkedRadioButtonId) {
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> "Other"
            }
            val familyEvents = switchFamilyEvents.isChecked
            val termsAccepted = cbTerms.isChecked

            // Create a Bundle to the pass data
            val bundle = Bundle().apply {
                putString("name", name)
                putString("email", email)
                putString("gender", gender)
                putBoolean("familyEvents", familyEvents)
                putBoolean("termsAccepted", termsAccepted)
            }

            // Navigate to FragmentTwo with the Bundle
            findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo, bundle)
        }

        return view
    }
}