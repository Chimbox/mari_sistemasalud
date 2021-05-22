package mx.edu.itson.mari_salud.ui.como_sientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mis_estados.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Estado


class MisEstadosActivity : AppCompatActivity() {

    var lstEstados = ArrayList<Estado>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_estados)
        lstEstados.add(Estado("EstadoAnimo 1", false))
        lstEstados.add(Estado("EstadoAnimo 2", false))
        lstEstados.add(Estado("EstadoAnimo 3", false))
        var adapter = EditorEstadoLVAdapter(lstEstados, this)
        lvEstados.adapter = adapter


        btnRegresarEstado.setOnClickListener {
            finish()
        }
        btnAgregarEstado.setOnClickListener {
            lstEstados.add(Estado(etEstado.text.toString(), false))
            etEstado.text.clear()
            adapter.notifyDataSetChanged()
        }
    }
}