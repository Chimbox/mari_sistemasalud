package mx.edu.itson.mari_salud.ui.metas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_editor_metas.*
import kotlinx.android.synthetic.main.activity_editor_metas.btnRegresar
import kotlinx.android.synthetic.main.fragment_metas.lvMetas
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Meta

class ActivityEditorMetas : AppCompatActivity() {

    var lstMetas = ArrayList<Meta>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor_metas)

        var adapter = EditorMetaListViewAdapter(lstMetas, this)
        lvMetas.adapter = adapter
        btnRegresar.setOnClickListener {
            finish()
        }
        btnAgregarMeta.setOnClickListener {
            lstMetas.add(Meta(etMeta.text.toString(),false))
            etMeta.text.clear()
            adapter.notifyDataSetChanged()
        }

        btnRegresar.setOnClickListener {
            onBackPressed()
        }
    }
}