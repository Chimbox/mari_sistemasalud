package mx.edu.itson.mari_salud.ui.diccionario

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.seccion_diccionario_item.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.SeccionDiccionario

class SeccionDiccionarioListViewAdapter : BaseAdapter {
    var lstSecciones=ArrayList<SeccionDiccionario>()
    var context: Context? = null

    constructor(lstSecciones: ArrayList<SeccionDiccionario>, context: Context?) {
        this.lstSecciones = lstSecciones
        this.context = context
    }


    override fun getCount(): Int {
        return lstSecciones.size
    }

    override fun getItem(p0: Int): Any {
        return lstSecciones[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var seccion=lstSecciones[p0]
        var inflater = LayoutInflater.from(context)
        var vista = inflater.inflate(R.layout.seccion_diccionario_item, null)

        vista.tvTituloSeccion.text=seccion.titulo
        vista.tvContenidoSeccion.text=seccion.contenido

        return vista
    }
}