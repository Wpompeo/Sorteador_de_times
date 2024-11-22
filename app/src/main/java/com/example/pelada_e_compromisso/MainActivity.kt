package com.example.pelada_e_compromisso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnInit = findViewById<Button>(R.id.btn_init)
        btnInit.setOnClickListener {
            val intent = Intent(this, FootballDraw::class.java)
            startActivity(intent)
        }
    }
}