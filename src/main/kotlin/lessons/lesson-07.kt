package io.github.tomekgadek.lessons

// silnia - wersja rekurencyjna
fun factorialRecursion(a: Int): Int =
    if(a <= 1) 1 else a * factorialRecursion(a - 1)

// silnia - wersja iteracyjna
fun factorialIterative(a: Int): Int {
    var result = 1

    for (i in 1..a) {
        result *= i
    }

    return result
}