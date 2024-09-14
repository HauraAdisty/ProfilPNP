package com.haura.profilpnp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Gallery
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.haura.profilpnp.Adapter.GalleryAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var btnManajemenInformatika: Button
    private lateinit var btnTeknikKomputer : Button
    private lateinit var btnGaleriPhoto : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnManajemenInformatika= findViewById(R.id.btnMi)
        btnTeknikKomputer=findViewById(R.id.btnTekom)
        btnGaleriPhoto = findViewById(R.id.galeriphoto)

        btnManajemenInformatika.setOnClickListener(){
            val intent = Intent(this, ManajemenInformatika::class.java)
            startActivity(intent)
        }
        btnTeknikKomputer.setOnClickListener(){
            val intent = Intent(this, TeknikKomputer::class.java)
            startActivity(intent)
        }
        btnGaleriPhoto.setOnClickListener(){
            val intent = Intent(this, Galery ::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}