package com.platina125.projectmobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.platina125.projectmobile.databinding.ActivityNoteMemoBinding
import com.platina125.room.RecyclerAdapter
import com.platina125.room.RoomHelper
import com.platina125.room.RoomMemo

class NoteMemo : AppCompatActivity() {
    val binding by lazy { ActivityNoteMemoBinding.inflate(layoutInflater) }
    var helper: RoomHelper? = null
    // 수정할 데이터 저장
    var updateMemo:RoomMemo? = null

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

        helper = Room.databaseBuilder(this, RoomHelper::class.java, "room_memo")
            .allowMainThreadQueries().build()

        val adapter = RecyclerAdapter()
        adapter.helper = helper

        adapter.listData.addAll(helper?.roomMemoDao()?.getAll()?: listOf())
        // 수정을 위해 메인액티비티 연결
        adapter.notememo = this
        //화면의 리사이클러뷰 위젯에 adapter를 연결하고 레이아웃 매니저를 설정
        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)

        binding.buttonSave.setOnClickListener {
            // 수정 체크 추가
            if (updateMemo != null) {
                updateMemo?.content = binding.editMemo.text.toString()
                helper?.roomMemoDao()?.update(updateMemo!!)
                refreshAdapter(adapter)
                cancelUpdate()
            }else if (binding.editMemo.text.toString().isNotEmpty()) {
                val memo = RoomMemo(binding.editMemo.text.toString(), System
                    .currentTimeMillis())
                helper?.roomMemoDao()?.insert(memo)

                adapter.listData.clear()
                adapter.listData.addAll(helper?.roomMemoDao()?.getAll()?: listOf())
                adapter.notifyDataSetChanged()
                binding.editMemo.setText("")
            }
        }
        binding.buttonCanel.setOnClickListener {
            cancelUpdate()
        }
    }

    fun setUpdate(memo:RoomMemo){
        updateMemo = memo

        binding.editMemo.setText(updateMemo!!.content)
        binding.buttonCanel.visibility = View.VISIBLE
        binding.buttonSave.text = "수정"
    }

    fun cancelUpdate() {
        updateMemo = null

        binding.editMemo.setText("")
        binding.buttonCanel.visibility = View.GONE
        binding.buttonSave.text = "저장"
    }

    fun refreshAdapter(adapter:RecyclerAdapter) {
        adapter.listData.clear()
        adapter.listData.addAll(helper?.roomMemoDao()?.getAll() ?: mutableListOf())
        adapter.notifyDataSetChanged()
    }
}