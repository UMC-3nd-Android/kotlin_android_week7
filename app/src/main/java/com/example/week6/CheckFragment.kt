package com.example.week6

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.example.week6.databinding.FragmentCheckBinding
import com.google.android.material.tabs.TabLayoutMediator

class CheckFragment : Fragment() {

    private val viewBinding: FragmentCheckBinding by lazy {
        FragmentCheckBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkVPAdapter = CheckVPAdapter(this)
        viewBinding.vpCheck.adapter = checkVPAdapter

        val tabTitleArray = arrayOf(
            "One", "Two", "Three"
        )

        TabLayoutMediator(viewBinding.tabCheck, viewBinding.vpCheck) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}