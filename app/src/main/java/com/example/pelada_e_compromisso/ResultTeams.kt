package com.example.pelada_e_compromisso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

const val KEY_RESULT_TEAMS = "ResultTeams.KEY_TEAMS"
class ResultTeams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_teams)

        val result = intent.getStringExtra(KEY_RESULT_TEAMS)
        val btnResort = findViewById<Button>(R.id.btn_resort)
        val btnFinish = findViewById<Button>(R.id.btn_finish)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult.text = result.toString()

        btnResort.setOnClickListener{
            val intent = Intent(this, FootballDraw::class.java)
            startActivity(intent)
        }

        btnFinish.setOnClickListener{
            Snackbar.make(btnFinish, "Finalizando o aplicativo...", Snackbar.LENGTH_SHORT).show()
            btnFinish.postDelayed({
                finishAffinity()
            }, 2000)
        }
    }
}