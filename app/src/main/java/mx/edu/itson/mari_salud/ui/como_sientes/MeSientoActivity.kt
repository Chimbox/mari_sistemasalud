package mx.edu.itson.mari_salud.ui.como_sientes

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_me_siento.*
import kotlinx.android.synthetic.main.activity_mis_estados.*
import mx.edu.itson.mari_salud.R
import java.time.LocalDateTime

class MeSientoActivity : AppCompatActivity() {

    var lstEstados = ArrayList<Estado>()
    private val listaBtnActivo = mutableListOf<Boolean>(
        false, false, false, false, false,
        false, false, false, false, false, false, false
    )

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_me_siento)
        val current = LocalDateTime.now()

        btn_back_hoySiento.setOnClickListener {
            finish()
        }

        tv_fecha_hoySiento.text = current.dayOfMonth.toString() + " de " + current.month.toString()

        lstEstados.add(Estado("Estado 1", false))
        lstEstados.add(Estado("Estado 2", false))
        lstEstados.add(Estado("Estado 3", false))
        var adapter = EditorEstadoLVAdapter(lstEstados, this)
        lv_estados.adapter = adapter

        btn_feliz_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[0]) {
                btn_feliz_hoyMeSiento.setImageResource(R.mipmap.feliz_activo_48x48_mdpi)
                listaBtnActivo[0] = true
            } else {
                btn_feliz_hoyMeSiento.setImageResource(R.mipmap.feliz_48x48_mdpi)
                listaBtnActivo[0] = false
            }
        }

        btn_calmado_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[1]) {
                btn_calmado_hoyMeSiento.setImageResource(R.mipmap.calmado_activo_48x48_mdpi)
                listaBtnActivo[1] = true
            } else {
                btn_calmado_hoyMeSiento.setImageResource(R.mipmap.calmado_48x48_mdpi)
                listaBtnActivo[1] = false
            }
        }

        btn_activo_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[2]) {
                btn_activo_hoyMeSiento.setImageResource(R.mipmap.activo_activo_48x48_mdpi)
                listaBtnActivo[2] = true
            } else {
                btn_activo_hoyMeSiento.setImageResource(R.mipmap.activo_48x48_mdpi)
                listaBtnActivo[2] = false
            }
        }

        btn_triste_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[3]) {
                btn_triste_hoyMeSiento.setImageResource(R.mipmap.triste_activo_48x48_mdpi)
                listaBtnActivo[3] = true
            } else {
                btn_triste_hoyMeSiento.setImageResource(R.mipmap.triste_48x48_mdpi)
                listaBtnActivo[3] = false
            }
        }

        btn_irritado_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[4]) {
                btn_irritado_hoyMeSiento.setImageResource(R.mipmap.irritado_activo_48x48_mdpi)
                listaBtnActivo[4] = true
            } else {
                btn_irritado_hoyMeSiento.setImageResource(R.mipmap.irritado_48x48_mdpi)
                listaBtnActivo[4] = false
            }
        }

        btn_ansioso_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[5]) {
                btn_ansioso_hoyMeSiento.setImageResource(R.mipmap.ansioso_activo_48x48_mdpi)
                listaBtnActivo[5] = true
            } else {
                btn_ansioso_hoyMeSiento.setImageResource(R.mipmap.ansioso_48x48_mdpi)
                listaBtnActivo[5] = false
            }
        }

        btn_dolorCabeza_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[6]) {
                btn_dolorCabeza_hoyMeSiento.setImageResource(R.mipmap.dolorcabeza_activo_48x48_mdpi)
                listaBtnActivo[6] = true
            } else {
                btn_dolorCabeza_hoyMeSiento.setImageResource(R.mipmap.dolorcabeza_48x48_mdpi)
                listaBtnActivo[6] = false
            }
        }

        btn_insomnio_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[7]) {
                btn_insomnio_hoyMeSiento.setImageResource(R.mipmap.insomnio_activo_48x48_mdpi)
                listaBtnActivo[7] = true
            } else {
                btn_insomnio_hoyMeSiento.setImageResource(R.mipmap.insomnio_48x48_mdpi)
                listaBtnActivo[7] = false
            }
        }

        btn_diarrea_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[8]) {
                btn_diarrea_hoyMeSiento.setImageResource(R.mipmap.diarrea_activo_48x48_mdpi)
                listaBtnActivo[8] = true
            } else {
                btn_diarrea_hoyMeSiento.setImageResource(R.mipmap.diarrea_48x48_mdpi)
                listaBtnActivo[8] = false
            }
        }

        btn_gripe_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[9]) {
                btn_gripe_hoyMeSiento.setImageResource(R.mipmap.gripe_activo_48x48_mdpi)
                listaBtnActivo[9] = true
            } else {
                btn_gripe_hoyMeSiento.setImageResource(R.mipmap.gripe_36x36_ldpi)
                listaBtnActivo[9] = false
            }
        }

        btn_tos_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[10]) {
                btn_tos_hoyMeSiento.setImageResource(R.mipmap.tos_activo_48x48_mdpi)
                listaBtnActivo[10] = true
            } else {
                btn_tos_hoyMeSiento.setImageResource(R.mipmap.tos_48x48_mdpi)
                listaBtnActivo[10] = false
            }
        }

        btn_dolorGarganta_hoyMeSiento.setOnClickListener {
            if (!listaBtnActivo[11]) {
                btn_dolorGarganta_hoyMeSiento.setImageResource(R.mipmap.dolorgarganta_activo_48x48_mdpi)
                listaBtnActivo[11] = true
            } else {
                btn_dolorGarganta_hoyMeSiento.setImageResource(R.mipmap.dolorgarganta_48x48_mdpi)
                listaBtnActivo[11] = false
            }
        }


        lytAniadirEstado.setOnClickListener {
            var intent = Intent(this, MisEstadosActivity::class.java)
            startActivity(intent)
        }
    }
}