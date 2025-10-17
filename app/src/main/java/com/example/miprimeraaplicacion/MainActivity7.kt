package com.example.miprimeraaplicacion

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimeraaplicacion.ApiSeleccion.InsertarAlumnoAPI

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)

        val edNombre: EditText = findViewById(R.id.edNombre)
        val edApellido: EditText = findViewById(R.id.edApellido)
        val spGrupo: Spinner = findViewById(R.id.spGrupo)
        val spSession: Spinner = findViewById(R.id.spSession)
        val btnEnviar: Button = findViewById(R.id.btnEnviar)


        val opcionGrupo = arrayOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15"

        )

        val adaptadorGrupo = ArrayAdapter(this
            ,android.R.layout.simple_spinner_item
            ,opcionGrupo).apply ()
        {
                setDropDownViewResource(android.R.layout.simple_spinner_item)
        }

        spGrupo.adapter = adaptadorGrupo

        val opcionSession = arrayOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
        )

        val adaptadorSession = ArrayAdapter(this
            ,android.R.layout.simple_spinner_item
            ,opcionSession).apply ()
        {
                setDropDownViewResource(android.R.layout.simple_spinner_item)
        }

        spSession.adapter = adaptadorSession

        btnEnviar.setOnClickListener {
            InsertarAlumnoAPI.insertarAlumno(
                owner = this,
                context = this,
                nombre = edNombre.text.toString(),
                apellido = edApellido.text.toString(),
                grupo = spGrupo.selectedItem.toString(),
                seccion = spSession.selectedItem.toString(),
                archivoBytes = null,
                onSuccess = {
                    println("termino insert correcto")
                    Toast.makeText(this
                    , "guardado"
                    , Toast.LENGTH_SHORT)
                },
                onError = {
                    println("termino insert incorrecto")
                    Toast.makeText(this
                        , "NO GUARDADO"
                        , Toast.LENGTH_SHORT)
                }
            )
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}