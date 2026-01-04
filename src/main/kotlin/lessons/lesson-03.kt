package io.github.tomekgadek.lessons

// range operator (zakresy)
fun rangeExamples() {

    val mapRanges = mapOf(
        "1 .. 10" to (1..10),
        "10 downTo 1" to (10 downTo 1),
        "0 until 5" to (0 until 5),
        "0 .. 10 step 3" to (0..10 step 3),
        "0 .. 10 step 5" to (0..10 step 5),
        "9 downTo 0 step 3" to (9 downTo 0 step 3)
    )

    for((name, range) in mapRanges) {
        println("Zakres: $name")

        for(number in range) {     // ← range zawiera liczby!
            print("$number ")
        }
        println("\n...")
    }
}

// jak wyglada definicja funkcji w Kotlin?
fun triangleArea(a: Double, h: Double): Double {
    val area: Double = 0.5 * a * h
    return area
}

// jak zdefiniowac parametry domyslne w sygnaturze funkcji?
fun helloMyFriend(firstName: String = "John", lastName: String = "Doe") {
    println("Hello my friend! $firstName $lastName :)")
}

// expression function (krotka wersja)
fun addOperationExpression(a:Int, b:Int) = a + b

// tradycyjna definicja funkcji
fun addOperationTraditional(a: Int, b: Int): Int {
    return a + b
}

// przeciazanie funkcji point() w jezyku Kotlin
fun point(x:Int) {
    println("Point($x)")
}

fun point(x: Int, y: Int) {
    println("Point2D($x, $y)")
}

fun point(x:Int, y:Int, z:Int) {
    println("Point3D($x, $y, $z)")
}

// suma elementow tablicy, rozwiazanie w stylu C
fun maxFromArrayIteration(digits: Array<Int>): Int {

    var max = digits[0]
    for(digit in digits) {
        if(max < digit) {
            max = digit
        }
    }
    return max
}

// suma elementow tablicy, gotowa funkcja biblioteczna
fun maxFromArrayUsageLibrary(digits: Array<Int>): Int {

    return digits.maxOrNull() ?: 0
}

// suma elementow tablicy, wykorzystanie lambda
fun maxFromArrayUsageLambda(digits: Array<Int>): Int {

    return digits.reduce { acc, it -> if(it > acc) { it } else acc  }
}
