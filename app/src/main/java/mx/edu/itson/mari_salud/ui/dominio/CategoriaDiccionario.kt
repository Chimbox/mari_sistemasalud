package mx.edu.itson.mari_salud.ui.dominio

import android.os.Parcel
import android.os.Parcelable

class CategoriaDiccionario : Parcelable{
    lateinit var nombre:String

    constructor()

    constructor(source: Parcel):this(){
        nombre= source.readString()!!
    }

    constructor(nombre: String) {
        this.nombre = nombre
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeString(nombre)
    }

    companion object CREATOR : Parcelable.Creator<CategoriaDiccionario>{
        override fun createFromParcel(p0: Parcel): CategoriaDiccionario {
            return CategoriaDiccionario(p0)
        }

        override fun newArray(p0: Int): Array<CategoriaDiccionario?> {
            return arrayOfNulls(p0)
        }
    }
}