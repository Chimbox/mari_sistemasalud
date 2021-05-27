package mx.edu.itson.mari_salud.ui.metas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_metas.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Meta

class MetasFragment : Fragment() {

    var lstMetas=ArrayList<Meta>()
    private lateinit var dashboardViewModel: MetasViewModel
    lateinit var db:FirebaseFirestore
    lateinit var auth:FirebaseAuth
    lateinit var root:View
    lateinit var adapter:MetaListViewAdapter
    var primeraVez=true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(MetasViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_metas, container, false)
        this.root=root
        db= FirebaseFirestore.getInstance()
        auth= FirebaseAuth.getInstance()

        var adapter=MetaListViewAdapter(lstMetas, context, db)
        this.adapter=adapter
        root.lvMetas.adapter=adapter

        actualizarMetas()
        //it.get("estados_personalizado") as ArrayList<Map<Object, Object>>


        root.lytAniadirMeta.setOnClickListener {
            var intent = Intent(context,ActivityEditorMetas::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onResume() {
        super.onResume()
        if(!primeraVez) {
            actualizarMetas()
        }
    }

    private fun actualizarMetas() {
        lstMetas.clear()
        db.collection("metas")
            .whereEqualTo("email", auth.currentUser.email)
            .get()
            .addOnSuccessListener {
                it.forEach {
                    root.etNota.setText(it.getString("notas"))

                    (it.get("metas") as ArrayList<DocumentReference>).forEach {
                        db.document(it.path)
                            .get()
                            .addOnSuccessListener {
                                lstMetas.add(Meta(it.getString("titulo")!!, it.getBoolean("estado")!!, it.id))
                                adapter.notifyDataSetChanged()
                            }
                        primeraVez=false
                    }


                }

            }
    }
}