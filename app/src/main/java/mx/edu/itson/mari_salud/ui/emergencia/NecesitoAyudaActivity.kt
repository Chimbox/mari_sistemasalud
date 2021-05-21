package mx.edu.itson.mari_salud.ui.emergencia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_necesito_ayuda.*
import mx.edu.itson.mari_salud.R

class NecesitoAyudaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_necesito_ayuda)

        btnRegresar_necesitoAyuda.setOnClickListener {
            finish()
        }
    }
}