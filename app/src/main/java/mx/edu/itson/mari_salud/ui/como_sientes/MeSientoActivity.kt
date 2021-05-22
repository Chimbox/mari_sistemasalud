package mx.edu.itson.mari_salud.ui.como_sientes

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_me_siento.*
import mx.edu.itson.mari_salud.MenuActivity
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Estado
import mx.edu.itson.mari_salud.ui.dominio.EstadoAnimo
import mx.edu.itson.mari_salud.ui.dominio.Sintoma
import java.time.LocalDateTime

class MeSientoActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private var lstEstadosAnimo=ArrayList<EstadoAnimo>()
    private var lstSintomas=ArrayList<Sintoma>()
    private var lstEstadosPersonalizado=ArrayList<Estado>()


    var lstEstados = ArrayList<Estado>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me_siento)
        val current = LocalDateTime.now()

        auth= FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()

        btn_back_hoySiento.setOnClickListener {
            finish()
        }

        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .get()
            .addOnSuccessListener {
                lstEstadosAnimo=it.get("estados_animo") as ArrayList<EstadoAnimo>
                lstSintomas=it.get("sintomas") as ArrayList<Sintoma>
                lstEstadosPersonalizado=it.get("estados_personalizado") as ArrayList<Estado>

                lstEstadosAnimo.forEach {
                    when(it){
                        EstadoAnimo.FELIZ->
                            btn_feliz_hoyMeSiento.setImageResource(R.mipmap.feliz_activo_48x48_mdpi)
                    }
                }
            }

        tv_fecha_hoySiento.text = current.dayOfMonth.toString() + " de " + current.month.toString()

        lstEstados.add(Estado("EstadoAnimo 1", false))
        lstEstados.add(Estado("EstadoAnimo 2", false))
        lstEstados.add(Estado("EstadoAnimo 3", false))
        var adapter = EditorEstadoLVAdapter(lstEstados, this)
        lv_estados.adapter = adapter

        btn_feliz_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.FELIZ)) {
                btn_feliz_hoyMeSiento.setImageResource(R.mipmap.feliz_activo_48x48_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.FELIZ)
                actualizaEstadosAnimo()
            } else {
                btn_feliz_hoyMeSiento.setImageResource(R.mipmap.feliz_48x48_mdpi)
                lstEstadosAnimo.remove(EstadoAnimo.FELIZ)
                actualizaEstadosAnimo()
            }
        }

        btn_calmado_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.CALMADO)) {
                btn_calmado_hoyMeSiento.setImageResource(R.mipmap.calmado_activo_48x48_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.CALMADO)
                actualizaEstadosAnimo()
            } else {
                btn_calmado_hoyMeSiento.setImageResource(R.mipmap.calmado_48x48_mdpi)
                lstEstadosAnimo.remove(EstadoAnimo.CALMADO)
                actualizaEstadosAnimo()
            }
        }

        btn_activo_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.ACTIVO)) {
                btn_activo_hoyMeSiento.setImageResource(R.mipmap.activo_activo_48x48_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.ACTIVO)
                actualizaEstadosAnimo()
            } else {
                btn_activo_hoyMeSiento.setImageResource(R.mipmap.activo_48x48_mdpi)
                lstEstadosAnimo.remove(EstadoAnimo.ACTIVO)
                actualizaEstadosAnimo()
            }
        }

        btn_triste_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.TRISTE)) {
                btn_triste_hoyMeSiento.setImageResource(R.mipmap.triste_activo_48x48_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.TRISTE)
                actualizaEstadosAnimo()
            } else {
                btn_triste_hoyMeSiento.setImageResource(R.mipmap.triste_48x48_mdpi)
                lstEstadosAnimo.remove(EstadoAnimo.TRISTE)
                actualizaEstadosAnimo()
            }
        }

        btn_irritado_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.IRRITADO)) {
                btn_irritado_hoyMeSiento.setImageResource(R.mipmap.irritado_activo_48x48_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.IRRITADO)
                actualizaEstadosAnimo()
            } else {
                btn_irritado_hoyMeSiento.setImageResource(R.mipmap.irritado_48x48_mdpi)
                lstEstadosAnimo.remove(EstadoAnimo.IRRITADO)
                actualizaEstadosAnimo()
            }
        }

        btn_ansioso_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.ANSIAS)) {
                btn_ansioso_hoyMeSiento.setImageResource(R.mipmap.ansioso_activo_48x48_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.ANSIAS)
                actualizaEstadosAnimo()
            } else {
                btn_ansioso_hoyMeSiento.setImageResource(R.mipmap.ansioso_48x48_mdpi)
                lstEstadosAnimo.remove(EstadoAnimo.ANSIAS)
                actualizaEstadosAnimo()
            }
        }

        btn_dolorCabeza_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.DOLOR_CABEZA)) {
                btn_dolorCabeza_hoyMeSiento.setImageResource(R.mipmap.dolorcabeza_activo_48x48_mdpi)
                lstSintomas.add(Sintoma.DOLOR_CABEZA)
                actualizaSintomas()
            } else {
                btn_dolorCabeza_hoyMeSiento.setImageResource(R.mipmap.dolorcabeza_48x48_mdpi)
                lstSintomas.remove(Sintoma.DOLOR_CABEZA)
                actualizaSintomas()
            }
        }

        btn_insomnio_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.INSOMNIO)) {
                btn_insomnio_hoyMeSiento.setImageResource(R.mipmap.insomnio_activo_48x48_mdpi)
                lstSintomas.add(Sintoma.INSOMNIO)
                actualizaSintomas()
            } else {
                btn_insomnio_hoyMeSiento.setImageResource(R.mipmap.insomnio_48x48_mdpi)
                lstSintomas.remove(Sintoma.INSOMNIO)
                actualizaSintomas()
            }
        }

        btn_diarrea_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.DIARREA)) {
                btn_diarrea_hoyMeSiento.setImageResource(R.mipmap.diarrea_activo_48x48_mdpi)
                lstSintomas.add(Sintoma.DIARREA)
                actualizaSintomas()
            } else {
                btn_diarrea_hoyMeSiento.setImageResource(R.mipmap.diarrea_48x48_mdpi)
                lstSintomas.remove(Sintoma.DIARREA)
                actualizaSintomas()
            }
        }

        btn_gripe_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.GRIPE)) {
                btn_gripe_hoyMeSiento.setImageResource(R.mipmap.gripe_activo_48x48_mdpi)
                lstSintomas.add(Sintoma.GRIPE)
                actualizaSintomas()
            } else {
                btn_gripe_hoyMeSiento.setImageResource(R.mipmap.gripe_36x36_ldpi)
                lstSintomas.remove(Sintoma.GRIPE)
                actualizaSintomas()
            }
        }

        btn_tos_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.TOS)) {
                btn_tos_hoyMeSiento.setImageResource(R.mipmap.tos_activo_48x48_mdpi)
                lstSintomas.add(Sintoma.TOS)
                actualizaSintomas()
            } else {
                btn_tos_hoyMeSiento.setImageResource(R.mipmap.tos_48x48_mdpi)
                lstSintomas.remove(Sintoma.TOS)
                actualizaSintomas()
            }
        }

        btn_dolorGarganta_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.DOLOR_GARGANTA)) {
                btn_dolorGarganta_hoyMeSiento.setImageResource(R.mipmap.dolorgarganta_activo_48x48_mdpi)
                lstSintomas.add(Sintoma.DOLOR_GARGANTA)
                actualizaSintomas()
            } else {
                btn_dolorGarganta_hoyMeSiento.setImageResource(R.mipmap.dolorgarganta_48x48_mdpi)
                lstSintomas.remove(Sintoma.DOLOR_GARGANTA)
                actualizaSintomas()
            }
        }


        lytAniadirEstado.setOnClickListener {
            var intent = Intent(this, MisEstadosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun actualizaEstadosAnimo(){
        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .update("estados_animo", lstEstadosAnimo)
    }
    private fun actualizaSintomas(){
        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .update("sintomas", lstSintomas)
    }
    private fun actualizaEstadosPersonalizado(){
        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .update("estados_personalizado", lstEstadosPersonalizado)
    }
}