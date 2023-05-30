package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
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


        val botonConsultarAdministrativo: Button = findViewById(R.id.consultarAdministrativos)

        val botonActualizarAdministrativo: Button = findViewById(R.id.actualizarAdministrativos)

        val botonIrAtras: Button = findViewById(R.id.ATRASAD)

        botonIrAtras.setOnClickListener {
            val intent = Intent(this, Fragment_Admin_M_A::class.java)
            startActivity(intent)
        }



        botonActualizarAdministrativo.setOnClickListener {
            actualizarAdministrativo()
        }

        botonConsultarAdministrativo.setOnClickListener {
            consultarEstudiante()
        }
    }

    private fun actualizarAdministrativo() {

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
        val txtcargo: EditText = findViewById(R.id.cargo)
        val txtfacultad: EditText = findViewById(R.id.facultad)
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
        var estado: String = txtestado.text.toString()
        var cargo: String = txtcargo.text.toString()
        var facultad: String = txtfacultad.text.toString()
        var experiencia: String = txtexperiencia.text.toString()
        var universidad: String = txtuniversidad.text.toString()

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
            "Estado" to estado,
            "Cargo" to cargo,
            "Facultad" to facultad,
            "Experiencia" to experiencia,
            "Universidad" to universidad
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
                txtcargo.text.clear()
                txtfacultad.text.clear()
                txtexperiencia.text.clear()
                txtuniversidad.text.clear()


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
        var dato11: String
        var dato12: String
        var dato13: String
        var dato14: String


        consultaUsuarios.document(documento).get().addOnSuccessListener {
            println("Esta consultando el estudiante...")

            if (it.exists()) {


                dato1 = it.getString("Apellidos").toString()
                dato2 = it.getString("Cargo").toString()
                dato3 = it.getString("Contraseña").toString()
                dato4 = it.getString("Direccion").toString()
                dato5 = it.getString("Edad").toString()
                dato6 = it.getString("Estado").toString()
                dato7 = it.getString("Experiencia").toString()
                dato8 = it.getString("Facultad").toString()
                dato9 = it.getString("Nombres").toString()
                dato10 = it.getString("Rol").toString()
                dato11= it.getString("Telefono").toString()
                dato12 = it.getString("Universidad").toString()
                dato13= it.getString("Usuario").toString()


                val txtnombres: EditText = findViewById(R.id.NOMBRE)
                val txtapellidos: EditText = findViewById(R.id.APELLIDO)
                val txtedad: EditText = findViewById(R.id.EDAD)
                val txtdireccion: EditText = findViewById(R.id.DIRECCION)
                val txttelefono: EditText = findViewById(R.id.TELEFONO)
                val txtusaurio: EditText = findViewById(R.id.USUARIO)
                val txtcontraseña: EditText = findViewById(R.id.CONTRASEÑA)
                val txtrol: EditText = findViewById(R.id.ROL)
                val txtestado: EditText = findViewById(R.id.ESTADO)
                val txtcargo: EditText = findViewById(R.id.cargo)
                val txtfacultad: EditText = findViewById(R.id.facultad)
                val txtexperiencia: EditText = findViewById(R.id.EXPERIENCIA)
                val txtuniversidad: EditText = findViewById(R.id.UNIVERSIDAD)

                txtapellidos.setText(dato1)
                txtcargo.setText(dato2)
                txtcontraseña.setText(dato3)
                txtdireccion.setText(dato4)
                txtedad.setText(dato5)
                txtestado.setText(dato6)
                txtexperiencia.setText(dato7)
                txtfacultad.setText(dato8)
                txtnombres.setText(dato9)
                txtrol.setText(dato10)
                txttelefono.setText(dato11)
                txtuniversidad.setText(dato12)
                txtusaurio.setText(dato13)
            }
        }

    }
}