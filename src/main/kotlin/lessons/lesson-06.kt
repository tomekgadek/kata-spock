package io.github.tomekgadek.lessons

class Car(private val mark: String, var color: String) {
    private var speed = 0
    private var engineStarted = false

    fun engineStart() {
        this.speed = 0
        this.engineStarted = true
    }

    fun engineStop() {
        speed = 0
        this.engineStarted = false
    }

    // metoda prywatna
    private fun incSpeed(speed: Int) {
        this.speed += speed
    }

    // metoda publiczna
    fun run(speed: Int = 10) {
        if (engineStarted) {
            this.incSpeed(speed) // wywolanie prywatnej metody
        }
    }

    // metoda publiczna
    fun checkSpeed(): Int {
        return this.speed
    }


    override fun toString(): String {
        return "${this.mark} (${this.color})"
    }
}

fun carTests() {

    // tworzenie obiektu, czyli konkretnego pojazdu
    val audi = Car("Audi", "SILVER")

    audi.color = "RED" // public - ok, dostep publiczny
    //audi.speed = 200 // private - blad, dostep prywatny

    audi.engineStart()

    // dostep do metody publicznej: [nazwa obiektu].[wywolanie metody]
    println("$audi ma na liczniku ${audi.checkSpeed()} km/h")
    println("$audi przyspiesza...")

    audi.run() // przyspiesza...
    audi.run() // przyspiesza...
    audi.run() // nadal przyspiesza...

    println("$audi ma na liczniku ${audi.checkSpeed()} km/h")
    audi.engineStop()
}
