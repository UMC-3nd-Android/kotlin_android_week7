package com.example.week7

import android.content.DialogInterface
import android.media.SoundPool
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.week7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val soundPool = SoundPool.Builder().build()
        val soundID = soundPool.load(this, R.raw.wtf, 1)

        var isStarted: Boolean
        val handler = Handler(mainLooper)

        val myToast = Toast.makeText(this.applicationContext, "타이머 종료", Toast.LENGTH_SHORT)
        val builder = AlertDialog.Builder(this)

        viewBinding.btnStart.setOnClickListener {
            val inMin = viewBinding.etMIn.text.toString()
            val inSec = viewBinding.etSIn.text.toString()
            var min = 0
            var sec = 0

            isStarted = true
            Thread() {
                while (isStarted) {
                    if (sec == 59) {
                        min++
                        sec = 0
                    } else {
                        sec++
                    }
                    if (inMin == min.toString() && inSec == sec.toString()) {
                        isStarted = false
                        handler.post {
                            myToast.show()

                            builder
                                .setTitle("비상비상!!!")
                                .setMessage("타이머 종료!!!!!@")
                                .setPositiveButton(
                                    "확인"
                                ) { _, _ ->
                                    viewBinding.tvM.text = "00"
                                    viewBinding.tvS.text = "00"
                                }
                            builder.create()
                            builder.show()

                            soundPool.play(soundID, 1.0f, 1.0f, 0, 0, 1.0f)
                        }
                    }
                    handler.post {
                        viewBinding.tvM.text = min.toString()
                        viewBinding.tvS.text = sec.toString()
                    }
                    Thread.sleep(1000)
                }
            }.start()
        }
    }
}