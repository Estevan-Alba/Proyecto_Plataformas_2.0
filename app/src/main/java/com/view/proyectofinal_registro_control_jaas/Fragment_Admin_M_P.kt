package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button

/*
* Autor: Andres Silva y Julian Alba
* Fecha: 04/05/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class Fragment_Admin_M_P : Fragment(R.layout.fragment__admin__m__p) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //forma de capturar nuestros elementos de la vista y traerlos a la logic
        val botonIrCrearProfesor: Button = view.findViewById(R.id.crearProfesor)
        val botonIrConsultarProfesor: Button = view.findViewById(R.id.consultarProfesor)
        val botonIrActivaroInactivarProfesor: Button = view.findViewById(R.id.activaroInactivar)


        botonIrCrearProfesor.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_P_Crear::class.java)
            startActivity(intent)
        }

        botonIrConsultarProfesor.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_P_Consultar::class.java)
            startActivity(intent)
        }

        botonIrActivaroInactivarProfesor.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_P_Activar_InActivar::class.java)
            startActivity(intent)
        }
    }
}