package pe.edu.idat.appcomponentsadvanced.model

import androidx.annotation.DrawableRes

data class Mascota(
    var nombre: String,
    var raza: String,
    var anios: Int,
    @DrawableRes var imagen: Int
)
