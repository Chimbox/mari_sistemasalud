package mx.edu.itson.mari_salud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnEntrar.setOnClickListener {
            var intent=Intent(this,WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvRegistrate.setOnClickListener {
            var intent= Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}