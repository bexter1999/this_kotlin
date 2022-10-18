package com.platina125.activitypractice2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.activitypractice2.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy{ActivitySubBinding.inflate(layoutInflater)}
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.toOne.text = intent.getStringExtra("thisisKey")
        binding.toTwo.text = "${intent.getIntExtra("thisisKey2",0)}"

        binding.btnClose.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("returnValue",binding.editMessage.text.toString())
            setResult(RESULT_OK,returnIntent)
            finish()
        }
    }
}