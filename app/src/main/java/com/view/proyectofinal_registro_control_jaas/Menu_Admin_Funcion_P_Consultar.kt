package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import com.google.firebase.firestore.FirebaseFirestore
/*
* Autor: Andres Silva y Julian Alba
* Fecha: 27/04/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class Menu_Admin_Funcion_P_Consultar : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private val consultaUsuarios = db.collection("usuarios")
    private val actualizarUsuarios = db.collection("usuarios")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_admin_funcion_p_consultar)

        val botonConsultarDocente: Button = findViewById(R.id.consultarDocente)

        val botonActualizarDocente: Button = findViewById(R.id.actualizarDocente)


        val botonIrAtras: Button = findViewById(R.id.ATRASDO)

        botonIrAtras.setOnClickListener {
            val intent = Intent(this, Menu_Admin::class.java)
            startActivity(intent)
        }

        botonActualizarDocente.setOnClickListener {
            actualizarDocente()
        }

        botonConsultarDocente.setOnClickListener {
            consultarDocente()
        }
    }

    private fun actualizarDocente() {

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
        val txtmateria:EditText = findViewById(R.id.MATERIA)
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
        var materia: String = txtmateria.text.toString()
        var experiencia: String = txtexperiencia.text.toString()
        var universidad: String = txtuniversidad.text.toString()


        if(documento.isNotEmpty()
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
            && documento.matches(Regex("[0-9]*"))){

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
                "Materia" to materia,
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
                    txtexperiencia.text.clear()
                    txtuniversidad.text.clear()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "No se pudo actualizar los datos", Toast.LENGTH_SHORT).show()
                }

        }else {
            Toast.makeText(this, "Campos requeridos", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Documento tiene que ser numerico", Toast.LENGTH_SHORT).show()
        }
    }

    private fun consultarDocente() {

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

        if(documento.isNotEmpty() && documento.matches(Regex("[0-9]*"))){

            consultaUsuarios.document(documento).get().addOnSuccessListener {
                println("Esta consultando el estudiante...")

                if (it.exists()) {


                    dato1 = it.getString("Apellidos").toString()
                    dato2 = it.getString("Contraseña").toString()
                    dato3 = it.getString("Direccion").toString()
                    dato4 = it.getString("Edad").toString()
                    dato5 = it.getString("Estado").toString()
                    dato6 = it.getString("Experiencia").toString()
                    dato7 = it.getString("Materia").toString()
                    dato8 = it.getString("Nombres").toString()
                    dato9 = it.getString("Rol").toString()
                    dato10 = it.getString("Telefono").toString()
                    dato11 = it.getString("Universidad").toString()
                    dato12 = it.getString("Usuario").toString()

                    val txtnombres: EditText = findViewById(R.id.NOMBRE)
                    val txtapellidos: EditText = findViewById(R.id.APELLIDO)
                    val txtedad: EditText = findViewById(R.id.EDAD)
                    val txtdireccion: EditText = findViewById(R.id.DIRECCION)
                    val txttelefono: EditText = findViewById(R.id.TELEFONO)
                    val txtusaurio: EditText = findViewById(R.id.USUARIO)
                    val txtcontraseña: EditText = findViewById(R.id.CONTRASEÑA)
                    val txtrol: EditText = findViewById(R.id.ROL)
                    val txtestado: EditText = findViewById(R.id.ESTADO)
                    val txtmateria:EditText = findViewById(R.id.MATERIA)
                    val txtexperiencia: EditText = findViewById(R.id.EXPERIENCIA)
                    val txtuniversidad: EditText = findViewById(R.id.UNIVERSIDAD)

                    txtapellidos.setText(dato1)
                    txtcontraseña.setText(dato2)
                    txtdireccion.setText(dato3)
                    txtedad.setText(dato4)
                    txtestado.setText(dato5)
                    txtexperiencia.setText(dato6)
                    txtmateria.setText(dato7)
                    txtnombres.setText(dato8)
                    txtrol.setText(dato9)
                    txttelefono.setText(dato10)
                    txtuniversidad.setText(dato11)
                    txtusaurio.setText(dato12)
                }else{
                    Toast.makeText(this, "Documento $documento no registrado", Toast.LENGTH_SHORT).show()
                }
            }
        }else{
            Toast.makeText(this, "Campo de cedula requerido", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Documento tiene que ser numerico", Toast.LENGTH_SHORT).show()
        }
    }
}