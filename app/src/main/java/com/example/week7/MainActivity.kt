package com.example.week7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // 설정한 시간 지나면 화면에 타이머가 종료되었다고 알리면 됨.
        // 상단바에서 띄우는 알림.(추가로 해보고 싶다면)
        // 이거는 실습만으로도 ㄱㄴ.
        // text 업데이트 할 때에 Handler를 써야한다는 것.
        // 시간 흐르는 것은 타이머 내에서 해결
        val min = 0
        val sec = 0
        Thread(){
            while(true){

            }
        }.start()
    }
}