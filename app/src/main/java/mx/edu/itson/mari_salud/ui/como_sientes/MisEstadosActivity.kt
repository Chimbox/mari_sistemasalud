package mx.edu.itson.mari_salud.ui.como_sientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_mis_estados.*
import mx.edu.itson.mari_salud.MenuActivity
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Estado


class MisEstadosActivity : AppCompatActivity() {

    var lstEstados = ArrayList<Estado>()
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private var adapter: EditorEstadoLVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_estados)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .get()
            .addOnSuccessListener { it ->
                var lstStringEstadosPersonalizado =
                    it.get("estados_personalizado") as ArrayList<Estado>
                lstEstados = lstStringEstadosPersonalizado
                Toast.makeText(this, lstEstados.toString(), Toast.LENGTH_LONG).show()
                adapter = EditorEstadoLVAdapter(lstEstados, this)
                lvEstados.adapter = adapter
            }

        btnRegresarEstado.setOnClickListener {
            finish()
        }
        btnAgregarEstado.setOnClickListener {
            lstEstados.add(Estado(etEstado.text.toString(), false))
            etEstado.text.clear()
            adapter?.notifyDataSetChanged()
            actualizaEstadosPersonalizado()
        }

    }

    private fun actualizaEstadosPersonalizado() {
        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .update("estados_personalizado", lstEstados)
    }

}