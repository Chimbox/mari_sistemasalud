package mx.edu.itson.mari_salud.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_ajustes_estilo_vida.*
import mx.edu.itson.mari_salud.MenuActivity
import mx.edu.itson.mari_salud.R

class AjustesEstiloVidaActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore
    private var cargando = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes_estilo_vida)

        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()

        btn_back_estiloVida.setOnClickListener {
            finish()
        }

        getDatosEstiloVida()


        val lista_horas_suenio = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
        val adapter_suenio =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, lista_horas_suenio)
        spinner_horasSuenio.adapter = adapter_suenio

        spinner_horasSuenio.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!cargando) {
                    db.collection("perfil")
                        .document(MenuActivity.idDocumentoPerfil)
                        .update("tiempoSuenio", lista_horas_suenio[position])
                    tv_suenioHoras_estiloVida.text = (lista_horas_suenio[position].toString() + "h")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        val lista_consumoAgua = listOf(1, 2, 3, 4)
        val adapter_consumoAgua =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, lista_consumoAgua)
        spinner_consumoAgua.adapter = adapter_consumoAgua
        spinner_consumoAgua.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!cargando) {
                    db.collection("perfil")
                        .document(MenuActivity.idDocumentoPerfil)
                        .update("consumoAgua", lista_consumoAgua[position])
                    tv_consumoAgua_estiloVida.text = (lista_consumoAgua[position].toString() + "h")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val lista_peso = listOf(30, 40, 50, 60, 70, 80, 90)
        val adapter_peso = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista_peso)
        spinner_peso.adapter = adapter_peso
        spinner_peso.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!cargando) {
                    db.collection("perfil")
                        .document(MenuActivity.idDocumentoPerfil)
                        .update("peso", lista_peso[position])
                    tv_peso_estiloVida.text = (lista_peso[position].toString() + "h")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }


        val lista_estura = listOf(140, 150, 160, 170, 180, 190)
        val adapter_estura = ArrayAdapter(this, android.R.layout.simple_spinner_item, lista_estura)
        spinner_estatura.adapter = adapter_estura
        spinner_estatura.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (!cargando) {
                    db.collection("perfil")
                        .document(MenuActivity.idDocumentoPerfil)
                        .update("estatura", lista_estura[position])
                    tv_estatura_estiloVida.text = (lista_estura[position].toString() + "h")
                } else {
                    cargando = false
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun getDatosEstiloVida() {
        db.collection("perfil")
            .document(MenuActivity.idDocumentoPerfil)
            .get()
            .addOnSuccessListener { it ->
                var consumoAgua = it.get("consumoAgua") as Number
                var horas_suenio = it.get("tiempoSuenio") as Number
                var estatura = it.get("estatura") as Number
                var peso = it.get("peso") as Number

                tv_suenioHoras_estiloVida.text = horas_suenio.toString() + "h"
                tv_consumoAgua_estiloVida.text = consumoAgua.toString() + "h"
                tv_estatura_estiloVida.text = estatura.toString() + "h"
                tv_peso_estiloVida.text = peso.toString() + "h"
            }
    }
}