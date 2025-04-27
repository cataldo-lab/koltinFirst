package com.example.test1
import java.time.DateTimeException
import java.time.LocalDate


fun main(){

    print("Ingresa tu fecha de nacimiento (dd/mm/yyyy): ")
    val fecha = readLine() ?: return

    val partes = fecha.split("/")

    if (partes.size != 3) {
        println("Formato de fecha incorrecto. Debe ser dd/mm/yyyy.")
        return
    }

    val dia = partes[0].toIntOrNull()
    val mes = partes[1].toIntOrNull()
    val anio = partes[2].toIntOrNull()



    if (dia == null || mes == null  || anio == null || mes !in 1..12 || anio <0 || dia <=0 ||mes<=0) {
        println("La fecha ingresada no es válida.")
        return
    }


    try {
        // Intenta construir la fecha real
        LocalDate.of(anio, mes, dia)
        numerologia(dia, mes, anio)
    } catch (e: DateTimeException) {
        println("La fecha ingresada no existe en el calendario.")
    }

}

fun numerologia(dia: Int, mes: Int, anio: Int){



    val numero=dia+mes+anio
    val unidad=numero%10
    val decena=(numero/10)%10
    val centena=(numero/100)%10
    val unidadMil= (numero/1000)%10

    val fechaNumero=unidad+decena+centena+unidadMil




    if (fechaNumero<10){
        println("Tu fecha numerológica es: $fechaNumero")
    }else{
        var num=fechaNumero

        while(contarDigitos(num)>1){
            var sumaParcial:Int=0
            var temp=num

            while (temp > 0) {
                sumaParcial += temp % 10
                temp /= 10
            }
            //Aqui con cada division disminute
            //Hasta que un punto es cero

            num=sumaParcial


        }
        println("Tu fecha numerológica es: $num")
    }
}


fun contarDigitos(numero:Int):Int{
    return numero.toString().length
}

