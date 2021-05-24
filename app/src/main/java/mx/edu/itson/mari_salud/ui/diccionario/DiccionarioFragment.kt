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
import mx.edu.itson.mari_salud.ui.dominio.CategoriaDiccionario
import mx.edu.itson.mari_salud.ui.dominio.Diccionario
import mx.edu.itson.mari_salud.ui.dominio.SeccionDiccionario

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

        var medicina= CategoriaDiccionario("Medicina")
        var enfermedad= CategoriaDiccionario("Enfermedad")
        var guardados= CategoriaDiccionario("Guardados")
        var historial= CategoriaDiccionario("Historial")

        var seccionesParacetamol=ArrayList<SeccionDiccionario>()
        seccionesParacetamol.add(SeccionDiccionario("¿Qué cura?","Dolor de cabeza.\nDolor de espalda."))

        var seccionesDramamine=ArrayList<SeccionDiccionario>()
        seccionesDramamine.add(SeccionDiccionario("¿Para qué sirve?","Ayuda a prevenir y aliviar náusea, mareo y vómito asociados al movimiento."))
        seccionesDramamine.add(SeccionDiccionario("Modo de uso", "TABLETAS: Vía de administración oral. Tomar:\n" +
                "Adultos y niños mayores de 12 años: 1 a 2 tabletas cada 4 - 6 horas, sin exceder de 8 tabletas en 24 horas.\n" +
                "Niños de 6 a 12 años de edad: 1/2 a 1 tableta cada 6 - 8 horas sin exceder de 3 tabletas en 24 horas.\n" +
                "Niños de 2 a 6 años: 1/2 tableta cada 6 - 8 horas, sin exceder de 1 1/2 tableta en 24 horas.\n" +
                "\n" +
                "Tomar la primera dosis de DRAMAMINE® 30 minutos antes de iniciar el viaje o la actividad que provoca el mareo.."))

        var seccionesDolorCabeza=ArrayList<SeccionDiccionario>()
        seccionesDolorCabeza.add(SeccionDiccionario("Definición","Sensación dolorosa en cualquier parte de la cabeza, que va desde un dolor agudo a un dolor leve y puede ocurrir con otros síntomas."))
        seccionesDolorCabeza.add(SeccionDiccionario("Causas","Los dolores de cabeza pueden tener causas que no se deben a una enfermedad subyacente. Por ejemplo, falta de sueño, aumento incorrecto de los anteojos recetados, exposición a ruidos fuertes o uso de gorros o sombreros ajustados."))

        var seccionesOtraEnfermedad=ArrayList<SeccionDiccionario>()
        seccionesOtraEnfermedad.add(SeccionDiccionario("Definición","Esta es otra enfermedad."))
        seccionesOtraEnfermedad.add(SeccionDiccionario("Síntomas", "Estos son los síntomas."))

        lstDiccionarios.add(Diccionario("Dolor de cabeza",seccionesDolorCabeza, enfermedad))
        lstDiccionarios.add(Diccionario("Gripe",seccionesOtraEnfermedad, enfermedad))
        lstDiccionarios.add(Diccionario("Paracetamol", seccionesParacetamol, medicina))
        lstDiccionarios.add(Diccionario("Dramamine", seccionesDramamine, medicina))

        /*var adapter=DiccionarioListViewAdapter(lstDiccionarios,context)
        var lvDiccionario=root.findViewById(R.id.lvDiccionario) as ListView

        lvDiccionario.adapter=adapter*/



        var rgDiccionarios=root.rgDiccionarios

       rgDiccionarios.setOnCheckedChangeListener { radioGroup, i ->

            if(i>-1){
                var categoria: CategoriaDiccionario = CategoriaDiccionario()
                when(rgDiccionarios.checkedRadioButtonId){
                    btnMedicinas.id -> categoria = medicina
                    btnEnfermedad.id -> categoria = enfermedad
                    btnGuardados.id -> categoria = guardados
                    btnHistorial.id -> categoria = historial
                }

                var lstMostrar=ArrayList<Diccionario>()

                lstDiccionarios.forEach {
                    if(it.categoria.nombre.equals(categoria.nombre)){
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