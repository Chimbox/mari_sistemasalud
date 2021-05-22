package mx.edu.itson.mari_salud.ui.emergencia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.emergencia_item.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Emergencia

class EmergenciaListViewAdapter : BaseAdapter {

    var lstEmergencias=ArrayList<Emergencia>()
    var context: Context? = null

    constructor(lstEmergencias: ArrayList<Emergencia>, context: Context?) : super() {
        this.lstEmergencias = lstEmergencias
        this.context = context
    }


    override fun getCount(): Int {
        return lstEmergencias.size
    }

    override fun getItem(p0: Int): Any {
        return lstEmergencias[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var emergencia=lstEmergencias[p0]
        var inflater = LayoutInflater.from(context)
        var vista = inflater.inflate(R.layout.emergencia_item, null)

        vista.btnEmergencia.setText(emergencia.titulo)

        return vista
    }
}