package mx.edu.itson.mari_salud.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import mx.edu.itson.mari_salud.MainActivity
import mx.edu.itson.mari_salud.MenuActivity
import mx.edu.itson.mari_salud.R

class ProfileFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private lateinit var homeViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .get()
            .addOnSuccessListener {
                root.btnNombre.text = it.getString("nombre")
                root.btnApellido.text = it.getString("apellido")
            }

        root.btnCerrarSesion.setOnClickListener {
            auth.signOut()
            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        root.btnAjusteEstiloVida.setOnClickListener {
            var intent = Intent(context, AjustesEstiloVidaActivity::class.java)
            startActivity(intent)
        }
        return root
    }
}