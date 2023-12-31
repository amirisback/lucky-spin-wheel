package com.frogobox.appspinwheel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.appspinwheel.databinding.ActivityMainBinding
import com.frogobox.spinwheel.WheelItem

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

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.lwv.addWheelItems(generateWheelItems())
        binding.lwv.setLuckyWheelReachTheTarget {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_LONG).show()
        }

        binding.start.setOnClickListener {
            binding.lwv.rotateWheel()
        }
    }

    private fun generateWheelItems(): MutableList<WheelItem> {
        return mutableListOf<WheelItem>().apply {
            add(WheelItem(this@MainActivity, R.color.wheel_1, R.drawable.chat, "0", ))
            add(WheelItem(this@MainActivity, R.color.wheel_2, R.drawable.coupon, "1", ))
            add(WheelItem(this@MainActivity, R.color.wheel_3, R.drawable.ice_cream, "2", ))
            add(WheelItem(this@MainActivity, R.color.wheel_4, R.drawable.lemonade, "3", ))
            add(WheelItem(this@MainActivity, R.color.wheel_5, R.drawable.orange, "4", ))
            add(WheelItem(this@MainActivity, R.color.wheel_6, R.drawable.shop, "5", ))
        }
    }
}