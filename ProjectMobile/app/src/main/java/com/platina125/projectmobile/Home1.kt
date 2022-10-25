package com.platina125.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.projectmobile.databinding.ActivityCalendarBinding
import com.platina125.projectmobile.databinding.ActivityHome1Binding

class Home1 : AppCompatActivity() {
    val binding by lazy{ActivityHome1Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = Intent(this, Calendar::class.java)
        binding.CalendarBtn.setOnClickListener{startActivity(intent)}
        binding.CalendarText.setOnClickListener{startActivity(intent)}
    }
}