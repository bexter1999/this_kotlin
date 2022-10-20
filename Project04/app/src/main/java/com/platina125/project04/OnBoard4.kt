package com.platina125.project04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.project04.databinding.ActivityOnBoard3Binding
import com.platina125.project04.databinding.ActivityOnBoard4Binding

class OnBoard4 : AppCompatActivity() {
    val binding by lazy{ ActivityOnBoard4Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    val intent = Intent(this, OnBoard5::class.java)
    binding.OnBoardImg4.setOnClickListener {startActivity(intent)}
    }
}