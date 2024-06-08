package pe.edu.idat.appdemoclasic

import android.util.Log

class Fundamentos {

    var nombres = "Luis Angel"
    var apellidos = "Salvatierra Aquino"
    var edad: Int = 28
    var altura: Double = 1.65
    var activo: Boolean = true
    var color: Float = 4.5f

    fun imprimir(mensaje:String){
        Log.i("Imprimir", mensaje)
    }
    fun operacion(numero1: Int, numero2:Int,
                  operador:String): String{
        //var resultado = 0
        var resultado = if(operador == "+"){
            numero1 + numero2
        }else if(operador == "-"){
            numero1 - numero2
        } else if(operador == "/"){
            numero1 / numero2
        } else if(operador == "*"){
            numero1 * numero2
        }else {
            0
        }
        return "Resultado Final $resultado"
    }

    fun validarNumero(numero: Int): String{
        return when(numero % 2){
            0 -> "Número par"
            else -> "Número impar"
        }
    }



}