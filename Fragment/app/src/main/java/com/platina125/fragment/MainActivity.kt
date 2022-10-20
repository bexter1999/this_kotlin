package com.platina125.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.platina125.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    lateinit var listFragment:ListFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()
        
        binding.btnSend.setOnClickListener { 
            listFragment.setValue("전달할 값")
        }
    }
    fun setFragment(){ //리스트 Fragment 생성
        listFragment = ListFragment()
        //프래그먼트 생성시 값 전달하기 위한 변수설정 부분 3줄
        val bundle = Bundle()
        bundle.putString("key1","List Fragment")
        bundle.putInt("key2",20220101)
        listFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        // 트랜잭션의 add() 메서드로 frameLayout을 id로 가지고 있는 레이아ㅜㅅ에 앞에서 생성한 listFragment 삽입
        transaction.add(R.id.frameLayout, listFragment)
        // setFragment() 메서드 안에 다음과 같이 ListFragment를 생성
        transaction.commit()
    }

    fun goDetail(){ //리스트 Fragment 생성
        val detailFragment = DetailFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack(){
        onBackPressed()
    }


}