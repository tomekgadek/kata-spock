package io.github.tomekgadek.lessons

// expression function "=", cialo funkcji to pojedyncze wyrazenie
fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")) { // regex z transformacja (znajduje wszystkie samogloski)
        when(it.value) { // destrukturyzacja ("it" to jest parametr lambdy), it.value = samogloska
            "a", "A" -> "4"
            "e", "E" -> "3"
            "i", "I" -> "1"
            "o", "O" -> "0"
            "u", "U" -> "|_|"
            else -> it.value
        }
    }
