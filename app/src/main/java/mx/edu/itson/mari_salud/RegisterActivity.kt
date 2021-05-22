package mx.edu.itson.mari_salud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register.*
import mx.edu.itson.mari_salud.ui.dominio.Estado
import mx.edu.itson.mari_salud.ui.dominio.EstadoAnimo
import mx.edu.itson.mari_salud.ui.dominio.Sintoma

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth= FirebaseAuth.getInstance()
        db= FirebaseFirestore.getInstance()

        btnCrearCuenta.setOnClickListener {
            if(!etNombre.text.toString().isNullOrBlank()&&
                !etApellido.text.toString().isNullOrBlank()&&
                !etEmail.text.toString().isNullOrBlank()&&
                !etPassword.text.toString().isNullOrBlank()){
                registrarCuenta(etNombre.text.toString(),
                    etApellido.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString())
            }else{
                Toast.makeText(this, "Los campos no pueden quedar vacíos.", Toast.LENGTH_SHORT).show()
            }
        }

        tvIniciaSesion.setOnClickListener {
            var intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registrarCuenta(nombre:String, apellido:String, email:String, password:String) {
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener (this) {
                if(it.isSuccessful){
                    var perfilHashMap = hashMapOf(
                        "nombre" to nombre,
                        "apellido" to apellido,
                        "estados_animo" to ArrayList<EstadoAnimo>(),
                        "estados_personalizado" to ArrayList<Estado>(),
                        "sintomas" to ArrayList<Sintoma>(),
                        "imagen" to "",
                        "email" to email,
                        "notas" to ""
                    )

                    db.collection("perfil")
                        .add(perfilHashMap)
                        .addOnSuccessListener {
                            MenuActivity.idDocumentoPerfil=it.id
                            var intent= Intent(this, WelcomeActivity::class.java)
                            startActivity(intent)
                            finish()
                        }
                }else{
                    Toast.makeText(this, "Ha ocurrido un error al registrar, intente de nuevo.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}