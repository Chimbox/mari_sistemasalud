package mx.edu.itson.mari_salud.ui.metas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.editor_metas_item.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Meta

class EditorMetaListViewAdapter : BaseAdapter {

    var lstMetas=ArrayList<Meta>()
    var context: Context? = null
    val db:FirebaseFirestore
    val auth:FirebaseAuth

    constructor(lstMetas: ArrayList<Meta>, context: Context?, db:FirebaseFirestore, auth:FirebaseAuth) : super() {
        this.lstMetas = lstMetas
        this.context = context
        this.db=db
        this.auth=auth
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

            var metaCopia=meta.copy()

            db.collection("meta")
                .add(hashMapOf(
                    "estado" to false,
                    "titulo" to metaCopia.titulo
                )).addOnCompleteListener {
                    metaCopia.idDocumento=it.result!!.id
                    var reference=it.result
                    lstMetas.add(metaCopia)
                    notifyDataSetChanged()

                    db.collection("metas")
                        .whereEqualTo("email",auth.currentUser.email)
                        .get()
                        .addOnSuccessListener {
                            it.forEach { docMetas->
                                db.collection("metas")
                                    .document(docMetas.id)
                                    .get()
                                    .addOnSuccessListener {
                                        var lstReferencias=it.get("metas") as ArrayList<DocumentReference>
                                        lstReferencias.add(reference!!)

                                        db.collection("metas")
                                            .document(docMetas.id)
                                            .update("metas", lstReferencias)
                                    }
                            }
                        }
                }





        }
        vista.btnBorrar.setOnClickListener {
            Toast.makeText(context, "Borrando meta...", Toast.LENGTH_SHORT).show()
            lstMetas.removeAt(p0)
            notifyDataSetChanged()

            db.collection("meta")
                .document(meta.idDocumento)
                .delete()
        }

        vista.btnGuardar.setOnClickListener {
            Toast.makeText(context, "Guardando meta...", Toast.LENGTH_SHORT).show()
            meta.titulo=vista.etMeta.text.toString()

            vista.tvMeta.visibility=VISIBLE
            vista.lytGuardar.visibility=GONE

            lstMetas[p0]=meta
            notifyDataSetChanged()

            db.collection("meta")
                .document(meta.idDocumento)
                .update("titulo", meta.titulo)
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