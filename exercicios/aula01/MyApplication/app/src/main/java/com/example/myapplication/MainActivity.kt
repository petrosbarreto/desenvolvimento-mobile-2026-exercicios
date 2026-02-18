package com.petrosbarreto.hellomobile

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
//para teste
    // Variável para controle do índice da cor
    private var indiceAtual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Conecta o XML (Layout) a esta Activity
        setContentView(R.layout.activity_main)

        // Definição das Cores Suaves (Pastel)
        val cores = arrayOf(
            Color.parseColor("#E3F2FD"), // Azul
            Color.parseColor("#FFF3E0"), // Laranja
            Color.parseColor("#F3E5F5"), // Roxo
            Color.parseColor("#E8F5E9"), // Verde
            Color.parseColor("#FFEBEE")  // Vermelho
        )

        // Referências aos componentes da tela
        val rootLayout = findViewById<LinearLayout>(R.id.rootLayout)
        val btnMudarCor = findViewById<Button>(R.id.btnMudarCor)

        // Ação do Botão
        btnMudarCor.setOnClickListener {
            // Define a cor de fundo baseada no índice atual
            rootLayout.setBackgroundColor(cores[indiceAtual])

            // Avança para a próxima cor (ciclamente usando o operador %)
            indiceAtual = (indiceAtual + 1) % cores.size
        }
    }
}