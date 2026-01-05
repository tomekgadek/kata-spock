package io.github.tomekgadek.lessons

import kotlin.math.sqrt

// funkcja, ktora sprawdza czy liczba jest pierwsza
fun isPrime(n: Int): Boolean {
    if(n == 2) {
        return true
    }

    if (n < 2 || n % 2 == 0) {
        return false
    }

    val limit = sqrt(n.toDouble()).toInt()

    for (i in 3..limit step 2) {
        if (n % i == 0) {
            return false
        }
    }

    return true
}
