package com.example.stan_7

import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import com.example.stan_7.databinding.ActivityMainBinding
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var total = 10;
    var started = false

    val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val minute = String.format("%02d", total / 60)
            val second = String.format("%02d", total % 60)
            binding.tvTimer.text = "$minute:$second"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val soundPool = SoundPool.Builder().build()
        val soundId = soundPool.load(this, R.raw.timefinish, 1)

        binding.btnStart.setOnClickListener {
            if (started == false) {
                started = true
                total = 10
                binding.tvTimer.text = "00:10"

                thread(start = true) {
                    while (started) {

                        Thread.sleep(1000)
                        if (started) {
                            total -= 1
                            handler?.sendEmptyMessage(0)
                        }
                        if (total == 0) {
                            soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f)
                            //왼쪽 볼륨, 오른쪽 볼륨, 우선순위(효과음이 여러개일때), 반복, 속도
                            started = false

                        }
                    }
                }
            }
        }

        binding.btnFinish.setOnClickListener {
            started = false
        }
    }
}