package mx.edu.itson.mari_salud.ui.como_sientes

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_me_siento.*
import kotlinx.android.synthetic.main.activity_mis_estados.*
import mx.edu.itson.mari_salud.R
import java.time.LocalDateTime

class MeSientoActivity : AppCompatActivity() {
    var lstEstados = ArrayList<Estado>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me_siento)
        val current = LocalDateTime.now()

        btn_back_hoySiento.setOnClickListener {
            finish()
        }

        tv_fecha_hoySiento.text = current.dayOfMonth.toString() + " de " + current.month.toString()

        lstEstados.add(Estado("Estado 1", false))
        lstEstados.add(Estado("Estado 2", false))
        lstEstados.add(Estado("Estado 3", false))
        var adapter = EditorEstadoLVAdapter(lstEstados, this)
        lv_estados.adapter = adapter

        lytAniadirEstado.setOnClickListener {
            var intent = Intent(this, MisEstadosActivity::class.java)
            startActivity(intent)
        }

    }
}