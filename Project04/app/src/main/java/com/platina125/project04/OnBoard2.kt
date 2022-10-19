package com.platina125.project04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.project04.databinding.ActivityMainBinding
import com.platina125.project04.databinding.ActivityOnBoard2Binding

class OnBoard2 : AppCompatActivity() {
    val binding by lazy{ ActivityOnBoard2Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}