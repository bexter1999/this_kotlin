package com.platina125.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.platina125.projectmobile.databinding.ActivityNoteMemoBinding
import com.platina125.room.RecyclerAdapter
import com.platina125.room.RoomHelper
import com.platina125.room.RoomMemo

class NoteMemo : AppCompatActivity() {
    val binding by lazy {ActivityNoteMemoBinding.inflate(layoutInflater) }
    var helper: RoomHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        helper = Room.databaseBuilder(this, RoomHelper::class.java, "room_memo")
            .allowMainThreadQueries().build()

        val adapter = RecyclerAdapter()
        adapter.helper = helper

        adapter.listData.addAll(helper?.roomMemoDao()?.getAll()?: listOf())
        //화면의 리사이클러뷰 위젯에 adapter를 연결하고 레이아웃 매니저를 설정
        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)

        binding.buttonSave.setOnClickListener {
            if (binding.editMemo.text.toString().isNotEmpty()) {
                val memo = RoomMemo(binding.editMemo.text.toString(), System
                    .currentTimeMillis())
                helper?.roomMemoDao()?.insert(memo)

                adapter.listData.clear()
                adapter.listData.addAll(helper?.roomMemoDao()?.getAll()?: listOf())
                adapter.notifyDataSetChanged()
                binding.editMemo.setText("")
            }
        }

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
    }
}