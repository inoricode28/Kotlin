fun main(args: Array<String>) {
    //VARIABLES
    var curso: String = "Desarrollo de aplicaciones mòviles 1"
    var tema = "Fundamentos de Kotlin"
    var credito: Int = 3
    var precio: Double = 3000.00
    var activo: Boolean = true
    var numeroFloat: Float = 15f
    //CONSTANTES
    val numeroTemas = 14
    var subTemas: String?
    subTemas = "Fundamentos"
    var longitud = subTemas?.length ?: 0
    println("Hello World! $curso")
    //Conversiones
    var semanas = "14"
    var semanasInt = semanas.toInt()
    var precioMensual = "1550.88"
    precio = precioMensual.toDouble()
    //precio = semanasInt.toDouble()
    semanasInt = precio.toInt()
    println(semanasInt)
    //Operadores matemáticos
    val numero1 = 30
    val numero2 = 46
    println("La suma es: ${numero1+numero2}")
    println("La resta es: ${numero1-numero2}")
    println("La multiplicación es: ${numero1*numero2}")
    println("La división es: ${numero1/numero2}")
    validarLogintudNombre("Luis")
    println(validarNumero(25))

}

fun operadoresRelacionales(num1:Int, num2:Int):String{
    var resultado: String
    if((num1 == num2 && num1 > 100) || num1 < 50){
        resultado = "Números iguales"
    }else if(num1 > num2 || num1 > 10){
        resultado = "Número 1 es mayor al 2"
    }else if(!(num1 < num2)){
        resultado = "Número 2 es mayo al 1"
    }else{
        resultado = "Error al comparar"
    }
    return resultado
}
fun validarLogintudNombre(nombre: String){
    when(nombre.length){
        0 -> println("Nombre vacio")
        in 1..4 -> println("Nombre pequeño")
        in 5..7 -> println("Nombre mediano")
        else -> println("Nombre extenso")
    }
}
fun validarNumero(numero: Int): String{
    val resultado = when(numero % 2){
        0 -> "Número par"
        else -> "Número impar"
    }
    return  resultado
}