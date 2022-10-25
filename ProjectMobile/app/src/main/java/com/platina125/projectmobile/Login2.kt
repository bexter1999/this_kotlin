package com.platina125.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.projectmobile.databinding.ActivityLogin2Binding

class Login2 : AppCompatActivity() {
    val binding by lazy{ActivityLogin2Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, Home1::class.java)
        binding.LoginLogin.setOnClickListener{startActivity(intent)}
    }
}