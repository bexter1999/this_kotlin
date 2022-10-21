package com.platina125.project04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.project04.databinding.ActivityLogin2Binding

class Login2 : AppCompatActivity() {
    val binding by lazy{ActivityLogin2Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, Home::class.java)
        binding.btnLogin.setOnClickListener { startActivity(intent) }
    }
}