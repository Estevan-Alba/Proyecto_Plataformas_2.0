package com.view.proyectofinal_registro_control_jaas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Menu_Admin_Funcion_P_Crear : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin_funcion_p_crear)

        val spinner: Spinner = findViewById(R.id.MATERIA)

        // Crea un ArrayAdapter utilizando un arreglo de opciones
        val opciones = arrayOf(
            "Fundamento Matemático",
            "Física I",
            "Lógica Matemática",
            "Introducción a la Ingeniería",
            "Algoritmia",
            "Técnicas de Lectura y Escritua",
            "Vida Universitaria"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        spinner.adapter = adapter


        val botonCrearEstudiante: Button = findViewById(R.id.registar)
        val botonIrAtras: Button = findViewById(R.id.ATRASDO)

        botonIrAtras.setOnClickListener {
            val intent = Intent(this, Menu_Admin::class.java)
            startActivity(intent)
        }

        botonCrearEstudiante.setOnClickListener {
            registrarDocente()
        }


    }

    private fun registrarDocente() {


        val txtdocumento: EditText = findViewById(R.id.DOCUMENTO)
        val txtnombres: EditText = findViewById(R.id.NOMBRE)
        val txtapellidos: EditText = findViewById(R.id.APELLIDO)
        val txtedad: EditText = findViewById(R.id.EDAD)
        val txtdireccion: EditText = findViewById(R.id.DIRECCION)
        val txttelefono: EditText = findViewById(R.id.TELEFONO)
        val txtusaurio: EditText = findViewById(R.id.USUARIO)
        val txtcontraseña: EditText = findViewById(R.id.CONTRASEÑA)
        val txtrol: EditText = findViewById(R.id.ROL)
        val txtmateria: Spinner = findViewById(R.id.MATERIA)
        val txtexperiencia: EditText = findViewById(R.id.EXPERIENCIA)
        val txtuniversidad: EditText = findViewById(R.id.UNIVERSIDAD)


        var documento: String = txtdocumento.text.toString()
        var nombres: String = txtnombres.text.toString()
        var apellido: String = txtapellidos.text.toString()
        var edad: String = txtedad.text.toString()
        var direccion: String = txtdireccion.text.toString()
        var telefono: String = txttelefono.text.toString()
        var usuario: String = txtusaurio.text.toString()
        var contraseña: String = txtcontraseña.text.toString()
        var roles: String = txtrol.text.toString()
        var materia: String = txtmateria.selectedItem.toString()
        var experiencia: String = txtexperiencia.text.toString()
        var universidad: String = txtuniversidad.text.toString()

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
                    + "Materia: $materia"
                    + "Experiencia: $experiencia"
                    + "Universidad: $universidad"
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
            && materia.isNotEmpty()
            && experiencia.isNotEmpty()
            && universidad.isNotEmpty()
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
                        estado,
                        materia,
                        experiencia,
                        universidad
                    )

                    Toast.makeText(
                        this,
                        "Correo $usuario registrado exitosamente",
                        Toast.LENGTH_SHORT
                    )
                        .show()

                    val intent = Intent(this, Menu_Login::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Correo $usuario ya registrado", Toast.LENGTH_SHORT).show()
                }
            }

        } else {

            Toast.makeText(this, "Campos requeridos ", Toast.LENGTH_SHORT).show()
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
        estado: String,
        materia: String,
        experiencia: String,
        universidad: String
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
                Toast.makeText(this, "El usuario ya se encuentra registrado", Toast.LENGTH_SHORT)
                    .show()
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
                "Estado" to estado,
                "Materia" to materia,
                "Experiencia" to experiencia,
                "Universidad" to universidad
            )
        ).addOnCompleteListener {

            if (it.isSuccessful) {
                Toast.makeText(this, "Datos registrados", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "El usuario ya se encuentra registrado", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}