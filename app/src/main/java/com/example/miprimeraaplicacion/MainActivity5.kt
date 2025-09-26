package com.example.miprimeraaplicacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimeraaplicacion.ApiRegionComuna.CargarRegionComunaAPI

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)


        val spRegion: Spinner = findViewById(R.id.sp_region)
        val spComuna: Spinner = findViewById(R.id.sp_comuna)
        val btnAccion: Button = findViewById(R.id.btn_accion)

        CargarRegionComunaAPI.cargarRegionComuna(this, spRegion)
        CargarRegionComunaAPI.cargarRegionComuna2(this, spComuna)




        btnAccion.setOnClickListener {

        }




        //solo es la variable para volver al inicio
        val btnInicio : Button = findViewById(R.id.btn_inicio)

        btnInicio.setOnClickListener {
            val nuevaVentana2 = Intent(this, MainActivity2::class.java)
            startActivity(nuevaVentana2)
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}