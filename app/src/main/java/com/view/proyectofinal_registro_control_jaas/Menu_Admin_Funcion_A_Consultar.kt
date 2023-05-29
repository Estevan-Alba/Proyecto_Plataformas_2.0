package com.view.proyectofinal_registro_control_jaas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class Menu_Admin_Funcion_A_Consultar : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val consultaUsuarios = db.collection("usuarios")
    private val actualizarUsuarios = db.collection("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin_funcion_a_consultar)


        val facultad: Spinner = findViewById(R.id.facultad)

        // Crea un ArrayAdapter utilizando un arreglo de opciones
        val opciones = arrayOf("Administración de Empresas","Administración" +
                "Turística y Hotelera","Artes Visuales","Derecho","Ingeniería" +
                "de Sistemas","Ingeniería Civil")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        print(opciones)

        val cargo: Spinner = findViewById(R.id.cargo)

        // Crea un ArrayAdapter utilizando un arreglo de opciones
        val opciones1 = arrayOf("decano","secretaria","documentacion","directora de programa","administrador archivos")
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        print(opciones)

        val botonConsultarEstudiante: Button = findViewById(R.id.consultarEstudiantes)

        val botonActualizarEstudiante: Button = findViewById(R.id.actualizarEstudiante)


        botonActualizarEstudiante.setOnClickListener {
            actualizarEstudiate()
        }

        botonConsultarEstudiante.setOnClickListener {
            consultarEstudiante()
        }
    }

    private fun actualizarEstudiate() {

        val txtdocumento: EditText = findViewById(R.id.DOCUMENTO)
        val txtnombres: EditText = findViewById(R.id.NOMBRE)
        val txtapellidos: EditText = findViewById(R.id.APELLIDO)
        val txtedad: EditText = findViewById(R.id.EDAD)
        val txtdireccion: EditText = findViewById(R.id.DIRECCION)
        val txttelefono: EditText = findViewById(R.id.TELEFONO)
        val txtusaurio: EditText = findViewById(R.id.USUARIO)
        val txtcontraseña: EditText = findViewById(R.id.CONTRASEÑA)
        val txtrol: EditText = findViewById(R.id.ROL)
        val txtestado: EditText = findViewById(R.id.ESTADO)

        var documento: String = txtdocumento.text.toString()
        var nombres: String = txtnombres.text.toString()
        var apellido: String = txtapellidos.text.toString()
        var edad: String = txtedad.text.toString()
        var direccion: String = txtdireccion.text.toString()
        var telefono: String = txttelefono.text.toString()
        var usuario: String = txtusaurio.text.toString()
        var contraseña: String = txtcontraseña.text.toString()
        var roles: String = txtrol.text.toString()
        var estado: String = txtestado.text.toString()

        val datosActualizados = hashMapOf<String, Any>(
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

        actualizarUsuarios.document(documento).update(datosActualizados)

            .addOnSuccessListener {
                Toast.makeText(this, "Datos Actualizados correctamente", Toast.LENGTH_SHORT).show()
                txtdocumento.text.clear()
                txtnombres.text.clear()
                txtapellidos.text.clear()
                txtedad.text.clear()
                txtdireccion.text.clear()
                txttelefono.text.clear()
                txtusaurio.text.clear()
                txtcontraseña.text.clear()
                txtrol.text.clear()
                txtestado.text.clear()
            }
            .addOnFailureListener {
                Toast.makeText(this, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show()
            }

    }

    private fun consultarEstudiante() {

        val txtdocumento: EditText = findViewById(R.id.DOCUMENTO)
        val documento: String = txtdocumento.text.toString()




        var dato1: String
        var dato2: String
        var dato3: String
        var dato4: String
        var dato5: String
        var dato6: String
        var dato7: String
        var dato8: String
        var dato9: String
        var dato10: String


        consultaUsuarios.document(documento).get().addOnSuccessListener {
            println("Esta consultando el estudiante...")

            if (it.exists()) {


                dato1 = it.getString("Apellidos").toString()
                dato2 = it.getString("Contraseña").toString()
                dato3 = it.getString("Direccion").toString()
                dato5 = it.getString("Edad").toString()
                dato6 = it.getString("Estado").toString()
                dato7 = it.getString("Nombres").toString()
                dato8 = it.getString("Rol").toString()
                dato9 = it.getString("Telefono").toString()
                dato10 = it.getString("Usuario").toString()

                val txtnombres: EditText = findViewById(R.id.NOMBRE)
                val txtapellidos: EditText = findViewById(R.id.APELLIDO)
                val txtedad: EditText = findViewById(R.id.EDAD)
                val txtdireccion: EditText = findViewById(R.id.DIRECCION)
                val txttelefono: EditText = findViewById(R.id.TELEFONO)
                val txtusaurio: EditText = findViewById(R.id.USUARIO)
                val txtcontraseña: EditText = findViewById(R.id.CONTRASEÑA)
                val txtrol: EditText = findViewById(R.id.ROL)
                val txtestado: EditText = findViewById(R.id.ESTADO)

                txtapellidos.setText(dato1)
                txtcontraseña.setText(dato2)
                txtdireccion.setText(dato3)
                txtedad.setText(dato5)
                txtestado.setText(dato6)
                txtnombres.setText(dato7)
                txtrol.setText(dato8)
                txttelefono.setText(dato9)
                txtusaurio.setText(dato10)
            }
        }

    }
}