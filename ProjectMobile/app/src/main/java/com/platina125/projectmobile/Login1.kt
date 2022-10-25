package com.platina125.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.projectmobile.databinding.ActivityLogin1Binding
import com.platina125.projectmobile.databinding.ActivityMainBinding

class Login1 : AppCompatActivity() {
    val binding by lazy{ActivityLogin1Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, Login2::class.java)
        binding.LoginKakao.setOnClickListener{startActivity(intent)}
        binding.LoginFacebook.setOnClickListener{startActivity(intent)}
        binding.LoginNaver.setOnClickListener{startActivity(intent)}
        binding.LoginGoogle.setOnClickListener{startActivity(intent)}
    }
}