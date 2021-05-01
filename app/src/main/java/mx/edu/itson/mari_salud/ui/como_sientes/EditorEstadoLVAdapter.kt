package mx.edu.itson.mari_salud.ui.como_sientes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.editor_metas_item.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.metas.Meta

class EditorEstadoLVAdapter : BaseAdapter {

    var lstEstados = ArrayList<Estado>()
    var context: Context? = null

    constructor(lstEstados: ArrayList<Estado>, context: Context?) : super() {
        this.lstEstados = lstEstados
        this.context = context
    }

    override fun getCount(): Int {
        return lstEstados.size
    }

    override fun getItem(position: Int): Any {
        return lstEstados[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var estado = lstEstados[position]
        var inflater = LayoutInflater.from(context)
        var vista = inflater.inflate(R.layout.editor_metas_item, null)

        vista.tvMeta.text = estado.titulo
        vista.etMeta.setText(estado.titulo)

        vista.btnEditarMeta.setOnClickListener {
            Toast.makeText(context, "Editando estado...", Toast.LENGTH_SHORT).show()
            vista.lytOpcionesMeta.visibility = View.GONE
            vista.lytGuardar.visibility = View.VISIBLE
            vista.tvMeta.visibility = View.GONE
        }
        vista.btnDuplicar.setOnClickListener {
            Toast.makeText(context, "Duplicando estado...", Toast.LENGTH_SHORT).show()
            lstEstados.add(estado.copy())
            notifyDataSetChanged()
        }
        vista.btnBorrar.setOnClickListener {
            Toast.makeText(context, "Borrando estado...", Toast.LENGTH_SHORT).show()
            lstEstados.removeAt(position)
            notifyDataSetChanged()
        }

        vista.btnGuardar.setOnClickListener {
            Toast.makeText(context, "Guardando estado...", Toast.LENGTH_SHORT).show()
            estado.titulo = vista.etMeta.text.toString()
            vista.tvMeta.visibility = View.VISIBLE
            vista.lytGuardar.visibility = View.GONE
            lstEstados[position] = estado
            notifyDataSetChanged()
        }

        vista.tvMeta.setOnClickListener {
            if (vista.lytOpcionesMeta.visibility == View.VISIBLE) {
                vista.lytGuardar.visibility = View.GONE
                vista.lytOpcionesMeta.visibility = View.GONE
            } else if (vista.lytGuardar.visibility == View.GONE) {
                vista.lytOpcionesMeta.visibility = View.VISIBLE
            }
        }

        return vista
    }


}