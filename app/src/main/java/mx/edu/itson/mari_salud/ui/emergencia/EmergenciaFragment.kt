package mx.edu.itson.mari_salud.ui.emergencia

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import mx.edu.itson.mari_salud.R
import android.view.ViewGroup
import kotlinx.android.synthetic.main.emergencia_fragment.view.*
import mx.edu.itson.mari_salud.ui.dominio.Emergencia


class EmergenciaFragment : Fragment() {

    var lstEmergencias=ArrayList<Emergencia>()

    companion object {
        fun newInstance() = EmergenciaFragment()
    }

    private lateinit var viewModel: EmergenciaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root=inflater.inflate(R.layout.emergencia_fragment, container, false)

        lstEmergencias.add(Emergencia(resources.getString(R.string.herida_abierta)))
        lstEmergencias.add(Emergencia(resources.getString(R.string.heimlich)))
        lstEmergencias.add(Emergencia(resources.getString(R.string.rcp)))

        var adapter=EmergenciaListViewAdapter(lstEmergencias, context)

        root.btn_necesitoAyuda_emergencia.setOnClickListener {
            var intent= Intent(context,NecesitoAyudaActivity::class.java)
            startActivity(intent)
        }
        root.lvEmergencias.adapter=adapter

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmergenciaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}