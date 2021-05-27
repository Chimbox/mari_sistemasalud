package mx.edu.itson.mari_salud.ui.emergencia

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_necesito_ayuda.*
import mx.edu.itson.mari_salud.R

class NecesitoAyudaActivity : AppCompatActivity() {
    private var STORAGE_PERMISSION_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_necesito_ayuda)
        btnRegresar_necesitoAyuda.setOnClickListener {
            finish()
        }
        btn_necesitoAtencion_NecesitoAyuda.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
              call()
            } else {
                requestCallPermission()
            }
        }
    }

    private fun call() {
        var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"))
        startActivity(intent)

    }

    private fun requestCallPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CALL_PHONE
            )
        ) {
            Toast.makeText(this, "Activar permisos desde ajustes", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                STORAGE_PERMISSION_CODE
            )
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                call()
            } else {
                Toast.makeText(this, "permisos rechazados", Toast.LENGTH_SHORT).show()
            }
        }
    }

}