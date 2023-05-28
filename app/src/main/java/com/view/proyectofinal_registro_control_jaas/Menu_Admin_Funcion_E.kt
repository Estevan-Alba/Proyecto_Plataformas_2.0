package com.view.proyectofinal_registro_control_jaas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner


class Menu_Admin_Funcion_E : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_admin_funcion_e)

        val spinner = findViewById<Spinner>(R.id.scrollear)

        val items = arrayOf("Estudiante", "Docente", "Administrativo")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

        spinner.adapter=adapter
    }

}