package com.exemplo.hellomobile

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Array de cores
        val cores = arrayOf(
            Color.parseColor("#FFFFFF"), // Branco
            Color.parseColor("#E3F2FD"), // Azul claro
            Color.parseColor("#FFF9C4")  // Amarelo claro
        )
        
        var indice = 0
        
        // Pegar referências
        val rootLayout: LinearLayout = findViewById(R.id.rootLayout)
        val btnMudarCor: Button = findViewById(R.id.btnMudarCor)
        
        // Listener do botão
        btnMudarCor.setOnClickListener {
            indice = (indice + 1) % cores.size
            rootLayout.setBackgroundColor(cores[indice])
        }
    }
}
