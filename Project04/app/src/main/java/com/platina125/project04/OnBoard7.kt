package com.platina125.project04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.project04.databinding.ActivityOnBoard6Binding
import com.platina125.project04.databinding.ActivityOnBoard7Binding

class OnBoard7 : AppCompatActivity() {
    val binding by lazy{ActivityOnBoard7Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, OnBoard8::class.java)
        binding.OnBoardImg7.setOnClickListener {startActivity(intent)}
    }
}