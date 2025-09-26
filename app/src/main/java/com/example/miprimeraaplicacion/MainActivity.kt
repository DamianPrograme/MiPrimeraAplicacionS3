package com.example.miprimeraaplicacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edUsername: EditText = findViewById(R.id.ed_username)
        val edPassw: EditText = findViewById(R.id.ed_passwd)
        val btnLogin: Button = findViewById(R.id.btn_login)
        val txMensaje: TextView = findViewById(R.id.tx_mensaje)

        // este es el usuario, y la contraseña para entrar
        var defUsername = "[Null]"
        var defPasswd = "admin1234"
        // este es el formato de lo que acepta el validar usuario
        btnLogin.setOnClickListener {
            if(edUsername.text.toString() == defUsername.toString()
                && edPassw.text.toString() == defPasswd.toString()){
                //este es la validacion de los datos para permitir la entrada
                val nuevaVentana = Intent(this, MainActivity6::class.java)
                //esto es para mostrar el nombre de usuario en la ventana de inicio
                nuevaVentana.putExtra("par_usern",edUsername.text.toString())


                startActivity(nuevaVentana)

            }else{
                txMensaje.text = "Error Usuario/Password"
            }
            //txMensaje.text = edUsername.text.toString()
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}