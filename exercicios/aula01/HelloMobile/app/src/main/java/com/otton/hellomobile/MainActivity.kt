package com.otton.hellomobile

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TagLogMain", "-> onCreate: App iniciado!")
        setContentView(R.layout.activity_main)

        // Referências aos componentes
        val tvMensagem: TextView = findViewById(R.id.tvMensagem)
        val btnMudarCor: Button = findViewById(R.id.btnMudarCor)

        Log.d("TagLogMain", "Views encontradas com sucesso!")

        // Array de cores
        val cores = arrayOf(
            "#FFFFFF".toColorInt(),
            "#E3F2FD".toColorInt(),
            "#FFF9C4".toColorInt(),
            "#F1F8E9".toColorInt(),
            "#FCE4EC".toColorInt()
        )

        val imgFoto: ImageView = findViewById(R.id.imgFoto)

        // Array de imagens
        val imagens = arrayOf(
            R.drawable.foto1,
            R.drawable.foto2,
            R.drawable.foto3,
            R.drawable.foto4,
            R.drawable.foto5
        )

        // indíces dos arrays e variável cliques
        var indice = 0
        var indiceFoto = 0
        var cliques = 0

        // botão para acionar evento quando clicado
        btnMudarCor.setOnClickListener {
            Log.d("TagLogMain", "Botão clicado!")
            cliques++

            tvMensagem.text = "Você clicou $cliques vez(es)"

            // fazer a foto visível na tela
            if (cliques >= 2) {
                imgFoto.visibility = View.VISIBLE
            }

            indice = (indice + 1) % cores.size
            findViewById<LinearLayout>(R.id.rootLayout)
                .setBackgroundColor(cores[indice])

            // A cada 50 cliques a foto muda
            if(cliques % 50 == 0)
            {
                indiceFoto = (indiceFoto + 1) % imagens.size
                imgFoto.setImageResource(imagens[indiceFoto])
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TagLogMain", "-> onStart: Tela visível")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TagLogMain", "-> onResume: App em foco")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TagLogMain", "-> onPause: Perdeu foco")
    }
}