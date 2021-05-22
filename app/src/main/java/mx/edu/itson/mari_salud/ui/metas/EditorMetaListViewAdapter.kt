package mx.edu.itson.mari_salud.ui.metas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.editor_metas_item.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Meta

class EditorMetaListViewAdapter : BaseAdapter {

    var lstMetas=ArrayList<Meta>()
    var context: Context? = null

    constructor(lstMetas: ArrayList<Meta>, context: Context?) : super() {
        this.lstMetas = lstMetas
        this.context = context
    }

    override fun getCount(): Int {
        return lstMetas.size
    }

    override fun getItem(p0: Int): Any {
        return lstMetas[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var meta=lstMetas[p0]
        var inflater = LayoutInflater.from(context)
        var vista = inflater.inflate(R.layout.editor_metas_item, null)

        vista.tvMeta.text=meta.titulo
        vista.etMeta.setText(meta.titulo)

        vista.btnEditarMeta.setOnClickListener {
            Toast.makeText(context, "Editando meta...", Toast.LENGTH_SHORT).show()
            vista.lytOpcionesMeta.visibility = GONE
            vista.lytGuardar.visibility = VISIBLE
            vista.tvMeta.visibility=GONE
        }
        vista.btnDuplicar.setOnClickListener {
            Toast.makeText(context, "Duplicando meta...", Toast.LENGTH_SHORT).show()
            lstMetas.add(meta.copy())
            notifyDataSetChanged()
        }
        vista.btnBorrar.setOnClickListener {
            Toast.makeText(context, "Borrando meta...", Toast.LENGTH_SHORT).show()
            lstMetas.removeAt(p0)
            notifyDataSetChanged()
        }

        vista.btnGuardar.setOnClickListener {
            Toast.makeText(context, "Guardando meta...", Toast.LENGTH_SHORT).show()
            meta.titulo=vista.etMeta.text.toString()

            vista.tvMeta.visibility=VISIBLE
            vista.lytGuardar.visibility=GONE

            lstMetas[p0]=meta
            notifyDataSetChanged()
        }

        vista.tvMeta.setOnClickListener {
            if(vista.lytOpcionesMeta.visibility==VISIBLE){
                vista.lytGuardar.visibility=GONE
                vista.lytOpcionesMeta.visibility=GONE
            }else if(vista.lytGuardar.visibility==GONE){
                vista.lytOpcionesMeta.visibility=VISIBLE
            }
        }
        return vista
    }
}