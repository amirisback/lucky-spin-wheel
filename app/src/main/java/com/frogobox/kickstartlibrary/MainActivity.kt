package com.frogobox.kickstartlibrary

import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.frogobox.frogolib.OnLuckyWheelReachTheTarget
import com.frogobox.frogolib.WheelItem

import com.frogobox.kickstartlibrary.databinding.ActivityMainBinding

/**
 * Created by Amir on 08/28/23
 * lucky-spin-wheel Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2023 FrogoBox Inc.
 * All rights reserved
 */
class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.lwv.addWheelItems(generateWheelItems())
        binding.lwv.setTarget(3)
        binding.lwv.setLuckyWheelReachTheTarget(object: OnLuckyWheelReachTheTarget {
            override fun onReachTarget() {
                Toast.makeText(this@MainActivity, "Target Reached", Toast.LENGTH_LONG).show()
            }
        })

        binding.start.setOnClickListener {
            binding.lwv.rotateWheelTo(0)
        }
    }

    private fun generateWheelItems() : MutableList<WheelItem> {
        return mutableListOf<WheelItem>().apply {
            add(WheelItem(Color.parseColor("#fc6c6c"), BitmapFactory.decodeResource(resources, R.drawable.chat), "100 $"))
            add(WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(resources, R.drawable.coupon), "0 $"))
            add(WheelItem(Color.parseColor("#F00E6F"), BitmapFactory.decodeResource(resources, R.drawable.ice_cream), "30 $"))
            add(WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(resources, R.drawable.lemonade), "6000 $"))
            add(WheelItem(Color.parseColor("#fc6c6c"), BitmapFactory.decodeResource(resources, R.drawable.orange), "9 $"))
            add(WheelItem(Color.parseColor("#00E6FF"), BitmapFactory.decodeResource(resources, R.drawable.shop), "20 $"))
        }
    }
}