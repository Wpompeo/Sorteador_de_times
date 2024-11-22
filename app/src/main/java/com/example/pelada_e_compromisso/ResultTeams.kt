package com.example.pelada_e_compromisso

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULT_TEAMS = "ResultTeams.KEY_TEAMS"
class ResultTeams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_teams)

        val result = intent.getStringExtra(KEY_RESULT_TEAMS)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult.text = result.toString()



    }
}