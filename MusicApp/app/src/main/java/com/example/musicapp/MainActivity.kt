package com.example.musicapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonPause = findViewById<ImageButton>(R.id.buttonPause)
        val botonPlay = findViewById<ImageButton>(R.id.botonPlay)

        findViewById<ImageButton>(R.id.botonPlay).setOnClickListener {
            botonPlay.visibility = View.INVISIBLE
            botonPause.visibility = View.VISIBLE
        }

        findViewById<ImageButton>(R.id.buttonPause).setOnClickListener {
            botonPlay.visibility = View.VISIBLE
            botonPause.visibility = View.INVISIBLE
        }

    }
}