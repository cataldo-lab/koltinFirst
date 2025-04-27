package com.example.test1

fun main(){

    val num1:Int= 1
    val num2:Int= 1

    fibonacci(num1,num2)
}

fun fibonacci( num1: Int, num2: Int) {
    var num1=num1
    var num2=num2
    var num3:Int
    var lista= mutableListOf<Int>()

    lista.add(num1)
    lista.add(num2)




    for(i in 1..13){
        num3=num1+num2
        lista.add(num3)
        num1=num2
        num2=num3

    }

    for (i in lista){
        println(i)
    }
}
