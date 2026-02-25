package com.Vitor_Moura48.hellomobile

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.util.Log
import android.graphics.Color

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("main", "onCreate: App Iniciado")

        enableEdgeToEdge()

        // define o layout que será exibido
        setContentView(R.layout.activity_main)

        val tvMensasem: TextView = findViewById(R.id.tvMensagem)
        val btnMudar: Button = findViewById(R.id.btnMudar)
        Log.i("main", "views encontradas com sucesso")

        // Contador de Cliques
        var cliques = 0

        // acionado ao clicar no botão
        btnMudar.setOnClickListener {
            Log.i("main", "botão clicado")

            // altera o ganho de cliques de acordo com a quantidade acumulada
            if (cliques < 100){
                cliques++
            }
            else if (cliques < 300){
                cliques += 2
            }
            else if (cliques < 700){
                cliques += 4
            }
            else if (cliques < 3000){
                cliques += 7
            }
            else if (cliques < 10000){
                cliques += 11
            }
            else {
                cliques += 23
            }

            // define a cor que será exibida, com base na quantidade de cliques
            val hue = (cliques % 360).toFloat()
            val corArcoIris = Color.HSVToColor(floatArrayOf(hue, 1f, 1f))

            // muda a cor do plano de fundo
            findViewById<LinearLayout>(R.id.rootLayout).setBackgroundColor(corArcoIris)

            // exibe quantos pontos de clique já foram feitos
            tvMensasem.text = "Pontos de clique: $cliques"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // criando logs para os callbacks
    override fun onStart() {
        super.onStart()
        Log.i("main", "onStart: Tela visível")
    }

    override fun onResume() {
        super.onResume()
        Log.i("main", "onResume: App em foco")
    }

    override fun onPause() {
        super.onPause()
        Log.i("main", "onPause: Perdeu foco")
    }
}