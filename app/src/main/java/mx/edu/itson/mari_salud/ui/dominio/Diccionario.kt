package mx.edu.itson.mari_salud.ui.dominio

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Diccionario(
    var titulo: String,
    var secciones: ArrayList<SeccionDiccionario>,
    var categoria: CategoriaDiccionario
):Parcelable

