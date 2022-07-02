package com.example.androidimpltemplate.kotlin


fun main() {

    doSomething()

}

fun doSomething() {
    println("doSomething start")
    doSomethingElse {
        println("doSomethingElse")
//        return // notice this return
    }
    println("doSomething end")
}

inline fun doSomethingElse(crossinline abc: () -> Unit) {
    abc.invoke()
}