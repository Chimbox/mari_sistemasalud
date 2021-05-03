package mx.edu.itson.mari_salud.ui.diccionario

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_diccionario.*
import kotlinx.android.synthetic.main.fragment_diccionario.view.*
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

        var medicina=CategoriaDiccionario(0, "Medicina")
        var enfermedad=CategoriaDiccionario(1,"Enfermedad")
        var guardados=CategoriaDiccionario(2,"Guardados")
        var historial=CategoriaDiccionario(3,"Historial")

        var seccionesParacetamol=ArrayList<SeccionDiccionario>()
        seccionesParacetamol.add(SeccionDiccionario("¿Qué cura?","Dolor de cabeza.\nDolor de espalda."))

        var seccionesDramamine=ArrayList<SeccionDiccionario>()
        seccionesDramamine.add(SeccionDiccionario("¿Para qué sirve?","Prevención de mareos."))
        seccionesDramamine.add(SeccionDiccionario("Modo de uso", "Tomar una tableta antes de viajar."))

        var seccionesDolorCabeza=ArrayList<SeccionDiccionario>()
        seccionesDolorCabeza.add(SeccionDiccionario("Definición","Lorem ipsum is simply dummy text of the printing and typesetting industry."))
        seccionesDolorCabeza.add(SeccionDiccionario("Síntomas","Se siente medio feo.\nOtro síntoma."))

        var seccionesOtraEnfermedad=ArrayList<SeccionDiccionario>()
        seccionesOtraEnfermedad.add(SeccionDiccionario("Definición","Esta es otra enfermedad."))
        seccionesOtraEnfermedad.add(SeccionDiccionario("Síntomas", "Estos son los síntomas."))

        lstDiccionarios.add(Diccionario("Dolor de cabeza",seccionesDolorCabeza, enfermedad))
        lstDiccionarios.add(Diccionario("Otra enfermedad",seccionesOtraEnfermedad, enfermedad))
        lstDiccionarios.add(Diccionario("Paracetamol", seccionesParacetamol, medicina))
        lstDiccionarios.add(Diccionario("Dramamine", seccionesDramamine, medicina))

        /*var adapter=DiccionarioListViewAdapter(lstDiccionarios,context)
        var lvDiccionario=root.findViewById(R.id.lvDiccionario) as ListView

        lvDiccionario.adapter=adapter*/



        var rgDiccionarios=root.rgDiccionarios

       rgDiccionarios.setOnCheckedChangeListener { radioGroup, i ->

            if(i>-1){
                var categoria:CategoriaDiccionario=CategoriaDiccionario()
                when(rgDiccionarios.checkedRadioButtonId){
                    btnMedicinas.id -> categoria = medicina
                    btnEnfermedad.id -> categoria = enfermedad
                    btnGuardados.id -> categoria = guardados
                    btnHistorial.id -> categoria = historial
                }

                var lstMostrar=ArrayList<Diccionario>()

                lstDiccionarios.forEach {
                    if(it.categoria.id==categoria.id){
                        lstMostrar.add(it)
                    }
                }

                var adapter=DiccionarioListViewAdapter(lstMostrar, context)
                var lvDiccionario=root.findViewById(R.id.lvDiccionario) as ListView

                lvDiccionario.adapter=adapter

                lvDiccionario.setOnItemClickListener { adapterView, view, i, l ->
                    var item=adapterView.getItemAtPosition(i) as Diccionario
                    if(item!=null){
                        var intent= Intent(context, SeccionDiccionarioActivity::class.java)
                        intent.putExtra("diccionario",item)
                        startActivity(intent)
                    }
                }
            }
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiccionarioViewModel::class.java)
        btnMedicinas.isChecked=true
        // TODO: Use the ViewModel
    }

}