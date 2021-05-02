package mx.edu.itson.mari_salud.ui.diccionario

import android.os.Parcel
import android.os.Parcelable

class SeccionDiccionario : Parcelable{
    lateinit var titulo:String
    lateinit var contenido:String

    constructor()

    constructor(source: Parcel):this(){
        titulo=source.readString()!!
        contenido=source.readString()!!
    }

    constructor(titulo: String, contenido: String) {
        this.titulo = titulo
        this.contenido = contenido
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(titulo)
        p0?.writeString(contenido)
    }

    companion object CREATOR : Parcelable.Creator<SeccionDiccionario>{
        override fun createFromParcel(p0: Parcel): SeccionDiccionario {
            return SeccionDiccionario(p0)
        }

        override fun newArray(p0: Int): Array<SeccionDiccionario?> {
            return arrayOfNulls(p0)
        }
    }
}