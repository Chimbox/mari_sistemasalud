package mx.edu.itson.mari_salud.ui.diccionario

import android.os.Parcel
import android.os.Parcelable

class CategoriaDiccionario : Parcelable{
    var id: Int = 0
    lateinit var nombre:String

    constructor()

    constructor(source: Parcel):this(){
        id=source.readInt()
        nombre= source.readString()!!
    }

    constructor(id: Int, nombre: String) {
        this.id = id
        this.nombre = nombre
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt(id)
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