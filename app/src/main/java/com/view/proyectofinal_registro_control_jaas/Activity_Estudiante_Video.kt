package com.view.proyectofinal_registro_control_jaas

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

/*
* Autor: Andres Silva y Julian Alba
* Fecha: 15/05/2023
* Comentarios: Desarrollo de proyecto para la asignatura de plataformas.
* */

class Activity_Estudiante_Video : AppCompatActivity() {

    private lateinit var videoView: VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudiante_video)

        videoView = findViewById(R.id.videoView)
        // Ruta del archivo de video en la carpeta res/raw
        val videoPath = "android.resource://" + packageName + "/" + R.raw.prueba

        val videoUri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)

        // Iniciar la reproducción del video
        videoView.start()
    }
}