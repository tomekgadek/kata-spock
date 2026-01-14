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

// usun cyfry - paradygmat funkcyjny
fun removeDigits(word: String): String = word.filterNot { it.isDigit() }

// usun cyfry - wersja iteracyjna
fun removeDigitsIterative(word: String): String {
    val result = StringBuilder()

    for(char in word) {
        if(!char.isDigit()) {
            result.append(char)
        }
    }

    return result.toString()
}


// funkcja, ktora dodaje 'separator' co drugi znak ciagu 'text'
fun insertSeparatorEveryTwoChars(text: String, separator: String): String =
    buildString { // wewnętrznie korzysta z StringBuilder
        text.forEachIndexed { index, ch ->
            append(ch)
            if (index % 2 == 1 && index != text.lastIndex) {
                append(separator)
            }
        }
    }

// funkcja, ktora zamienia co drugi znak (ignorując spacje) na wielką literę, naprzemiennie.
fun toAlternatingCaseWithoutSpaces(input: String): String {
    val builder = StringBuilder()
    var index = 1

    for (ch in input) {
        if (ch != ' ') {
            builder.append(
                if (index % 2 == 0) ch.lowercaseChar() else ch.uppercaseChar()
            )
            index++
        }
    }

    return builder.toString()
}
