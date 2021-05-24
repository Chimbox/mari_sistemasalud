package mx.edu.itson.mari_salud.ui.metas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_metas.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Meta

class MetasFragment : Fragment() {

    var lstMetas=ArrayList<Meta>()
    private lateinit var dashboardViewModel: MetasViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(MetasViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_metas, container, false)

        lstMetas.add(Meta("Bajar 3kg", false))
        lstMetas.add(Meta("Mantener la dieta 1 semana", true))
        lstMetas.add(Meta("Trotar 2500m sin parar", false))

        var adapter=MetaListViewAdapter(lstMetas, context)
        root.lvMetas.adapter=adapter

        root.lytAniadirMeta.setOnClickListener {
            var intent = Intent(context,ActivityEditorMetas::class.java)
            startActivity(intent)
        }

        return root
    }
}