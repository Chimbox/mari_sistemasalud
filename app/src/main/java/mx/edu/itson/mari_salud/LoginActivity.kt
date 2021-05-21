package mx.edu.itson.mari_salud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.etEmail
import kotlinx.android.synthetic.main.activity_login.etPassword
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth= FirebaseAuth.getInstance()
        btnEntrar.setOnClickListener {
            if(!etEmail.text.toString().isNullOrBlank()&&!etPassword.text.toString().isNullOrBlank()){
                login(etEmail.text.toString(), etPassword.text.toString())
            }else{
                Toast.makeText(this, "Los campos no pueden quedar vacíos.", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegistrate.setOnClickListener {
            var intent= Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun login(email:String, password:String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    var intent=Intent(this,WelcomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Ha ocurrido un error al iniciar sesión, intente de nuevo.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}