package mx.edu.itson.mari_salud.ui.diccionario

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.diccionario_item.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Diccionario

class DiccionarioListViewAdapter : BaseAdapter {
    var lstDiccionarios=ArrayList<Diccionario>()
    var context: Context? = null

    constructor(lstDiccionarios: ArrayList<Diccionario>, context: Context?) {
        this.lstDiccionarios = lstDiccionarios
        this.context = context
    }


    override fun getCount(): Int {
        return lstDiccionarios.size
    }

    override fun getItem(p0: Int): Any {
        return lstDiccionarios[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var diccionario=lstDiccionarios[p0]
        var inflater = LayoutInflater.from(context)
        var vista = inflater.inflate(R.layout.diccionario_item, null)

        vista.tvTituloDiccionario.setText(diccionario.titulo)

        return vista
    }
}