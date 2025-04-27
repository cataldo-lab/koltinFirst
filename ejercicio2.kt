package com.example.test1

abstract class vehiculo {
    abstract fun mover()
    abstract fun detenerse()
}

class autos : vehiculo() {
    override fun mover() {
        println("El auto se esta moviendo")
    }
    override fun detenerse() {
        println("El auto se detuvo")
    }
}

class camiones : vehiculo() {
    override fun mover() {
        println("El camion se esta moviendo")
    }
    override fun detenerse() {
        println("El camion se detuvo")
    }
} // ← aquí faltaba cerrar camiones

class motos : vehiculo() {
    override fun mover() {
        println("La moto se esta moviendo")
    }
    override fun detenerse() {
        println("La moto se detuvo")
    }
} // ← y aquí cerrar motos


fun main() {
    println("Menu, seleccione su vehiculo")
    println("1. Autos")
    println("2. Camiones")
    println("3. Motos")
    val opcion = readLine()?.toIntOrNull()

    when (opcion) {
        1 -> {
            println("Has seleccionado autos")
            seleccion()
            val opcion2 = readLine()?.toIntOrNull()
            val auto = autos()
            when (opcion2) {
                1 -> {
                    auto.mover()
                }
                2 -> {
                    auto.detenerse()
                }
                else -> println("Opcion invalida")
            }
        }
        2 -> {
            println("Has seleccionado camiones")
            seleccion()
            val opcion2 = readLine()?.toIntOrNull()
            val camion = camiones()
            when (opcion2) {
                1 -> {
                    camion.mover()
                }
                2 -> {
                    camion.detenerse()
                }
                else -> println("Opcion invalida")
            }
        }
        3 -> {
            println("Has seleccionado motos")
            seleccion()
            val opcion2 = readLine()?.toIntOrNull()
            val moto = motos()
            when (opcion2) {
                1 -> {

                    moto.mover()
                }
                2 -> {

                    moto.detenerse()
                }
                else -> println("Opcion invalida")
            }
        }
        else -> println("Opcion invalida")
    }
}


fun seleccion(){
    println("Que desea hacer?")
    println("1. Moverse")
    println("2. Detenerse")
}



