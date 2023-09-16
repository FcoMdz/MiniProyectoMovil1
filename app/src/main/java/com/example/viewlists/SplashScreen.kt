package com.example.viewlists

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viewlists.ui.theme.ViewListsTheme

class SplashScreen : ComponentActivity() {
    private val PREFS_NAME = "rolUsuario"
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val opc = sharedPreferences.getString("rol", null)
        var texto:String;

        when(opc) {
            "Estudiante" -> texto = getString(R.string.bbEstudiante)
            "Obrero" -> texto = getString(R.string.bbObrero)
            "Funcionario" -> texto = getString(R.string.bbFuncionario)
            else -> texto = "Bienvenido"
        }

        setContentView(R.layout.splash_inicio)
        val image = findViewById<ImageView>(R.id.inicioImagen)
        val txt = findViewById<TextView>(R.id.txtInicio)
        image.setImageResource(R.drawable.store_logo)
        txt.text = texto
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ViewListsTheme {
        Greeting("Android")
    }
}