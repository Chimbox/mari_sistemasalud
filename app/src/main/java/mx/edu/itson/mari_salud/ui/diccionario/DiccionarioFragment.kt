package mx.edu.itson.mari_salud.ui.diccionario

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import mx.edu.itson.mari_salud.R

class DiccionarioFragment : Fragment() {

    var lstDiccionarios=ArrayList<Diccionario>()

    companion object {
        fun newInstance() = DiccionarioFragment()
    }

    private lateinit var viewModel: DiccionarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root=inflater.inflate(R.layout.fragment_diccionario, container, false)

        lstDiccionarios.add(Diccionario("Dolor de cabeza",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))
        lstDiccionarios.add(Diccionario("Text",ArrayList<SeccionDiccionario>()))

        var adapter=DiccionarioListViewAdapter(lstDiccionarios,context)
        var lvDiccionario=root.findViewById(R.id.lvDiccionario) as ListView

        lvDiccionario.adapter=adapter
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiccionarioViewModel::class.java)
        // TODO: Use the ViewModel
    }

}