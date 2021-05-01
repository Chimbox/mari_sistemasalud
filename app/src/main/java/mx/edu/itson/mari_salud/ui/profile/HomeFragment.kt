package mx.edu.itson.mari_salud.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_profile.view.*
import mx.edu.itson.mari_salud.MainActivity
import mx.edu.itson.mari_salud.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        root.btnCerrarSesion.setOnClickListener {
            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        root.btnAjusteEstiloVida.setOnClickListener {
            var intent= Intent(context, AjustesEstiloVidaActivity::class.java)
            startActivity(intent)
        }
        return root
    }
}