package com.platina125.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.platina125.projectmobile.databinding.ActivityMainBinding
import com.platina125.projectmobile.databinding.ActivityTimerBinding
import kotlin.concurrent.thread

class Timer : AppCompatActivity() {

    val binding by lazy {ActivityTimerBinding.inflate(layoutInflater)}

    var total = 0
    var started = false
    val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val minute = String.format("%02d", total/60)
            val second = String.format("%02d", total%60)
            binding.textTimer.text = "$minute:$second"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intentHome = Intent(this, Home1::class.java)
        binding.HomeBtn.setOnClickListener{startActivity(intentHome)}
        val intentCommunity = Intent(this, Home2::class.java)
        binding.CommunityBtn.setOnClickListener{startActivity(intentCommunity)}
        val intentMap = Intent(this, Home3::class.java)
        binding.MapBtn.setOnClickListener{startActivity(intentMap)}
        val intentGallery = Intent(this, Home4::class.java)
        binding.GalleryBtn.setOnClickListener{startActivity(intentGallery)}
        val intentMyPage = Intent(this, Home5::class.java)
        binding.MyPageBtn.setOnClickListener{startActivity(intentMyPage)}

        binding.buttonStart.setOnClickListener {
            started = true
            if(total ==0){
                thread(start=true) {
                    while (started) {
                        Thread.sleep(1000)
                        if (started) {
                            total = total + 1
                            handler?.sendEmptyMessage(0)
                        }
                    }
                }
            }
        }
        binding.buttonStop.setOnClickListener {
            if (started) {
                started = false
                total = 0
                binding.textTimer.text = "00:00"
            }
        }
    }
}