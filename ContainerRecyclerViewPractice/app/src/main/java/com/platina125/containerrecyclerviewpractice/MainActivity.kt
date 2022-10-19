package com.platina125.containerrecyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.platina125.containerrecyclerviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data: MutableList<Memo> = loadData()
        var adapter = CustomAdapter()
        adapter.listData = data
        binding.recyclerView.adapter = adapter

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun loadData(): MutableList<Memo>{
        val data: MutableList<Memo> = mutableListOf()
        for (no in 1..100){
            val title = "이것이 ${no} 번째 안드로이드인가?"
            val date = System.currentTimeMillis()

            var memo = Memo(no, title, date)
            data.add(memo)
        }
        return data
    }
}