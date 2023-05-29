package com.view.proyectofinal_registro_control_jaas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class Menu_Admin_Funcion_A_Crear : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin_funcion_a_crear)

        val facultad: Spinner = findViewById(R.id.facultad)

        // Crea un ArrayAdapter utilizando un arreglo de opciones
        val opciones = arrayOf("Administración de Empresas","Administración" +
                "Turística y Hotelera","Artes Visuales","Derecho","Ingeniería" +
                "de Sistemas","Ingeniería Civil")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        print(opciones)

        val cargo: Spinner = findViewById(R.id.cargo)

        // Crea un ArrayAdapter utilizando un arreglo de opciones
        val opciones1 = arrayOf("secretaria","rector","")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        print(opciones)

    }
}