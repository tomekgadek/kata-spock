package io.github.tomekgadek.lessons

fun countCharacters() {
    print("Podaj text: ")
    val text = readlnOrNull()

    val counter = text?.chars()?.count() // "?." to bezpieczne wywolanie. Wywola metode, gdy obiekt nie jest null

    println("'$text' posiada $counter znakow.")
}

fun sumDigits() {
    try {
        print("Podaj a: ")
        val a = readlnOrNull()
        print("Podaj b: ")
        val b = readlnOrNull()

        val aInt = (a ?: "0").toInt() // elvis operator ?:
        val bInt = (b ?: "0").toInt() // elvis operator ?:

        println("$aInt + $bInt = ${aInt + bInt}") // interpolacja = ${}
    } catch(exception: NumberFormatException) {
        println("Kolego! Mialy byc same liczby!")
    }

    println("Koniec...")
}