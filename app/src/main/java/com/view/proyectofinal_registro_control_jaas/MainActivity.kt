package com.view.proyectofinal_registro_control_jaas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class MainActivity : AppCompatActivity() {

    private val tiempo: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            // Este método se ejecutará después del tiempo de duración y realizará las operaciones después de la pantalla de carga.
            val intent = Intent(this, Menu_Login::class.java)
            startActivity(intent)
            finish()
        }, tiempo)
    }
}