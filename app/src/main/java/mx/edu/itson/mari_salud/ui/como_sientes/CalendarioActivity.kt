package mx.edu.itson.mari_salud.ui.como_sientes

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calendario.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.metas.ActivityEditorMetas

class CalendarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        var clickListener=View.OnClickListener {
            abreMeSientoActivity()
        }

        btnEstadoAnimo.setOnClickListener(clickListener)
        btnSintomas.setOnClickListener(clickListener)

        btnMetas.setOnClickListener {

        }
    }

    private fun abreMeSientoActivity(){
        var intent= Intent(this,MeSientoActivity::class.java)
        startActivity(intent)
    }

    private fun abreMetasActivity(){
        var intent=Intent(this, ActivityEditorMetas::class.java)
        startActivity(intent)
    }

}