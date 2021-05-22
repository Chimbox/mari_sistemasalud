package mx.edu.itson.mari_salud.ui.metas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.metas_item.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Meta

class MetaListViewAdapter : BaseAdapter {

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
        var vista = inflater.inflate(R.layout.metas_item, null)

        vista.btnMeta.setText(meta.titulo)
        vista.cbxEstado.isChecked=meta.estado

        return vista
    }
}