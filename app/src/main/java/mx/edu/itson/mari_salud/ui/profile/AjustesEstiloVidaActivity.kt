package mx.edu.itson.mari_salud.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ajustes_estilo_vida.*
import mx.edu.itson.mari_salud.R

class AjustesEstiloVidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes_estilo_vida)
        btn_back_estiloVida.setOnClickListener {
            finish()
        }
    }
}