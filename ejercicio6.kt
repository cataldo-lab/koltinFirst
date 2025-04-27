package com.example.test1
import kotlin.random.Random


fun main() {
    do {
        println("=== MENÚ PRINCIPAL ===")
        println("1. Ingresar números manualmente")
        println("2. Generar números al azar")
        println("3. Salir")
        print("Elige una opción: ")

        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> ingresarNumeros()
            2 -> generarAleatorios()
            3 -> println("Hasta luego 👋")
            else -> {

                println("\nOpción inválida. Inténtalo de nuevo.\n")
            }


        }
    }while(opcion!=3)
}

fun ingresarNumeros() {
    println("Elegiste ingresar números manualmente\n")

    val num1 = pedirNumero("primer")
    val num2 = pedirNumero("segundo")
    val num3 = pedirNumero("tercer")

    verificarNumeros(num1, num2, num3)
}

fun pedirNumero(nombre: String): Int{
    var numero:Int?

    do{
        print("Ingresa el $nombre número: ")
        numero=readLine()?.toIntOrNull()
    }while(numero==null || numero !in 0..100)

    return numero
}


fun generarAleatorios() {
    println("Elegiste generar números al azar\n")

    val num1 = Random.nextInt(1, 101)
    val num2 = Random.nextInt(1, 101)
    val num3 = Random.nextInt(1, 101)

    println("Los números generados son: $num1, $num2, $num3")

    verificarNumeros(num1, num2, num3)


}


fun verificarNumeros(a: Int, b: Int, c: Int){

    if(a>b && b>c){
        println("Los numeros estan ordenados ${a}, ${b}, ${c}, de mayor a menor")
        if(a-1==b && b-1==c){
            println("Los numeros son consecutivos\n")
        }else {
            println("Los numeros no son consecutivos\n")

        }
    }else{


        if(a<b && b<c){
            println("Los numeros estan ordenados ${a}, ${b}, ${c}, de menor a mayor")
            if(a+1==b && b+1==c){
                println("Los numeros son consecutivos\n")
            }else {
                println("Los numeros no son consecutivos\n")
            }
        }else{
            println("Los numeros no estan ordenados\n")

        }




    }


}