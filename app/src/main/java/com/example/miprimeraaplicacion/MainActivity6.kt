package com.example.miprimeraaplicacion

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)

        val txUsuario: TextView = findViewById(R.id.txUsuario)
        val recibirUsernameS = intent.getStringExtra("par_usern")
        val opcionesLV: ListView = findViewById(R.id.opciones_LV)

        txUsuario.text = recibirUsernameS.toString()


        val opcionesArr = arrayOf(
            "Calculadora"
            ,"Api Rest"
            ,"Api Nom"
        )

        val adaptador = ArrayAdapter(this
            , android.R.layout.simple_list_item_1
            , opcionesArr)

        opcionesLV.adapter = adaptador

        opcionesLV.setOnItemClickListener { parent, view, position, id ->
            val itemElegido = parent.getItemAtPosition(position).toString()

            if(itemElegido == "Calculadora"){
            val abrirCalculadora = Intent (this,MainActivity4::class.java)
                startActivity(abrirCalculadora)
            }else if (itemElegido == "Api Rest"){
            val abrirApiRest = Intent (this,MainActivity5::class.java)
                startActivity(abrirApiRest)
            }else if (itemElegido == "Api Nom"){
            val abrirApiNom = Intent (this,MainActivity7::class.java)
                startActivity(abrirApiNom)
            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}