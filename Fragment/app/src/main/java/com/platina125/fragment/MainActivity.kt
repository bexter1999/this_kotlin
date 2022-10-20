package com.platina125.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment()
    }
    fun setFragment(){ //리스트 Fragment 생성
        val listFragment: ListFragment = ListFragment()

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