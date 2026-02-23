package com.example.logcatactivity

import android.os.Bundle
import android.util.Log // Importação necessária para o Logcat
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.logcatactivity.ui.theme.LogcatActivityTheme

class MainActivity : ComponentActivity() {

    // A TAG ajuda a filtrar os logs no Logcat
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "→ onCreate: App iniciado")

        enableEdgeToEdge()
        setContent {
            LogcatActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Criamos um estado para os cliques (similar ao var cliques no exercício)
                    var cliques by remember { mutableStateOf(0) }

                    Column(modifier = Modifier.padding(innerPadding).padding(16.dp)) {
                        Text(text = "Cliques: $cliques")

                        Button(onClick = {
                            cliques++
                            Log.i(TAG, "→ Botão clicado! Total: $cliques")
                        }) {
                            Text("Mudar")
                        }
                    }
                }
            }
        }
    }

    // Adicionando os métodos do ciclo de vida para o exercício
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "→ onStart: Tela visível")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "→ onResume: App em foco")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "→ onPause: Perdeu foco")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "→ onStop: App parou (background)")
    }
}