package com.platina125.project04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.project04.databinding.ActivityLogin1Binding

class Login1 : AppCompatActivity() {
    val binding by lazy{ActivityLogin1Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, Login2::class.java)
        binding.loginKakao.setOnClickListener {startActivity(intent)}
        binding.loginNaver.setOnClickListener {startActivity(intent)}
        binding.loginFacebook.setOnClickListener {startActivity(intent)}
        binding.loginGoogle.setOnClickListener {startActivity(intent)}
    }
}