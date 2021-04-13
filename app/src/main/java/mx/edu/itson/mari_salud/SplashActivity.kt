package mx.edu.itson.mari_salud

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed(Runnable { // TODO: Your application init goes here.
            val mInHome = Intent(this, MainActivity::class.java)
            this.startActivity(mInHome)
            this.finish()
        }, 1000)

    }
}