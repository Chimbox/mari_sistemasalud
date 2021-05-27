package mx.edu.itson.mari_salud.ui.como_sientes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.metas_item.view.*
import mx.edu.itson.mari_salud.MenuActivity
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Estado

class EstadoPersonalizdoListViewAdapter : BaseAdapter {

    var lstEstados = ArrayList<Estado>()
    var context: Context? = null
    val db: FirebaseFirestore

    constructor(lstEstados: ArrayList<Estado>, context: Context?, db: FirebaseFirestore) : super() {
        this.lstEstados = lstEstados
        this.context = context
        this.db = db
    }


    override fun getCount(): Int {
        return lstEstados.size
    }

    override fun getItem(p0: Int): Any {
        return lstEstados[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var est = lstEstados[p0]
        var inflater = LayoutInflater.from(context)
        var vista = inflater.inflate(R.layout.metas_item, null)

        vista.btnMeta.setText(est.titulo)
        vista.cbxEstado.isChecked = est.estado

        vista.cbxEstado.setOnCheckedChangeListener { compoundButton, b ->
            est.estado=b

            lstEstados[p0]=est

            db.collection("perfil")
                .document(MenuActivity.idDocumentoPerfil)
                .update("estados_personalizado", lstEstados)
        }

        return vista
    }
}