package com.platina125.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.projectmobile.databinding.ActivityHome1Binding
import com.platina125.projectmobile.databinding.ActivityHome3Binding

class Home3 : AppCompatActivity() {
    val binding by lazy{ ActivityHome3Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intentHome = Intent(this, Home1::class.java)
        binding.HomeBtn.setOnClickListener{startActivity(intentHome)}
        val intentCommunity = Intent(this, Home2::class.java)
        binding.CommunityBtn.setOnClickListener{startActivity(intentCommunity)}
        val intentGallery = Intent(this, Home4::class.java)
        binding.GalleryBtn.setOnClickListener{startActivity(intentGallery)}
        val intentMyPage = Intent(this, Home5::class.java)
        binding.MyPageBtn.setOnClickListener{startActivity(intentMyPage)}
    }
}