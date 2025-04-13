package com.seneca.ecommerceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class ImageSliderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_slider)

        val viewPager: ViewPager2 = findViewById(R.id.viewPager)

        val images = listOf(
            R.drawable.slider1,
            R.drawable.slider2,
            R.drawable.slider3,
            R.drawable.slider4
        )

        val adapter = SliderAdapter(images)
        viewPager.adapter = adapter
    }
}
