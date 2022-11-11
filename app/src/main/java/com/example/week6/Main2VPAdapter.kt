package com.example.week6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class Main2VPAdapter(FragmentActivity : FragmentActivity): FragmentStateAdapter(FragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> OneFragment()
            1 -> TwoFragment()
            else -> OneFragment()
        }
    }
}