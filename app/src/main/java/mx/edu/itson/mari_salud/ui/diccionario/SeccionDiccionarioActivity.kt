package mx.edu.itson.mari_salud.ui.diccionario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_seccion_diccionario.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Diccionario
import mx.edu.itson.mari_salud.ui.dominio.SeccionDiccionario

class SeccionDiccionarioActivity : AppCompatActivity() {
    var lstSeccionesDiccionario=ArrayList<SeccionDiccionario>()
    private var guardarbtn:Boolean = false;

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

        btnGuardar.setOnClickListener {
            if (guardarbtn==false) {
                btnGuardar.setImageResource(R.mipmap.favorito2_48x48_mdpi)
                guardarbtn=true
            }else{
                btnGuardar.setImageResource(R.mipmap.favorito_48x48_mdpi)
                guardarbtn=false
            }
        }
    }
}