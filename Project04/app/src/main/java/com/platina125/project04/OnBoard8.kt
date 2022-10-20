package com.platina125.project04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.project04.databinding.ActivityOnBoard8Binding

class OnBoard8 : AppCompatActivity() {
    val binding by lazy{ActivityOnBoard8Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, Login1::class.java)
        binding.OnBoardImg8.setOnClickListener {startActivity(intent)}
    }
}