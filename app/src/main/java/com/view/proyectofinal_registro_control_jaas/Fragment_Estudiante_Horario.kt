package com.view.proyectofinal_registro_control_jaas

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

/*
* Autor: Andres Silva y Julian Alba
* Fecha: 04/05/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */



class Fragment_Estudiante_Horario : Fragment(R.layout.fragment__estudiante__horario) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val botonIrHorario: Button = view.findViewById(R.id.irAlHorario)

        botonIrHorario.setOnClickListener {
            val intent = Intent(activity, Activity_Mostrar_Horario::class.java)
            startActivity(intent)
        }
    }
}