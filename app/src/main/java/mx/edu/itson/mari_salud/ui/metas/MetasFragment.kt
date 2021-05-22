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

        lstMetas.add(Meta("Meta 1", false))
        lstMetas.add(Meta("Meta 2", true))
        lstMetas.add(Meta("Meta 3", false))
        lstMetas.add(Meta("Meta 4", false))
        lstMetas.add(Meta("Meta 5", false))

        var adapter=MetaListViewAdapter(lstMetas, context)
        root.lvMetas.adapter=adapter

        root.lytAniadirMeta.setOnClickListener {
            var intent = Intent(context,ActivityEditorMetas::class.java)
            startActivity(intent)
        }

        return root
    }
}