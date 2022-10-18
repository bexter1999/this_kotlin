package com.platina125.activitypractice2

import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.platina125.activitypractice2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val message = it.data?.getStringExtra("returnValue")
                Toast.makeText(this,message, Toast.LENGTH_LONG).show()
            }
        }

        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("thisisKey","thisisValue")
        intent.putExtra("thisisKey2",1475)
        binding.btnStart.setOnClickListener {activityResult.launch(intent) }
    }
}