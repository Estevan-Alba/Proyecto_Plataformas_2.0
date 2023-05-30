package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class Menu_Admin_Funcion_A_Activar_InActivar : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val consultaUsuarios = db.collection("usuarios")

    private val ActualizarEstadoCorreos = db.collection("correos")
    private val actualizarEstadoUsuarios = db.collection("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin_funcion_a_activar_in_activar)



        val botonActualizarEstado: Button = findViewById(R.id.enviarEstado)
        val botonConsultarAdministrativo: Button = findViewById(R.id.buscarEstudiante)

        val botonIrAtras: Button = findViewById(R.id.ATRASAD)

        botonIrAtras.setOnClickListener {
            val intent = Intent(this, Menu_Admin::class.java)
            startActivity(intent)
        }


        botonActualizarEstado.setOnClickListener {
            actualizarEstado()
        }

        botonConsultarAdministrativo.setOnClickListener {
            consultarAdministrativo()
        }


    }

    private fun consultarAdministrativo() {

        val txtdocumento: EditText = findViewById(R.id.DOCUMENTO)
        val documento: String = txtdocumento.text.toString()

        var dato1: String
        var dato2: String
        var dato3: String

        consultaUsuarios.document(documento).get().addOnSuccessListener {
            println("Esta consultando el estudiante...")

            if (it.exists()) {


                dato1 = it.getString("Estado").toString()
                dato2 = it.getString("Nombres").toString()
                dato3 = it.getString("Usuario").toString()

                val txtnombres: EditText = findViewById(R.id.NOMBRE)
                val txtusaurio: EditText = findViewById(R.id.USUARIO)
                val txtestado: EditText = findViewById(R.id.ESTADO)


                txtestado.setText(dato1)
                txtnombres.setText(dato2)
                txtusaurio.setText(dato3)
            }
        }

    }

    private fun actualizarEstado() {

        val txtdocumento: EditText = findViewById(R.id.DOCUMENTO)
        val txtnombres: EditText = findViewById(R.id.NOMBRE)
        val txtusaurio: EditText = findViewById(R.id.USUARIO)
        val txtestado: EditText = findViewById(R.id.ESTADO)

        var documento: String = txtdocumento.text.toString()
        var usuario: String = txtusaurio.text.toString()
        var estado: String = txtestado.text.toString()

        val datosActualizados = hashMapOf<String, Any>(
            "Estado" to estado
        )

        actualizarEstadoUsuarios.document(documento).update(datosActualizados)

            .addOnSuccessListener {
                Toast.makeText(this, "Estado Actualizado correctamente", Toast.LENGTH_SHORT).show()
                txtdocumento.text.clear()
                txtnombres.text.clear()
                txtusaurio.text.clear()
                txtestado.text.clear()
            }
            .addOnFailureListener {
                Toast.makeText(this, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show()
            }

        ActualizarEstadoCorreos.document(usuario).update(datosActualizados)

            .addOnSuccessListener {
                Toast.makeText(this, "Estado Actualizado correctamente", Toast.LENGTH_SHORT).show()
                txtdocumento.text.clear()
                txtnombres.text.clear()
                txtusaurio.text.clear()
                txtestado.text.clear()
            }
            .addOnFailureListener {
                Toast.makeText(this, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show()
            }

    }
}