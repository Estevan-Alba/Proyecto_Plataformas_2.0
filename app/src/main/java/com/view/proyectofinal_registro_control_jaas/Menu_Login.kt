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
* Fecha: 22/04/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class Menu_Login : AppCompatActivity() {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    private val consulta = db.collection("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_login)

        val botonInicioSesion : Button = findViewById(R.id.IniciarSesion) //forma de capturar nuestros elementos de la vista y traerlos a la logica

        botonInicioSesion.setOnClickListener {

            iniciaSesion() } //metodo por si se da clic en el boton
    }



    private fun iniciaSesion() {


        val txtUsuario: EditText = findViewById(R.id.usuario)
        val txtContraseña : EditText = findViewById(R.id.contraseña)

        val usuario: String = txtUsuario.text.toString()
        val contraseña: String = txtContraseña.text.toString()

        var roles =""

        println("Sus datos son:\n"
                + "Usuario: $usuario\n"
                + "Contraseña: $contraseña\n")


        if(usuario.isNotEmpty() && contraseña.isNotEmpty()){
            
            consulta.document(usuario).get().addOnSuccessListener {

                println("Esta consultando...")
                if (it.exists()) {

                    roles = it.getString("Rol").toString()

                    println(roles)


                    when (roles) {

                        "Estudiante" -> {

                            auth.signInWithEmailAndPassword(usuario, contraseña).addOnCompleteListener {

                                println("$usuario| |$contraseña")

                                println("esta procesando")

                                if (it.isSuccessful) {
                                    Toast.makeText(this, "Inicio de sesion Exitoso", Toast.LENGTH_SHORT)
                                        .show()

                                   // val intent = Intent(this, Interfaz_Usuario::class.java)
                                    //startActivity(intent)

                                    println("inicio sesion")

                                } else {

                                    Toast.makeText(this, "Inicio de sesion Fallido", Toast.LENGTH_SHORT)
                                        .show()

                                    println("error al iniciar sesion")
                                }
                            }


                        }

                        "Docente" -> {

                            auth.signInWithEmailAndPassword(usuario, contraseña).addOnCompleteListener {

                                println("$usuario| |$contraseña")

                                println("esta procesando")

                                if (it.isSuccessful) {
                                    Toast.makeText(this, "Inicio de sesion Exitoso", Toast.LENGTH_SHORT)
                                        .show()

                                   // val intent = Intent(this, Interfaz_Docentes::class.java)
                                   // startActivity(intent)

                                    println("inicio sesion")

                                } else {

                                    Toast.makeText(this, "Inicio de sesion Fallido", Toast.LENGTH_SHORT)
                                        .show()

                                    println("error al iniciar sesion")
                                }
                            }

                        }

                        "Administrativo" -> {

                        }

                        "Admin" -> {

                            auth.signInWithEmailAndPassword(usuario, contraseña).addOnCompleteListener {

                                println("$usuario| |$contraseña")

                                println("esta procesando")

                                if (it.isSuccessful) {
                                    Toast.makeText(this, "Inicio de sesion Exitoso", Toast.LENGTH_SHORT)
                                        .show()

                                    val intent = Intent(this, Menu_Admin::class.java)
                                    startActivity(intent)

                                    println("inicio sesion")

                                } else {

                                    Toast.makeText(this, "Inicio de sesion Fallido", Toast.LENGTH_SHORT)
                                        .show()

                                    println("error al iniciar sesion")
                                }
                            }
                        }
                    }

                }else{
                    Toast.makeText(this, "Usuario no registrado en BD", Toast.LENGTH_SHORT).show()

                }
            }

        }else{

            Toast.makeText(this, "Campos requeridos", Toast.LENGTH_SHORT).show()
        }
    }

}