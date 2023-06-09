package com.view.proyectofinal_registro_control_jaas

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast

/*
* Autor: Andres Silva y Julian Alba
* Fecha: 22/04/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class MainActivity : AppCompatActivity() {

    private val tiempo: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val sc = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val redInfo = sc.allNetworkInfo
            var isConnected = false
            for (ir in redInfo) {
                if (ir.isConnected) {
                    if (ir.typeName.equals("WIFI", ignoreCase = true)) {
                        if (ir.isConnected) {
                            runOnUiThread {
                                Toast.makeText(this, "conectado con wifi", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                    if (ir.typeName.equals("MOBILE", ignoreCase = true)) {
                        if (ir.isConnected) {
                            runOnUiThread {
                                Toast.makeText(this, "conectado con datos moviles", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                    isConnected = true
                    break
                }
            }
            if (isConnected) {

                val intent = Intent(this, Menu_Login::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "NO HAY CONEXION A UNA RED DISPONIBLE", Toast.LENGTH_SHORT).show()
            }
        }, tiempo)
    }
}