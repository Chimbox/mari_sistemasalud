package mx.edu.itson.mari_salud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnCrearCuenta.setOnClickListener {
            var intent= Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvIniciaSesion.setOnClickListener {
            var intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}