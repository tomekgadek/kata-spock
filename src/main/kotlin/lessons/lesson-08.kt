package io.github.tomekgadek.lessons

// object to pojedynczy singletonowy obiekt, nie ma potrzeby jawnego tworzenia instancji
internal object MathOperation {

    fun add(first: Int, second: Int): Int {
        return first + second
    }
}

// klasa to szablon dla wielu instancji, za każdym razem tworzona jest nowa instancja
internal class SimpleTests {

    fun testAddition() {
        // Arrange
        val firstNumber = 1
        val secondNumber = 2

        // Act
        val result = MathOperation.add(firstNumber, secondNumber)

        // Assert
        assert(result == 3) { "add(1, 2) should return 3?" }
    }
}

// AAA - Arrange Act Assert (perspektywa techniczna)
// GWT - Given When Then (perspektywa biznesowa)
fun runAllTests() {
    SimpleTests().testAddition()

    println("All tests passed!")
}