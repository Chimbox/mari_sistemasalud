package mx.edu.itson.mari_salud.ui.emergencia

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mx.edu.itson.mari_salud.R

class EmergenciaFragment : Fragment() {

    companion object {
        fun newInstance() = EmergenciaFragment()
    }

    private lateinit var viewModel: EmergenciaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.emergencia_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EmergenciaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}