package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.hello.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
 lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onResume() {
        super.onResume()
       binding.tvlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

      binding.etButton.setOnClickListener {
            validateSignUp()
        }
    }




    fun validateSignUp() {
        val firstName = binding.etFisrtname.text.toString()
        val lastName = binding.etlastname.text.toString()
        val email = binding.etemail.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etconfirmpassword.text.toString()
        var error = false

        if (firstName.isBlank()) {
            binding.tilfirstname.error = "First name is required"
            error = true

        }
        if (lastName.isBlank()) {
            binding.tilLastName.error = "Last name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }


        if (confirmPassword.isBlank()) {
            binding.tilConfirmPassword.error = "Password confirmation is required"
            error = true
        }
        if (password != confirmPassword) {
            binding.tilConfirmPassword.error = "Password and confirmation is not matching"
            error = true
        }
        if (!error) {
            Toast.makeText(this, "Sign up was successful,Hurray!", Toast.LENGTH_LONG)
                .show()
        }


    }
}


