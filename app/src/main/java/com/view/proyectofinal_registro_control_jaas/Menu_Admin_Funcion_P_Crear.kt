package com.view.proyectofinal_registro_control_jaas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class Menu_Admin_Funcion_P_Crear : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin_funcion_p_crear)

        val spinner: Spinner = findViewById(R.id.materia)

        // Crea un ArrayAdapter utilizando un arreglo de opciones
        val opciones = arrayOf("Fundamento Matemático", "Física I", "Lógica Matemática", "Introducción a la Ingeniería", "Algoritmia", "Técnicas de Lectura y Escritua", "Vida Universitaria")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        print(opciones)

    }
}