package com.example.pelada_e_compromisso

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class FootballDraw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_football_draw)

        val edtPlayers = findViewById<TextView>(R.id.edt_players)
        val edtKeyPlayers = findViewById<TextView>(R.id.key_head)
        val edtTeams =findViewById<TextView>(R.id.teams)
        val btnSort = findViewById<Button>(R.id.btn_sort)

        btnSort.setOnClickListener{
            val playerStr: String = edtPlayers.text.toString()
            val keyPlayersStr: String = edtKeyPlayers.text.toString()
            val teamsStr: String = edtTeams.text.toString()

            if ( playerStr == "" || keyPlayersStr == "" || teamsStr == "" ) {
                Snackbar.make(
                    edtPlayers,
                    "Preencha todos os campos!",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {
                val player = playerStr.toFloat()
                val keyPlayer = keyPlayersStr.toFloat()
                val team = teamsStr.toFloat()
            }

        }
    }
}