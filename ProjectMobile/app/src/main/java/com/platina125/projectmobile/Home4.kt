package com.platina125.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.projectmobile.databinding.ActivityHome4Binding

class Home4 : AppCompatActivity() {
    val binding by lazy { ActivityHome4Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intentHome = Intent(this, Home1::class.java)
        binding.HomeBtn.setOnClickListener{startActivity(intentHome)}
        val intentCommunity = Intent(this, Home2::class.java)
        binding.CommunityBtn.setOnClickListener{startActivity(intentCommunity)}
        val intentMap = Intent(this, Home3::class.java)
        binding.MapBtn.setOnClickListener{startActivity(intentMap)}
        val intentMyPage = Intent(this, Home5::class.java)
        binding.MyPageBtn.setOnClickListener{startActivity(intentMyPage)}
    }
}