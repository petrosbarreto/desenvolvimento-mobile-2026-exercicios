package com.aula2.bem_vindo

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.d(TAG, "-> onCreate: App iniciado")

        val btnMudar: Button = findViewById(R.id.btnMudar)
        Log.d(TAG, "-> Views encontradas com sucesso")

        // Lista de cores
        val cores = arrayOf(
            Color.parseColor("#FFFFFF"), // Branco
            Color.parseColor("#F5F5DC"),// Bege
            Color.parseColor("#baf8ff"), // Azul Pastel
            Color.parseColor("#bacdff") // Roxo Pastel

        )

        var indice = 0

        btnMudar.setOnClickListener {
            indice = (indice + 1 ) % cores.size
            val corAtual = cores[indice]
            findViewById<LinearLayout>(R.id.main).setBackgroundColor(corAtual)

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "-> onStart: Tela Visivel")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "-> onResume: App em Foco")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "-> onPause: Perdeu foco")
    }
}
