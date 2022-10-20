package com.platina125.project04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.project04.databinding.ActivityOnBoard2Binding
import com.platina125.project04.databinding.ActivityOnBoard3Binding

class OnBoard3 : AppCompatActivity() {
    val binding by lazy{ ActivityOnBoard3Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    val intent = Intent(this, OnBoard4::class.java)
    binding.OnBoardImg3.setOnClickListener {startActivity(intent)}
    }
}