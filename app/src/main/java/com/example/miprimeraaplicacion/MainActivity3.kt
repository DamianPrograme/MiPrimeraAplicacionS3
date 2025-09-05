package com.example.miprimeraaplicacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimeraaplicacion.funciones.OpMatematicas

//package com.example.miprimeraaplicacion.funciones

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val txCalculadora: TextView = findViewById(R.id.tx_Calculadora)
        val edNumero1: EditText = findViewById(R.id.ed_num1)
        val edNumero2: EditText = findViewById(R.id.ed_num2)
        val btnOperacion: Button = findViewById(R.id.btn_operacion)
        val txResultado: TextView = findViewById(R.id.tx_resultado)



        btnOperacion.setOnClickListener {
            var numeroUno: Int = edNumero1.text.toString().toIntOrNull() ?: 0
            var numeroDos: Int = edNumero2.text.toString().toIntOrNull() ?: 0

            txResultado.text = OpMatematicas.dividirValores(numeroUno, numeroDos)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}