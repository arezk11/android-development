package com.seneca.ecommerceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    val productList = listOf(
        Product(R.drawable.product1, "T-Shirt", "100% cotton great for school"),
        Product(R.drawable.product2, "Sneakers", "Comfortable running sneakers"),
        Product(R.drawable.product3, "Backpack", "heavy duty and stylish backpack"),
        Product(R.drawable.product4, "Smart Watch", "Track your steps and health metrics"),
        Product(R.drawable.product5, "Sunglasses", "Good for a sunny day"),
        Product(R.drawable.product6, "Headphones", "Great for the Gym"),

        Product(R.drawable.product1, "T-Shirt", "100% cotton great for school"),
        Product(R.drawable.product2, "Sneakers", "Comfortable running sneakers"),
        Product(R.drawable.product3, "Backpack", "heavy duty and stylish backpack"),
        Product(R.drawable.product4, "Smart Watch", "Track your steps and health metrics"),
        Product(R.drawable.product5, "Sunglasses", "Good for a sunny day"),
        Product(R.drawable.product6, "Headphones", "Great for the Gym"),

        Product(R.drawable.product1, "T-Shirt", "100% cotton great for school"),
        Product(R.drawable.product2, "Sneakers", "Comfortable running sneakers"),
        Product(R.drawable.product3, "Backpack", "heavy duty and stylish backpack"),
        Product(R.drawable.product4, "Smart Watch", "Track your steps and health metrics"),
        Product(R.drawable.product5, "Sunglasses", "Good for a sunny day"),
        Product(R.drawable.product6, "Headphones", "Great for the Gym"),

        Product(R.drawable.product1, "T-Shirt", "100% cotton great for school"),
        Product(R.drawable.product2, "Sneakers", "Comfortable running sneakers"),
        Product(R.drawable.product3, "Backpack", "heavy duty and stylish backpack"),
        Product(R.drawable.product4, "Smart Watch", "Track your steps and health metrics"),
        Product(R.drawable.product5, "Sunglasses", "Good for a sunny day"),
        Product(R.drawable.product6, "Headphones", "Great for the Gym"),

        Product(R.drawable.product1, "T-Shirt", "100% cotton great for school"),
        Product(R.drawable.product2, "Sneakers", "Comfortable running sneakers"),
        Product(R.drawable.product3, "Backpack", "heavy duty and stylish backpack"),
        Product(R.drawable.product4, "Smart Watch", "Track your steps and health metrics"),
        Product(R.drawable.product5, "Sunglasses", "Good for a sunny day"),
        Product(R.drawable.product6, "Headphones", "Great for the Gym"),

        Product(R.drawable.product1, "T-Shirt", "100% cotton great for school"),
        Product(R.drawable.product2, "Sneakers", "Comfortable running sneakers"),
        Product(R.drawable.product3, "Backpack", "heavy duty and stylish backpack"),
        Product(R.drawable.product4, "Smart Watch", "Track your steps and health metrics"),
        Product(R.drawable.product5, "Sunglasses", "Good for a sunny day"),
        Product(R.drawable.product6, "Headphones", "Great for the Gym"),

        Product(R.drawable.product1, "T-Shirt", "100% cotton great for school"),
        Product(R.drawable.product2, "Sneakers", "Comfortable running sneakers"),
        Product(R.drawable.product3, "Backpack", "heavy duty and stylish backpack"),
        Product(R.drawable.product4, "Smart Watch", "Track your steps and health metrics"),
        Product(R.drawable.product5, "Sunglasses", "Good for a sunny day"),
        Product(R.drawable.product6, "Headphones", "Great for the Gym"),

        Product(R.drawable.product1, "T-Shirt", "100% cotton great for school"),
        Product(R.drawable.product2, "Sneakers", "Comfortable running sneakers")
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList) { product ->
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("image", product.imageResId)
                putExtra("title", product.title)
                putExtra("description", product.description)
            }
            startActivity(intent)
        }
        val sliderBtn: Button = findViewById(R.id.btnSlider)
        sliderBtn.setOnClickListener {
            val intent = Intent(this, ImageSliderActivity::class.java)
            startActivity(intent)
        }
    }
}
