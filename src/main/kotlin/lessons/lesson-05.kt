package io.github.tomekgadek.lessons

// funkcja, ktora testuje operacje na mapach
fun mapTests() {
    // pusta mapa
    //val map = mutableMapOf<String, Int>()

    println("1) Tworzenie mapy z gotowymi elementami key -> value..")
    val map = mutableMapOf("one" to 1, "two" to 2)
    println(map)

    println("2) Dodanie elementu do mapy..")
    map["three"] = 3
    println(map)

    println("3) Wyswietlanie mapy..")
    println(map)

    println("4) Aktualizacja elementu w mapie..")
    map["three"] = 33
    println(map)

    println("5) Usuwanie elementu o zadanym kluczu ('three')..")
    map.remove("three")
    println(map)

    println("6) Pobranie elementu o kluczu 'one' z mapy: ${map["one"]}")
    println("7) Pobranie elmenetu o kluczu, ktory nie istnieje: ${map["three"]}")

    println("8) Dostep do wszystkich kluczy: ${map.keys}");
    println("9) Dostep do wszystkich wartosci: ${map.values}")

    println("10) Wywolanie funkcji 'showElements()'. Argumentem jest mapa 'map'..")
    showElements(map)
}

// funkcja, ktora testuje operacje na listach
fun listTests() {
    // wypelniona lista
    //val names = mutableListOf("Mike", "Tom")

    println("1) Tworzenie pustej listy, ktora przechowuje ciagi tekstowe..")
    val names = mutableListOf<String>()

    println("2) Dodawanie elementow do listy..")
    names.add("Mike")
    names.add("Tom")

    println("3) Wyswietlanie calej listy..")
    println(names)

    println("4) Dodawanie elementu w konkretne miejsce..")
    println("Dodaje element 'Monica' za elementem 'Mike': ")
    names.add(1, "Monica")
    println(names)

    println("5) Usuwam element o idx = 0...")
    names.removeAt(0)
    println(names)

    println("6) Aktualizuje element (nadpisuje 'Alex' za 'Monica'), idx = 0...")
    names[0] = "Alex"
    println(names)

    println("7) Pobieram drugi element z listy: ${names[1]}")

    println("8) Czy lista zawiera imie 'Alex'?: ${names.contains("Alex")}")

    println("9) Wywolanie funkcji 'showElements()'. Argumentem jest lista 'names'..")
    showElements(names)
}

private fun showElements(map: MutableMap<String, Int>) {
    println("Elementy mapy:")
    for ((key, value) in map) {
        println("  klucz: '$key', wartosc: $value")
    }
}

private fun showElements(list: MutableList<String>) {
    println("Elementy listy:")
    for ((index, element) in list.withIndex()) {
        println("  index: $index, element: '$element'")
    }
}
