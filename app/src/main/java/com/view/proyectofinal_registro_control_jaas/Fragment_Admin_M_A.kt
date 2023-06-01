package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/*
* Autor: Andres Silva y Julian Alba
* Fecha: 04/05/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class Fragment_Admin_M_A : Fragment(R.layout.fragment__admin__m__a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //forma de capturar nuestros elementos de la vista y traerlos a la logic
        val botonIrCrearAdministrativo: Button = view.findViewById(R.id.crearAdministrativo)
        val botonIrConsultarAdministrativo: Button = view.findViewById(R.id.consultarAdministrativo)
        val botonIrActivaroInactivarAdministrativo: Button = view.findViewById(R.id.activaroInactivar)


        botonIrCrearAdministrativo.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_A_Crear::class.java)
            startActivity(intent)
        }

        botonIrConsultarAdministrativo.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_A_Consultar::class.java)
            startActivity(intent)
        }

        botonIrActivaroInactivarAdministrativo.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_A_Activar_InActivar::class.java)
            startActivity(intent)
        }
    }
}