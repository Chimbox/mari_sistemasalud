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
    private var lstEstadosAnimo = ArrayList<EstadoAnimo>()
    private var lstSintomas = ArrayList<Sintoma>()
    private var lstEstadosPersonalizado = ArrayList<Estado>()


    var lstEstados = ArrayList<Estado>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me_siento)
        val current = LocalDateTime.now()

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        btn_back_hoySiento.setOnClickListener {
            finish()
        }

        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .get()
            .addOnSuccessListener {
                var lstStringEstadosAnimo = it.get("estados_animo") as ArrayList<String>
                var lstStringSintomas = it.get("sintomas") as ArrayList<String>
                var lstStringEstadosPersonalizado =
                    it.get("estados_personalizado") as ArrayList<String>

                lstStringEstadosAnimo.forEach {
                    when (it) {
                        EstadoAnimo.FELIZ.toString() -> {
                            lstEstadosAnimo.add(EstadoAnimo.FELIZ)
                            btn_feliz_hoyMeSiento.setImageResource(R.mipmap.feliz_acitvo_72x72_mdpi)
                        }

                        EstadoAnimo.CALMADO.toString() -> {
                            lstEstadosAnimo.add(EstadoAnimo.CALMADO)
                            btn_calmado_hoyMeSiento.setImageResource(R.mipmap.calmado_acitvo_72x72_mdpi)
                        }

                        EstadoAnimo.ACTIVO.toString() -> {
                            lstEstadosAnimo.add(EstadoAnimo.ACTIVO)
                            btn_activo_hoyMeSiento.setImageResource(R.mipmap.activo_acitvo_72x72_mdpi)
                        }

                        EstadoAnimo.TRISTE.toString() -> {
                            lstEstadosAnimo.add(EstadoAnimo.TRISTE)
                            btn_triste_hoyMeSiento.setImageResource(R.mipmap.triste_acitvo_72x72_mdpi)
                        }
                        EstadoAnimo.IRRITADO.toString() -> {
                            lstEstadosAnimo.add(EstadoAnimo.IRRITADO)
                            btn_irritado_hoyMeSiento.setImageResource(R.mipmap.irritado_acitvo_72x72_mdpi)
                        }
                        EstadoAnimo.ANSIAS.toString() -> {
                            lstEstadosAnimo.add(EstadoAnimo.ANSIAS)
                            btn_ansioso_hoyMeSiento.setImageResource(R.mipmap.ansioso_acitvo_72x72_mdpi)
                        }
                    }
                }

                lstStringSintomas.forEach { it ->
                    when (it) {
                        Sintoma.DIARREA.toString() -> {
                            lstSintomas.add(Sintoma.DIARREA)
                            btn_diarrea_hoyMeSiento.setImageResource(R.mipmap.diarrea_acitvo_72x72_mdpi)
                        }
                        Sintoma.DOLOR_CABEZA.toString() -> {
                            lstSintomas.add(Sintoma.DOLOR_CABEZA)
                            btn_dolorCabeza_hoyMeSiento.setImageResource(R.mipmap.dolrocabeza_acitvo_72x72_mdpi)
                        }
                        Sintoma.DOLOR_GARGANTA.toString() -> {
                            lstSintomas.add(Sintoma.DOLOR_GARGANTA)
                            btn_dolorGarganta_hoyMeSiento.setImageResource(R.mipmap.dolorcabeza_acitvo_72x72_mdpi)
                        }
                        Sintoma.GRIPE.toString() -> {
                            lstSintomas.add(Sintoma.GRIPE)
                            btn_gripe_hoyMeSiento.setImageResource(R.mipmap.gripe_acitvo_72x72_mdpi)
                        }
                        Sintoma.INSOMNIO.toString() -> {
                            lstSintomas.add(Sintoma.INSOMNIO)
                            btn_insomnio_hoyMeSiento.setImageResource(R.mipmap.insomnio_acitvo_72x72_mdpi)
                        }
                        Sintoma.TOS.toString() -> {
                            lstSintomas.add(Sintoma.TOS)
                            btn_tos_hoyMeSiento.setImageResource(R.mipmap.tos_acitvo_72x72_mdpi)
                        }
                    }
                }

            }

        tv_fecha_hoySiento.text = current.dayOfMonth.toString() + " de " + current.month.toString()

        lstEstados.add(Estado("Achicopalado", false))
        lstEstados.add(Estado("A gusto", false))
        lstEstados.add(Estado("Al cien", false))
        var adapter = EditorEstadoLVAdapter(lstEstados, this)
        lv_estados.adapter = adapter

        btn_feliz_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.FELIZ)) {
                btn_feliz_hoyMeSiento.setImageResource(R.mipmap.feliz_acitvo_72x72_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.FELIZ)
                actualizaEstadosAnimo()
            } else {
                btn_feliz_hoyMeSiento.setImageResource(R.mipmap.feliz_72x72_hdpi)
                lstEstadosAnimo.remove(EstadoAnimo.FELIZ)
                actualizaEstadosAnimo()
            }
        }

        btn_calmado_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.CALMADO)) {
                btn_calmado_hoyMeSiento.setImageResource(R.mipmap.calmado_acitvo_72x72_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.CALMADO)
                actualizaEstadosAnimo()
            } else {
                btn_calmado_hoyMeSiento.setImageResource(R.mipmap.calmado_72x72_hdpi)
                lstEstadosAnimo.remove(EstadoAnimo.CALMADO)
                actualizaEstadosAnimo()
            }
        }

        btn_activo_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.ACTIVO)) {
                btn_activo_hoyMeSiento.setImageResource(R.mipmap.activo_acitvo_72x72_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.ACTIVO)
                actualizaEstadosAnimo()
            } else {
                btn_activo_hoyMeSiento.setImageResource(R.mipmap.activo_96x96_xhdpi)
                lstEstadosAnimo.remove(EstadoAnimo.ACTIVO)
                actualizaEstadosAnimo()
            }
        }

        btn_triste_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.TRISTE)) {
                btn_triste_hoyMeSiento.setImageResource(R.mipmap.triste_acitvo_72x72_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.TRISTE)
                actualizaEstadosAnimo()
            } else {
                btn_triste_hoyMeSiento.setImageResource(R.mipmap.triste_72x72_hdpi)
                lstEstadosAnimo.remove(EstadoAnimo.TRISTE)
                actualizaEstadosAnimo()
            }
        }

        btn_irritado_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.IRRITADO)) {
                btn_irritado_hoyMeSiento.setImageResource(R.mipmap.irritado_acitvo_72x72_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.IRRITADO)
                actualizaEstadosAnimo()
            } else {
                btn_irritado_hoyMeSiento.setImageResource(R.mipmap.irritado_72x72_hdpi)
                lstEstadosAnimo.remove(EstadoAnimo.IRRITADO)
                actualizaEstadosAnimo()
            }
        }

        btn_ansioso_hoyMeSiento.setOnClickListener {
            if (!lstEstadosAnimo.contains(EstadoAnimo.ANSIAS)) {
                btn_ansioso_hoyMeSiento.setImageResource(R.mipmap.ansioso_acitvo_72x72_mdpi)
                lstEstadosAnimo.add(EstadoAnimo.ANSIAS)
                actualizaEstadosAnimo()
            } else {
                btn_ansioso_hoyMeSiento.setImageResource(R.mipmap.ansioso_72x72_hdpi)
                lstEstadosAnimo.remove(EstadoAnimo.ANSIAS)
                actualizaEstadosAnimo()
            }
        }

        btn_dolorCabeza_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.DOLOR_CABEZA)) {
                btn_dolorCabeza_hoyMeSiento.setImageResource(R.mipmap.dolrocabeza_acitvo_72x72_mdpi)
                lstSintomas.add(Sintoma.DOLOR_CABEZA)
                actualizaSintomas()
            } else {
                btn_dolorCabeza_hoyMeSiento.setImageResource(R.mipmap.dolorcabeza_72x72_hdpi)
                lstSintomas.remove(Sintoma.DOLOR_CABEZA)
                actualizaSintomas()
            }
        }

        btn_insomnio_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.INSOMNIO)) {
                btn_insomnio_hoyMeSiento.setImageResource(R.mipmap.insomnio_acitvo_72x72_mdpi)
                lstSintomas.add(Sintoma.INSOMNIO)
                actualizaSintomas()
            } else {
                btn_insomnio_hoyMeSiento.setImageResource(R.mipmap.insomnio_72x72_hdpi)
                lstSintomas.remove(Sintoma.INSOMNIO)
                actualizaSintomas()
            }
        }

        btn_diarrea_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.DIARREA)) {
                btn_diarrea_hoyMeSiento.setImageResource(R.mipmap.diarrea_acitvo_72x72_mdpi)
                lstSintomas.add(Sintoma.DIARREA)
                actualizaSintomas()
            } else {
                btn_diarrea_hoyMeSiento.setImageResource(R.mipmap.diarrea_72x72_hdpi)
                lstSintomas.remove(Sintoma.DIARREA)
                actualizaSintomas()
            }
        }

        btn_gripe_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.GRIPE)) {
                btn_gripe_hoyMeSiento.setImageResource(R.mipmap.gripe_acitvo_72x72_mdpi)
                lstSintomas.add(Sintoma.GRIPE)
                actualizaSintomas()
            } else {
                btn_gripe_hoyMeSiento.setImageResource(R.mipmap.gripe_72x72_hdpi)
                lstSintomas.remove(Sintoma.GRIPE)
                actualizaSintomas()
            }
        }

        btn_tos_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.TOS)) {
                btn_tos_hoyMeSiento.setImageResource(R.mipmap.tos_acitvo_72x72_mdpi)
                lstSintomas.add(Sintoma.TOS)
                actualizaSintomas()
            } else {
                btn_tos_hoyMeSiento.setImageResource(R.mipmap.tos_72x72_hdpi)
                lstSintomas.remove(Sintoma.TOS)
                actualizaSintomas()
            }
        }

        btn_dolorGarganta_hoyMeSiento.setOnClickListener {
            if (!lstSintomas.contains(Sintoma.DOLOR_GARGANTA)) {
                btn_dolorGarganta_hoyMeSiento.setImageResource(R.mipmap.dolorcabeza_acitvo_72x72_mdpi)
                lstSintomas.add(Sintoma.DOLOR_GARGANTA)
                actualizaSintomas()
            } else {
                btn_dolorGarganta_hoyMeSiento.setImageResource(R.mipmap.dolorgarganta_72x72_hdpi)
                lstSintomas.remove(Sintoma.DOLOR_GARGANTA)
                actualizaSintomas()
            }
        }


        lytAniadirEstado.setOnClickListener {
            var intent = Intent(this, MisEstadosActivity::class.java)
            startActivity(intent)
        }
    }

    private fun actualizaEstadosAnimo() {
        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .update("estados_animo", lstEstadosAnimo)
    }

    private fun actualizaSintomas() {
        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .update("sintomas", lstSintomas)
    }

    private fun actualizaEstadosPersonalizado() {
        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .update("estados_personalizado", lstEstadosPersonalizado)
    }
}