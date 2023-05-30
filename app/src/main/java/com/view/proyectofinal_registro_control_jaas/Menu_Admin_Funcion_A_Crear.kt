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

class Menu_Admin_Funcion_A_Crear : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin_funcion_a_crear)

        val facultad: Spinner = findViewById(R.id.facultad)
        val cargo: Spinner = findViewById(R.id.cargo)

        // Crea un ArrayAdapter utilizando un arreglo de opciones
        val opciones = arrayOf(
            "Administración de Empresas", "Administración" +
                    "Turística y Hotelera", "Artes Visuales", "Derecho", "Ingeniería" +
                    "de Sistemas", "Ingeniería Civil"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        facultad.adapter = adapter

        // Crea un ArrayAdapter utilizando un arreglo de opciones
        val opciones1 = arrayOf("secretaria", "rector", "Decano", "Director de programa")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones1)
        cargo.adapter = adapter1

        val botonCrearAdministrativo: Button = findViewById(R.id.registar)
        val botonIrAtras: Button = findViewById(R.id.atras)

        botonCrearAdministrativo.setOnClickListener {
            registrarAdministrativo()
        }

        botonIrAtras.setOnClickListener {
            val intent = Intent(this, Fragment_Admin_M_A::class.java)
            startActivity(intent)
        }
    }

    private fun registrarAdministrativo() {


        val txtdocumento: EditText = findViewById(R.id.DOCUMENTO)
        val txtnombres: EditText = findViewById(R.id.NOMBRE)
        val txtapellidos: EditText = findViewById(R.id.APELLIDO)
        val txtedad: EditText = findViewById(R.id.EDAD)
        val txtdireccion: EditText = findViewById(R.id.DIRECCION)
        val txttelefono: EditText = findViewById(R.id.TELEFONO)
        val txtusaurio: EditText = findViewById(R.id.USUARIO)
        val txtcontraseña: EditText = findViewById(R.id.CONTRASEÑA)
        val txtrol: EditText = findViewById(R.id.ROL)
        val txtcargo: Spinner = findViewById(R.id.cargo)
        val txtfacultad: Spinner = findViewById(R.id.facultad)
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
        var cargo: String = txtcargo.selectedItem.toString()
        var facultad: String = txtfacultad.selectedItem.toString()
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
        )

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
                    cargo,
                    facultad,
                    experiencia,
                    universidad
                )

                Toast.makeText(this, "Correo $usuario registrado exitosamente", Toast.LENGTH_SHORT)
                    .show()
                println("Usuario creado con exito")

                val intent = Intent(this, Menu_Login::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Correo $usuario ya registrado", Toast.LENGTH_SHORT).show()
            }
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
        cargo: String,
        facultad: String,
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
                "Cargo" to cargo,
                "Facultad" to facultad,
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