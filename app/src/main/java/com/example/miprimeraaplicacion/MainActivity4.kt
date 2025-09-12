package com.example.miprimeraaplicacion

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)


        val btn_spinner: Button = findViewById(R.id.btn_spinner)
        val sp_int: Spinner = findViewById(R.id.sp_int)
        val ls_view: ListView = findViewById(R.id.ls_view)
        val btn_lista : Button = findViewById(R.id.btn_lista)

        //boton no se que hace funcion de spinner para que aparesca un mensaje con las opciones
        btn_spinner.setOnClickListener {

            var str_op_selected = sp_int.selectedItem.toString()

            val toast = Toast.makeText(
                this
                ,str_op_selected
                , Toast.LENGTH_SHORT)
            toast.show()
        }



        val opcionesSpinner = arrayOf(
            "Sumar"
            ,"Restar"
            ,"Multiplicar"
            ,"Hola Mundo"
            ,"Dividir")

        //adaptador de array
        val adaptador = ArrayAdapter(this //contexto
        , android.R.layout.simple_list_item_1 // elementos litview
        , opcionesSpinner) //objeto spinner
        //

        sp_int.adapter = adaptador

        val opcionesListView = arrayOf(
            "one"
            ,"two"
            ,"three"
            ,"four"
            ,"five"
            ,"six"
            ,"seven"
            ,"eight"
            ,"nine"
            ,"ten"
            ,"eleven"
            ,"puto"
            ,"maraco")

        val listView = ArrayAdapter(this
        ,android.R.layout.simple_list_item_checked
        , opcionesListView)

        ls_view.adapter = listView

        btn_lista.setOnClickListener {
            var str_ls_selected = ls_view.selectedItem.toString()

            val toast = Toast.makeText(
                this
                ,str_ls_selected
                , Toast.LENGTH_SHORT)
            toast.show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}