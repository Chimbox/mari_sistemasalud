package mx.edu.itson.mari_salud.ui.metas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_editor_metas.*
import kotlinx.android.synthetic.main.activity_editor_metas.btnRegresar
import kotlinx.android.synthetic.main.fragment_metas.lvMetas
import kotlinx.android.synthetic.main.fragment_metas.view.*
import mx.edu.itson.mari_salud.MenuActivity
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Meta

class ActivityEditorMetas : AppCompatActivity() {

    var lstMetas = ArrayList<Meta>()
    lateinit var db: FirebaseFirestore
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor_metas)



        db = FirebaseFirestore.getInstance()
        auth = FirebaseAuth.getInstance()

        db.collection("metas")
            .add(
                hashMapOf(
                    "email" to auth.currentUser.email,
                    "metas" to lstMetas
                )
            )


        var adapter = EditorMetaListViewAdapter(lstMetas, this, db, auth)
        lvMetas.adapter = adapter

        db.collection("metas")
            .whereEqualTo("email", auth.currentUser.email)
            .get()
            .addOnSuccessListener {
                it.forEach {
                    
                    (it.get("metas") as ArrayList<DocumentReference>).forEach {
                        db.document(it.path)
                            .get()
                            .addOnSuccessListener {
                                lstMetas.add(
                                    Meta(
                                        it.getString("titulo")!!,
                                        it.getBoolean("estado")!!,
                                        it.id
                                    )
                                )
                                adapter.notifyDataSetChanged()
                            }
                    }

                }
            }

        btnRegresar.setOnClickListener {
            finish()
        }

        btnAgregarMeta.setOnClickListener {
            db.collection("meta")
                .add(
                    hashMapOf(
                        "estado" to false,
                        "titulo" to etMeta.text.toString()
                    )
                ).addOnCompleteListener {
                    lstMetas.add(Meta(etMeta.text.toString(), false, it.result!!.id))
                    var reference = it.result
                    adapter.notifyDataSetChanged()


                    db.collection("metas")
                        .whereEqualTo("email", auth.currentUser.email)
                        .get()
                        .addOnSuccessListener {
                            it.forEach { docMetas ->
                                db.collection("metas")
                                    .document(docMetas.id)
                                    .get()
                                    .addOnSuccessListener {
                                        var lstReferencias =
                                            it.get("metas") as ArrayList<DocumentReference>
                                        lstReferencias.add(reference!!)

                                        db.collection("metas")
                                            .document(docMetas.id)
                                            .update("metas", lstReferencias)
                                    }
                            }



                            etMeta.text.clear()

                        }

                    btnRegresar.setOnClickListener {
                        onBackPressed()
                    }
                }
        }
    }
}