package com.example.week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.week6.databinding.ActivityMain2Binding
import com.example.week6.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity2 : AppCompatActivity() {
    private val viewBinding: ActivityMain2Binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val main2VPAdapter = Main2VPAdapter(this)
        viewBinding.vpMain.adapter = main2VPAdapter

        val tabTitleArray = arrayOf(
            "One", "Two"
        )

        TabLayoutMediator(viewBinding.tabMain, viewBinding.vpMain) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}