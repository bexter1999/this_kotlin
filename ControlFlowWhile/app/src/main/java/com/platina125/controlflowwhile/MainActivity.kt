package com.platina125.controlflowwhile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var current = 1
        var until = 12
        while (current < until) {
            Log.d("while","현재값은 ${current}입니다")
            //current를 1씩 증가시켜서 11번 반복한 후 while문을 빠져나간다.
            current = current + 1
        }

        var game = 1
        var match = 6
        do {
            Log.d("while","${game}게임 이겼습니다. 우승까지${match-game}}")
            game += 1
        } while(game < match)
    }
}