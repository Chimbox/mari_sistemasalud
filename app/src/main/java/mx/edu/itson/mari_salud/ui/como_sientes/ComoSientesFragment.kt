package mx.edu.itson.mari_salud.ui.como_sientes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.perfmark.Tag
import kotlinx.android.synthetic.main.fragment_como_sientes.view.*
import mx.edu.itson.mari_salud.R
import mx.edu.itson.mari_salud.ui.dominio.Estado

class ComoSientesFragment : Fragment() {


    private lateinit var notificationsViewModel: ComoSientesViewModel
    private var consejos = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel = ViewModelProvider(this).get(ComoSientesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_como_sientes, container, false)
        addConsejos()
        var sizeConsejos = consejos.size - 1

        val rand = (0..sizeConsejos).random()
        root.text_notifications.text = consejos[rand]

        root.btnAgregarSentir.setOnClickListener {
            var intent = Intent(context, MeSientoActivity::class.java)
            startActivity(intent)
        }

        root.btnCalendario.setOnClickListener {
            var intent = Intent(context, CalendarioActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    private fun addConsejos() {
        consejos.add("Fíjate en cosas tan sencillas que nunca te pones a pensar en lo afortunado que eres, valora todo aquello que tienes y se agradecido por ello.  Siempre hay algo por lo que tienes que agradecer.")
        consejos.add("Deja de decir y prometer, ¡hazlo de verdad! Cada día es una oportunidad para ser una mejor versión de ti mismo, toma acción.")
        consejos.add("Persigue tus sueños, pero no dejes que estos te estresen a un nivel que no los disfrutes. Asegúrate de pasar el tiempo con las personas que te importan, mantén un balance en tu vida y disfruta cada momento.")
        consejos.add("No tiene nada de malo equivocarse, todos lo hacemos. Mejor aprende de esos fracasos y sal adelante aprendiendo de ellos.")
        consejos.add("No te obsesiones con el pasado, éste quedó atrás y no lo puedes cambiar. Enfócate en el presente y no tengas miedo del futuro.")
        consejos.add("El único momento es el presente, despreocúpate por el pasado y no desperdicies tiempo pensando en futuro, vive cada momento.")
        consejos.add("Muchas veces creemos que nuestros problemas son más grandes de lo que en verdad son, mira a tu alrededor y date cuenta en verdad cuales son los problemas por los que deberías preocuparte.")
        consejos.add("Las frutas y verduras, cereales, tubérculos, legumbres, setas y demás vegetales forman parte de la dieta mediterránea y, por tanto, deben formar parte en una alimentación equilibrada.")
        consejos.add("Consume a diario 5 raciones de fruta y verdura, a poder ser 3 de fruta y 2 de verdura. Una ración de fruta o verdura equivale a unos 140-150 gramos.")
        consejos.add("El consumo en crudo, siempre que se pueda, es el mejor modo de asegurar el aprovechamiento de los nutrientes de frutas y verduras.")
        consejos.add("Las legumbres son una buena fuente de proteínas, y por tanto, una alternativa a los alimentos de origen animal. Las legumbres deben aparecer en tu dieta como mínimo 3 veces a la semana")
        consejos.add("No superes las 3 o 4 raciones de carne a la semana y consume, siempre que sea posible, carnes blancas y magras como pollo, conejo o pavo.")
        consejos.add("Usa la olla, la plancha, la vaporera, el estuche de vapor, o el horno para cocinar. Deja los fritos para ocasiones especiales y apuesta por las otras técnicas de cocción, mucho más ligeras. En todos los casos, usa el aceite de oliva virgen extra tanto para aliñar como para cocinar.")
        consejos.add("Lánzate a cocinar con alimentos frescos y saludables.")
        consejos.add("Infórmate en tu tienda o mercado habitual sobre qué alimentos están de temporada: tienen mejor sabor y son más económicos.")
        consejos.add("Probablemente los alimentos que han recorrido menos kilómetros para llegar desde su lugar de origen hasta el supermercado, estén más sabrosos y conserven mejor sus propiedades.")
        consejos.add("Beber agua suficiente para mantenerte hidratado es fundamental para llevar una vida sana. Bebe agua en todas las comidas y entre horas, cuando tengas sed. Una persona adulta sana con una actividad física ligera, no necesita beber agua sin tener sed.")
        consejos.add("Busca el equilibrio entre la energía que ingieres y la que gastas. La alimentación se relaciona de forma muy directa con otros aspectos de tu estilo de vida, por ejemplo, el ejercicio físico.")
        consejos.add("El ejercicio físico nunca falta en los consejos generales sobre cómo llevar una vida sana. Es tan fundamental como la alimentación.")
        consejos.add("Este consejo se hace extrapolable a cualquier actividad sedentaria. El sedentarismo es uno de los grandes enemigos de un estilo de vida saludable.")
        consejos.add("La actitud es básica para mejorar tu calidad de vida y tu salud. Aprende a desarrollar tus fortalezas e incrementa el afecto positivo. Así controlarás el estrés y mejorará tu bienestar.")
        consejos.add("Este tipo de actividad física de baja intensidad, combinada con el ejercicio moderado, también contribuye al equilibrio emocional, al descanso adecuado y, en definitiva, a llevar una vida sana.")
        consejos.add("La actitud es básica para mejorar tu calidad de vida y tu salud. Aprende a desarrollar tus fortalezas e incrementa el afecto positivo. Así controlarás el estrés y mejorará tu bienestar.")
        consejos.add("Un descanso adecuado es básico para la salud. Dormir poco o mal afecta el sistema inmunológico y cognitivo. Para disfrutar de un buen descanso procura ir a la cama siempre a la misma hora y en un entorno tranquilo y sin alteraciones.")
        consejos.add("Los tóxicos presentes en tabaco, alcohol y en la atmósfera de algunas ciudades son uno de los enemigos de la salud pública.")
        consejos.add("El concepto de higiene no sólo se refiere al aseo y limpieza del cuerpo, sino que afecta también al ámbito doméstico y en la cocina.")
        consejos.add("No hace falta coger el bañador o biquini, con abrir la ventana y exponer una parte del cuerpo a la radiación, como cara o escote, es suficiente. Tomar el sol ayuda a sintetizar la vitamina D, mejora la calidad del sueño y el estado de ánimo.")

    }

}