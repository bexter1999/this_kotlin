package com.platina125.activitypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.platina125.activitypractice.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val message = it.data?.getStringExtra("returnValue")
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }

        var intent = Intent(this, SubActivity::class.java)
        intent.putExtra("from1","This is Bundle")
        intent.putExtra("from2",2022)
        binding.btnStart.setOnClickListener { startActivity(intent) }


    }
}