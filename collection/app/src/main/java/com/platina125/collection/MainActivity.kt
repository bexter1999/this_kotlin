package com.platina125.collection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1. 값으로 컬렉션 생성하기
        var mutableList = mutableListOf("MON","TUE","WED")
        //값 추가하기
        mutableList.add("THU")
        //값 꺼내기
        Log.d("Collection","mutableList의 첫 번째 값은 ${mutableList.get(0)}입니다")
        Log.d("Collection","mutableList의 두 번째 값은 ${mutableList.get(1)}입니다")

        //2. 빈 컬렉션 생성하기
        var stringList = mutableListOf<String>() // 문자열로 된 빈 컬렉션 생성
        //값 추가하기
        stringList.add("월")
        stringList.add("화")
        stringList.add("수")
        //값 변경하기
        stringList.set(1, "요일 변경")
        //사용
        Log.d("Collection","stringList에 입력된 두 번째 값은 ${stringList.get(1)}입니다")
        //삭제
        stringList.removeAt(1) //두 번째 값이 삭제된다.
        Log.d("Collection","stringList에 입력된 두 번째 값은 ${stringList.get(1)}입니다")
        //개수를 출력한다
        Log.d("Collection","stringList에는 ${stringList.size}개의 값이 있습니다.")

        //컬렉션은 list, set, map을 의미함
        //list는 index를 사용, index가 있다란 뜻은 중복된 값을 넣을 수 있다는 뜻
        //set  = list - index, 중복이 없음, db 유니크랑 비슷함
        //map =  키와 값 키는 순서가 아닌 그냥 값 순서
        //배열과 컬렉션의 가장 큰 차이는 정해진 크기가 있냐 없냐

        //mutable = 변할 수 있는 변수
    }
}