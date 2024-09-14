package com.haura.profilpnp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.haura.profilpnp.Adapter.GalleryAdapter

class Galery : AppCompatActivity() {
    private val imageList = arrayOf(
        R.drawable.labor,
        R.drawable.pkmpnp,
        R.drawable.ti,
        R.drawable.programstudi,
        R.drawable.poli,
    )
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_galery)

        val gridView = findViewById<GridView>(R.id.gridView)
        val adapter =GalleryAdapter(this, imageList)
        gridView.adapter = adapter

        // Set up onClickListener for grid items
        gridView.setOnItemClickListener { _, _, position, _ ->
            val Intent = Intent(this, PhotoDetail::class.java)
            Intent.putExtra("imageResId", imageList[position]) // Pass the selected image ID to detail activity
            startActivity(Intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}