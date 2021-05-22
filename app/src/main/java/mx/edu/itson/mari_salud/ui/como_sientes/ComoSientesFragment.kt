package mx.edu.itson.mari_salud.ui.como_sientes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_como_sientes.view.*
import mx.edu.itson.mari_salud.R

class ComoSientesFragment : Fragment() {


    private lateinit var notificationsViewModel: ComoSientesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel = ViewModelProvider(this).get(ComoSientesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_como_sientes, container, false)

        root.btnAgregarSentir.setOnClickListener {
            var intent= Intent(context, MeSientoActivity::class.java)
            startActivity(intent)
        }

        root.btnCalendario.setOnClickListener {
            var intent=Intent(context, CalendarioActivity::class.java)
            startActivity(intent)
        }

        return root
    }

}