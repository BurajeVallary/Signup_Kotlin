package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tvLogin: TextView
    lateinit var tilFirstname:TextInputLayout
    lateinit var tilLastname:TextInputLayout
    lateinit var tilEmail:TextInputLayout
    lateinit var  tilPassword:TextInputLayout
    lateinit var tilConfirmPassword:TextInputLayout
    lateinit var etFirstName:TextInputEditText
    lateinit var etLastName:TextInputEditText
    lateinit var etEmail:TextInputEditText
    lateinit var etPassword:TextInputEditText
    lateinit var etConfirmPassword:TextInputEditText
    lateinit var etButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        tvLogin = findViewById(R.id.tvlogin)



    }

    override fun onResume() {
        super.onResume()
        tvLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        etButton.setOnClickListener {
            validateSignUp()
        }
    }
    fun castViews(){
        tvLogin = findViewById(R.id.tvlogin)
        tilFirstname = findViewById(R.id.tilfirstname)
        tilLastname = findViewById((R.id.tilLastName))
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)
        etFirstName = findViewById(R.id.etFisrtname)
        etLastName = findViewById(R.id.etlastname)
        etEmail = findViewById(R.id.etemail)
        etPassword = findViewById(R.id .etPassword)
        etConfirmPassword = findViewById(R.id.etconfirmpassword)
        etButton = findViewById(R.id.etButton)

    }

    fun validateSignUp(){
        val firstName = etFirstName.text.toString()
        val lastName = etLastName.text.toString()
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()
        var error = false

        if (firstName.isBlank()){
            tilFirstname.error = "First name is required"
            error = true

        }
        if (lastName.isBlank()){
            tilLastname.error = "Last name is required"
            error = true
        }
        if (email.isBlank()){
            tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()){
            tilPassword.error = "Password is required"
            error = true
        }


        if (confirmPassword.isBlank()){
            tilConfirmPassword.error = "Password confirmation is required"
            error = true
        }
        if(password!=confirmPassword){
            tilConfirmPassword.error ="Password and confirmation is not matching"
            error = true
        }
        if (!error){
            Toast.makeText(this,"Sign up was successful,Hurray!",Toast.LENGTH_LONG).show()
        }


    }
}


