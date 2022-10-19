package com.platina125.containerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 100개의 list를 가상으로 만듭니다.
        fun loadData(): MutableList<Memo>{
            val data: MutableList<Memo> = mutableListOf()
            for (no in 1..100){

            }
        }
    }
}