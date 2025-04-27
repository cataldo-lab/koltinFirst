package com.example.test1

fun String.NumeroVocales():Int{
    val vocales= setOf(
        'a','e','i','o','u',
        'A','E','I','O','U',
        'á','é','í','ó','ú',
        'Á','É','Í','Ó','Ú',
        'â','ê','î','ô','û',
        'Â','Ê','Î','Ô','Û',
        'à','è','ì','ò','ù',
        'À','È','Ì','Ò','Ù',
        'ä','ë','ï','ö',
        'Ä','Ë','Ï','Ö',
        'ü','Ü'
    )

    return this.count{it in vocales}
}




fun Int.toSpeakWords():Unit{
    if (this == 0) {
        println("cero")
        return
    }
    require(this in 0..999) { "Solo números entre 0 y 999" }

    val unidades = listOf(
        "", "uno", "dos", "tres", "cuatro", "cinco",
        "seis", "siete", "ocho", "nueve"
    )
    val especiales = mapOf(
        10 to "diez", 11 to "once", 12 to "doce", 13 to "trece",
        14 to "catorce", 15 to "quince", 20 to "veinte", 100 to "cien"
    )
    val decenas = mapOf(
        2 to "veinti", 3 to "treinta", 4 to "cuarenta",
        5 to "cincuenta", 6 to "sesenta", 7 to "setenta",
        8 to "ochenta", 9 to "noventa"
    )
    val centenas = mapOf(
        1 to "ciento", 2 to "doscientos", 3 to "trescientos",
        4 to "cuatrocientos", 5 to "quinientos", 6 to "seiscientos",
        7 to "setecientos", 8 to "ochocientos", 9 to "novecientos"
    )

    val c = this / 100
    val rem = this % 100
    val d = rem / 10
    val u = rem % 10

    val sb = StringBuilder()

    // Centenas
    if (c > 0) {
        sb.append(
            if (c == 1 && rem == 0) especiales[100]!!
            else centenas[c]
        )
        if (rem > 0) sb.append(" ")
    }

    // Decenas y unidades
    when {
        rem in especiales -> sb.append(especiales[rem])
        rem in 16..19    -> sb.append("dieci").append(unidades[u])
        rem in 21..29    -> sb.append("veinti").append(unidades[u])
        d >= 3           -> {
            sb.append(decenas[d])
            if (u > 0) sb.append(" y ").append(unidades[u])
        }
        else             -> { // 1–9 o 10–15 o 20
            sb.append(unidades[rem].takeIf { it.isNotEmpty() } ?: especiales[rem])
        }
    }

    println(sb.toString().trim())
}

fun main(){
    println("Ingrese una palabra o frase, seran contadas las vocales")
    val texto=readLine().toString()
    val numVocales=texto.NumeroVocales()


    numVocales.toSpeakWords()
}
