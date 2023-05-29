package com.view.proyectofinal_registro_control_jaas

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/*
* Autor: Andres Silva y Julian Alba
* Fecha: 22/04/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class Menu_Login : AppCompatActivity() {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    private val consultaCorreos = db.collection("correos")

    var usuario: String =  ""
    var contraseña: String = ""


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_login)

        val editText = findViewById<EditText>(R.id.contraseña)
        val ocultarIcono = resources.getDrawable(R.drawable.icono_mirarpassword)
        val mostrarIcono = resources.getDrawable(R.drawable.icono_ocultar_password)
        val candadoicono = resources.getDrawable(R.drawable.icono_password)
        /*metodo para que el usuario pueda ver la contraseña que esta digitando */
        setupPasswordVisibilityToggle(editText, ocultarIcono, mostrarIcono, candadoicono)


        val botonInicioSesion: Button =
            findViewById(R.id.IniciarSesion) //forma de capturar nuestros elementos de la vista y traerlos a la logica

        botonInicioSesion.setOnClickListener {

            iniciaSesion()
        } //metodo por si se da clic en el boton
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupPasswordVisibilityToggle(
        editText: EditText?,
        ocultarIcono: Drawable,
        mostrarIcono: Drawable,
        iconocandado: Drawable?
    ) {
        editText?.let {
            val drawableEnd =
                it.compoundDrawablesRelative[2] // Obtén la referencia al Drawable de drawableEnd
            drawableEnd?.let { drawable ->
                it.setOnTouchListener { _, event ->
                    val drawableEndPosition =
                        it.right - it.compoundPaddingEnd - drawable.intrinsicWidth
                    if (event.rawX >= drawableEndPosition) {
                        if (event.action == MotionEvent.ACTION_UP) {
                            // Cambia el tipo de entrada de la contraseña al hacer clic en el icono
                            if (it.inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                                it.inputType =
                                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                                it.setSelection(it.text.length) // Mueve el cursor al final del texto
                                it.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                    iconocandado,
                                    null,
                                    ocultarIcono,
                                    null
                                )
                            } else {
                                it.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                                it.setSelection(it.text.length) // Mueve el cursor al final del texto
                                it.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                    iconocandado,
                                    null,
                                    mostrarIcono,
                                    null
                                )
                            }
                            return@setOnTouchListener true
                        }
                    }
                    false
                }
            }
        }
    }

    private fun limpiarCamposTexto() {
        // Obtener las referencias de los EditText
        val editText1: EditText = findViewById(R.id.email_edittext)
        val editText2: EditText = findViewById(R.id.contraseña)

        // Limpia los campos de texto
        editText1.text.clear()
        editText2.text.clear()
    }

    private fun iniciaSesion() {

        val txtUsuario: EditText = findViewById(R.id.usuario)
        val txtContraseña: EditText = findViewById(R.id.contraseña)

        usuario = txtUsuario.text.toString()
        contraseña= txtContraseña.text.toString()

        var roles: String
        var estado: String

        println(
            "Sus datos son:\n"
                    + "Usuario: $usuario\n"
                    + "Contraseña: $contraseña\n"
        )


        if (usuario.isNotEmpty() && contraseña.isNotEmpty()) {

            consultaCorreos.document(usuario).get().addOnSuccessListener {

                println("Esta consultando...")

                if (it.exists()) {

                    roles = it.getString("Rol").toString()
                    estado = it.getString("Estado").toString()

                    println(roles)
                    println(estado)

                    if (estado == "Activo" || estado == "activo") {

                        when (roles) {

                            "Estudiante" -> {

                                auth.signInWithEmailAndPassword(usuario, contraseña)
                                    .addOnCompleteListener {

                                        println("$usuario| |$contraseña")

                                        println("esta procesando")

                                        if (it.isSuccessful) {
                                            Toast.makeText(
                                                this,
                                                "Inicio de sesion Exitoso",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()

                                             val intent = Intent(this, Activity_Menu_Estu::class.java)
                                            startActivity(intent)

                                            println("inicio sesion")

                                        } else {

                                            Toast.makeText(
                                                this,
                                                "Inicio de sesion Fallido",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()

                                            println("error al iniciar sesion")
                                        }
                                    }


                            }

                            "Docente" -> {

                                auth.signInWithEmailAndPassword(usuario, contraseña)
                                    .addOnCompleteListener {

                                        println("$usuario| |$contraseña")

                                        println("esta procesando")

                                        if (it.isSuccessful) {
                                            Toast.makeText(
                                                this,
                                                "Inicio de sesion Exitoso",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()

                                            // val intent = Intent(this, Interfaz_Docentes::class.java)
                                            // startActivity(intent)

                                            println("inicio sesion")

                                        } else {

                                            Toast.makeText(
                                                this,
                                                "Inicio de sesion Fallido",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()

                                            println("error al iniciar sesion")
                                        }
                                    }

                            }

                            "Administrativo" -> {

                            }

                            "Admin" -> {

                                auth.signInWithEmailAndPassword(usuario, contraseña)
                                    .addOnCompleteListener {

                                        println("$usuario| |$contraseña")

                                        println("esta procesando")

                                        if (it.isSuccessful) {
                                            Toast.makeText(
                                                this,
                                                "Inicio de sesion Exitoso",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()

                                            val intent = Intent(this, Menu_Admin::class.java)
                                            startActivity(intent)

                                            println("inicio sesion")

                                        } else {

                                            Toast.makeText(
                                                this,
                                                "Inicio de sesion Fallido",
                                                Toast.LENGTH_SHORT
                                            )
                                                .show()

                                            println("error al iniciar sesion")
                                        }
                                    }
                            }
                        }

                    } else {
                        Toast.makeText(this, "Usuario que entra inactivo", Toast.LENGTH_SHORT).show()

                    }
                } else {
                    Toast.makeText(this, "Usuario no registrado en BD", Toast.LENGTH_SHORT).show()

                }
            }

        } else {

            Toast.makeText(this, "Campos requeridos", Toast.LENGTH_SHORT).show()
        }
    }

}
