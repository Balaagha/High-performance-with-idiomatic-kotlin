package com.example.androidimpltemplate.kotlin

import kotlin.system.measureTimeMillis


fun main() {
//    val timeList = measureTimeMillis {
//        smallList()
//        println("___________________")
//    }

    val timeSequence = measureTimeMillis {
        smallSequence()
    }

    println("timeList => , timeSequence => $timeSequence")

}


fun smallList() = (0..5)
    .filter { println("list filter($it) "); it % 2 == 0 }
    .map { println("list map($it) "); it * it }
    .first()

fun smallSequence() = (0..5)
    .asSequence()
    .filter { println("seq filter($it) "); it % 2 == 0 }
    .map { println("seq map($it) "); it * it }
    .first()
