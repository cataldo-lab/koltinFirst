package com.example.test1

import kotlin.math.log10

data class empleados(val nombre: String, val edad: Int, val sueldo: Double)


fun main(){

    val listaEmpleados = listOf(
        empleados("Juan", 30, 3000.0),
        empleados("Maria", 25, 2500.0),
        empleados("Pedro", 35, 3500.0),
        empleados("Laura", 28, 2800.0),
        empleados("Carlos", 32, 2000.0),
        empleados("Ana", 27, 2700.0),
        empleados("Luis", 31, 3800.0),
        empleados("Sofia", 26, 2600.0),
        empleados("Diego", 33, 3300.0),
        empleados("Julia", 29, 2900.0)
    )

    //Empleados que ganan mas que el promedio
    println("Lista de empleados con mayor sueldo que el promedio")
    val promedio=listaEmpleados.map{it.sueldo}.average()
    val altosSueldo=listaEmpleados.filter{it.sueldo>promedio}

    for(i in altosSueldo){
        println(i)
    }


    //Ordenar empleados edad descendiente

    val empleadosOrdenadosEdad=listaEmpleados.sortedByDescending{it.edad}
    println("\nLista de empleados ordenados por edad descendiente\n")
    empleadosOrdenadosEdad.forEach{println("${it.nombre}: ${it.edad}") }

    val empleadosOrdenadosSueldo=listaEmpleados.sortedByDescending{it.sueldo}
    println("Lista de empleados ordenados por sueldo descendiente\n")
    empleadosOrdenadosSueldo.forEach{println("${it.nombre}: ${it.sueldo}")}


    //Rango de sueldo
    val n=listaEmpleados.size
    val k=(1 + 3.322* log10(n.toDouble())).toInt()


    //Valores limite
    val minSueldo=listaEmpleados.minOf{it.sueldo}
    val maxSueldo=listaEmpleados.maxOf{it.sueldo}
    val R=maxSueldo-minSueldo

    //altura de clase
    val hraw=R/k
    val h=Math.ceil(hraw).toInt()

    val limites=(0..k).map{i->minSueldo +i*h}

    //Crea rangos de sueldo o intervalos de sueldo
    val intervalos: List<ClosedFloatingPointRange<Double>> =
        limites.zipWithNext { a, b -> a..b }

    //Agrupa los empleados por rangos de sueldo
    val agrupados: Map<ClosedFloatingPointRange<Double>, List<empleados>> =
        listaEmpleados.groupBy { emp ->
            intervalos.first { emp.sueldo in it }
        }


    println("\nRangos de sueldo y sus empleados:\n")
    intervalos.forEach { rango ->
        val miembros = agrupados[rango].orEmpty()
        val etiqueta = "[${rango.start.toInt()} - ${rango.endInclusive.toInt()}]"
        val nombres = if (miembros.isEmpty()) "—" else miembros.joinToString { it.nombre }
        println("  \$$etiqueta: $nombres")
    }
}





