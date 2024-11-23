package com.example.pelada_e_compromisso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class FootballDraw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_football_draw)

        val edtPlayers = findViewById<EditText>(R.id.edt_players)
        edtPlayers.text?.clear()
        val edtKeyPlayers = findViewById<EditText>(R.id.key_head)
        val edtTeams = findViewById<EditText>(R.id.teams)
        val btnSort = findViewById<Button>(R.id.btn_sort)

        btnSort.setOnClickListener {
            val playerStr = edtPlayers.text.toString()
                .split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            val teamCount = edtTeams.text.toString().toIntOrNull() ?: 0
            val keyPlayers = edtKeyPlayers.text.toString()

            if (playerStr.isEmpty() || teamCount <= 0) {
                Snackbar.make(
                    edtTeams,
                    "Preencha todos os campos!",
                    Snackbar.LENGTH_LONG
                ).show()
            } else if (teamCount > playerStr.size) {
                Snackbar.make(
                    edtTeams,
                    "O número de times não pode ser maior que o número de jogadres!",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {
                val result = sortTeams(playerStr, teamCount, keyPlayers)
                val intent = Intent(this, ResultTeams::class.java)
                intent.putExtra(KEY_RESULT_TEAMS, result)
                startActivity(intent)
            }
        }
    }

    private fun sortTeams(playerStr: List<String>, teamCount: Int, keyPlayersStr: String): String {
        val keyPlayers = keyPlayersStr.split(",").map { it.trim() }.filter { it.isNotEmpty() }

        // Verifica se há mais jogadores-chave do que times
        if (keyPlayers.size > teamCount) {
            return "Erro: O número de jogadores-chave é maior que o número de times."
        }

        // Remove os jogadores-chave da lista geral e embaralha
        val remainingPlayers = playerStr.filterNot { keyPlayers.contains(it) }.shuffled()

        // Cria os times e distribui os jogadores-chave
        val teams = Array(teamCount) { mutableListOf<String>() }
        keyPlayers.forEachIndexed { index, keyPlayer ->
            teams[index % teamCount].add(keyPlayer)
        }

        // Distribui os jogadores restantes
        remainingPlayers.forEachIndexed { index, player ->
            teams[index % teamCount].add(player)
        }

        // Formata os resultados
        return teams.mapIndexed { index, team ->
            "Time ${index + 1}: ${team.joinToString(", ")}"
        }.joinToString("\n\n")
    }
}