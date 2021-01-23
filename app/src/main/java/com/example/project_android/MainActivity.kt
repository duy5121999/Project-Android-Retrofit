package com.example.project_android

import android.os.Bundle
import android.util.Log.d
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project_android.Model.Product
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, MainFragment())
            .commit()

        navigationView.setNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.actionHome -> d("daniel", "Going home!")
                R.id.actionJeans -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, JeansFragment())
                        .commit()
                    d("daniel", "Jeans was pressed!")
                }
                R.id.actionShorts -> {
                    d("daniel", "Shorts was pressed!")
                }
            }
            it.isChecked = true
            drawerLayout.closeDrawers()
            true
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        }

        val products = arrayListOf<Product>()

        for (i in 0..100){
            products.add(Product(
                1.0,
                "Lamborgini #$i",
                "http://via.placeholder.com/200x200",
                "",
                46.0,
                239.0
            ))
        }


        recycler_view.apply {
            layoutManager = GridLayoutManager(this@MainActivity,2)
            adapter = ProductsAdapter(products)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
        return true
//        return super.onOptionsItemSelected(item)
    }
}