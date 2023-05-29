package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button

class Fragment_Admin_M_E : Fragment(R.layout.fragment__admin__m_e) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//forma de capturar nuestros elementos de la vista y traerlos a la logic
        val botonIrCrearEstudiante: Button = view.findViewById(R.id.crearEstudiante)
        val botonIrConsultarEstudiante: Button = view.findViewById(R.id.consultarEstudiante)
        val botonIrActivaroInactivarEstudiante: Button = view.findViewById(R.id.activaroInactivar)


        botonIrCrearEstudiante.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_E_Crear::class.java)
            startActivity(intent)
        }

        botonIrConsultarEstudiante.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_E_Consultar::class.java)
            startActivity(intent)
        }

        botonIrActivaroInactivarEstudiante.setOnClickListener {
            val intent = Intent(activity, Menu_Admin_Funcion_E_Activar_InActivar::class.java)
            startActivity(intent)
        }
    }
}