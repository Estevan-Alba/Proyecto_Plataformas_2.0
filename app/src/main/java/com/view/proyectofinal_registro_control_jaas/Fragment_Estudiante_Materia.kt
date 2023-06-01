package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import android.view.View


class Fragment_Estudiante_Materia : Fragment(R.layout.fragment__estudiante__materia) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val irSalonA: Button = view.findViewById(R.id.irSalonA)

        irSalonA.setOnClickListener {
            val intent = Intent(activity, Activity_Estudiante_Video::class.java)
            startActivity(intent)
        }
    }
}