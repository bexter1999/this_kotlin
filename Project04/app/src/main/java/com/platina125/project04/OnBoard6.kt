package com.platina125.project04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.project04.databinding.ActivityOnBoard6Binding

class OnBoard6 : AppCompatActivity() {
    val binding by lazy{ActivityOnBoard6Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, OnBoard7::class.java)
        binding.OnBoardImg6.setOnClickListener {startActivity(intent)}
    }
}