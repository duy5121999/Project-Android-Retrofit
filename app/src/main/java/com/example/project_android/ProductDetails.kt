package com.example.project_android

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val name = intent.getStringExtra("name")
        product_name.text = name

        availability.setOnClickListener{
            AlertDialog.Builder(this)
                .setMessage("Xin chao , $name van con hang")
                .setPositiveButton("ok"
                ) { dialog, which ->  }
                .create()
                .show()
        }
    }
}