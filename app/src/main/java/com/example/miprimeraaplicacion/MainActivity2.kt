package com.example.miprimeraaplicacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //esto nos sirve para recibir los usuarios desde la pantalla principal

        val txUsuario:TextView = findViewById(R.id.id_usuario_logueado)

        val recibirUsernameS = intent.getStringExtra("par_usern")
        val btnCalculadora: Button = findViewById(R.id.btn_calculadora)
        val btnMenu : Button = findViewById(R.id.btn_menu)
        val btnString: Button = findViewById(R.id.btn_Spirest)
        txUsuario.text = recibirUsernameS.toString()

        btnCalculadora.setOnClickListener{
            val nuevaVentana2 = Intent(this, MainActivity3::class.java)
            //esto es para mostrar el nombre de usuario en la ventana de inicio
            startActivity(nuevaVentana2)

        }

        btnMenu.setOnClickListener {
            val nuevaVentana4 = Intent(this, MainActivity4::class.java)
            startActivity(nuevaVentana4)
        }

        btnString.setOnClickListener {
            val nuevaVentana5 = Intent(this, MainActivity5::class.java)
            startActivity(nuevaVentana5)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}