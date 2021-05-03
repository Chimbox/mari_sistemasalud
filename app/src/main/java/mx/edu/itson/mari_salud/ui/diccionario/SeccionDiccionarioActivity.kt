package mx.edu.itson.mari_salud.ui.diccionario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_seccion_diccionario.*
import mx.edu.itson.mari_salud.R

class SeccionDiccionarioActivity : AppCompatActivity() {
    var lstSeccionesDiccionario=ArrayList<SeccionDiccionario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seccion_diccionario)

        var bundle=intent.extras

        if(bundle!=null){
            var diccionario=bundle.getParcelable<Diccionario>("diccionario")

            tvTituloDiccionario.setText(diccionario!!.titulo)

            lstSeccionesDiccionario=diccionario!!.secciones

            var adapter=SeccionDiccionarioListViewAdapter(lstSeccionesDiccionario, this)

            lvSecciones.adapter=adapter
        }

        btnRegresar.setOnClickListener {
            onBackPressed()
        }
    }
}