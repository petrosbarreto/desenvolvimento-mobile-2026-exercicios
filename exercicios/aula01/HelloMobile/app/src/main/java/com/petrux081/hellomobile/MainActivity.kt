package com.petrux081.hellomobile

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
// Imports necessários...

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Conectando com XML
        setContentView(R.layout.activity_main)
        Log.d(TAG, "-- OnCreate : O App foi aberto")

        //Pegando referencias do XML para identificar IDs


        val corDeFundo: LinearLayout = findViewById(R.id.rootLayout)
        val botaoMudarCor: Button = findViewById(R.id.mudarCorBtn)

        // Array com cores
        val colors = arrayOf(
            Color.parseColor("#F8B3CA"), //Cor: Rosa Pastel
            Color.parseColor("#FFDBBB"), //Cor:  Pessego
            Color.parseColor("#C1D4E3") // Cor: Azul Pastel

        )

        //Indice usado para identificar cores no array posteriormente
        var cor = 0

        // Ao ser clicado o botao executa essa função abaixo, graças ao setOnClickListener
        botaoMudarCor.setOnClickListener {
            Log.i(TAG, "Botão foi clicado")

            // No indice cor é atribuído mais um, que serve para identificar a cor no array para
            // ser inserido no LinearLayout usando o setBackgroundColor
            cor = (cor + 1) % colors.size
            corDeFundo.setBackgroundColor(colors[cor])
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "-- onStart: A tela está visivel")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "-- onResume: O aplicativo entrou em foco")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "-- onPause : O aplicativo saiu de foco")
    }

}