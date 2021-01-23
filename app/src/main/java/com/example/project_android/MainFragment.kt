package com.example.project_android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.project_android.Model.Product
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val products = arrayListOf<Product>()

        for (i in 0..100){
            products.add(
                Product(
                1.0,
                "Lamborgini #$i",
                "http://via.placeholder.com/200x200",
                "",
                46.0,
                239.0
            )
            )
        }

        root.recycler_view.apply {
            layoutManager = GridLayoutManager(activity,2)
            adapter = ProductsAdapter(products)
        }

        return root
    }
}