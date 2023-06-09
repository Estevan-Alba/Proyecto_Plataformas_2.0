package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
/*
* Autor: Andres Silva y Julian Alba
* Fecha: 27/04/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class Menu_Admin_Funcion_E_Crear : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin_funcion_e_crear)

        val botonCrearEstudiante: Button = findViewById(R.id.registar)
        val botonIrAtras: Button = findViewById(R.id.ATRASES)

        botonCrearEstudiante.setOnClickListener {
            registrarEstudiante()
        }

        botonIrAtras.setOnClickListener {
            val intent = Intent(this, Menu_Admin::class.java)
            startActivity(intent)
        }
    }

    private fun registrarEstudiante() {


        val txtdocumento: EditText = findViewById(R.id.DOCUMENTO)
        val txtnombres: EditText = findViewById(R.id.NOMBRE)
        val txtapellidos: EditText = findViewById(R.id.APELLIDO)
        val txtedad: EditText = findViewById(R.id.EDAD)
        val txtdireccion: EditText = findViewById(R.id.DIRECCION)
        val txttelefono: EditText = findViewById(R.id.TELEFONO)
        val txtusaurio: EditText = findViewById(R.id.USUARIO)
        val txtcontraseña: EditText = findViewById(R.id.CONTRASEÑA)
        val txtrol: EditText = findViewById(R.id.ROL)


        var documento: String = txtdocumento.text.toString()
        var nombres: String = txtnombres.text.toString()
        var apellido: String = txtapellidos.text.toString()
        var edad: String = txtedad.text.toString()
        var direccion: String = txtdireccion.text.toString()
        var telefono: String = txttelefono.text.toString()
        var usuario: String = txtusaurio.text.toString()
        var contraseña: String = txtcontraseña.text.toString()
        var roles: String = txtrol.text.toString()

        var estado = "Activo"

        println(
            "Sus datos son:\n"
                    + "Documento: $documento\n"
                    + "Nombres: $nombres\n"
                    + "Apellidos: $apellido\n"
                    + "Edad: $edad\n"
                    + "Direccion: $direccion\n"
                    + "Telefono: $telefono\n"
                    + "Usuario: $usuario\n"
                    + "Contraseña: $contraseña\n"
                    + "Rol: $roles"
        )


        if (   documento.isNotEmpty()
            && nombres.isNotEmpty()
            && apellido.isNotEmpty()
            && edad.isNotEmpty()
            && direccion.isNotEmpty()
            && telefono.isNotEmpty()
            && usuario.isNotEmpty()
            && contraseña.isNotEmpty()
            && roles.isNotEmpty()
            && estado.isNotEmpty()
            && documento.matches(Regex("[0-9]*"))
        ) {

            auth.createUserWithEmailAndPassword(usuario, contraseña).addOnCompleteListener(this) {

                if (it.isSuccessful) {

                    registrarBD(
                        documento,
                        nombres,
                        apellido,
                        edad,
                        direccion,
                        telefono,
                        usuario,
                        contraseña,
                        roles,
                        estado
                    )

                    Toast.makeText(this, "Correo $usuario registrado exitosamente", Toast.LENGTH_SHORT)
                        .show()
                    println("Usuario creado con exito")

                    txtdocumento.text.clear()
                    txtnombres.text.clear()
                    txtapellidos.text.clear()
                    txtedad.text.clear()
                    txtdireccion.text.clear()
                    txttelefono.text.clear()
                    txtusaurio.text.clear()
                    txtcontraseña.text.clear()
                    txtrol.text.clear()

                } else {
                    Toast.makeText(this, "Correo $usuario ya registrado", Toast.LENGTH_SHORT).show()
                }
            }

        }else{
            Toast.makeText(this, "Campos requeridos", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Documento tiene que ser numerico", Toast.LENGTH_SHORT).show()
        }
    }

    private fun registrarBD(
        documento: String,
        nombres: String,
        apellido: String,
        edad: String,
        direccion: String,
        telefono: String,
        usuario: String,
        contraseña: String,
        roles: String,
        estado: String
    ) {

        db.collection("correos").document(usuario).set(
            hashMapOf(
                "Rol" to roles,
                "Estado" to estado
            )
        ).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(this, "Datos registrados", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "El usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show()
            }
        }

        db.collection("usuarios").document(documento).set(
            hashMapOf(
                "Documento" to documento,
                "Nombres" to nombres,
                "Apellidos" to apellido,
                "Edad" to edad,
                "Direccion" to direccion,
                "Telefono" to telefono,
                "Usuario" to usuario,
                "Contraseña" to contraseña,
                "Rol" to roles,
                "Estado" to estado
            )
        ).addOnCompleteListener {

            if (it.isSuccessful) {
                Toast.makeText(this, "Datos registrados", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "El usuario ya se encuentra registrado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}