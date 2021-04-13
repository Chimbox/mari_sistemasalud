package mx.edu.itson.mari_salud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val handler = Handler()
        handler.postDelayed(Runnable { // TODO: Your application init goes here.
            val mInHome = Intent(this, MenuActivity::class.java)
            this.startActivity(mInHome)
            this.finish()
        }, 1000)
    }
}