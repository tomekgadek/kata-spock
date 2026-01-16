package io.github.tomekgadek.lessons

class AssertionLibrary {
    private var totalTests = 0
    private val failures = mutableListOf<String>()

    fun assertTrue(condition: Boolean) {
        totalTests++
        if (!condition) {
            failures.add("Expected 'true', but got 'false'")
        }
    }

    fun assertFalse(condition: Boolean) {
        totalTests++
        if (condition) {
            failures.add("Expected 'false', but got 'true'")
        }
    }

    fun assertEquals(expected: Any?, actual: Any?) {
        totalTests++
        if (expected != actual) {
            failures.add("Expected: <$expected>, but was: <$actual>")
        }
    }

    fun printAssertionResults() {

        println("--- Test Results ---")
        if (failures.isEmpty()) {
            println("✅ Success! All $totalTests assertions passed.")
        } else {
            println("❌ Finished with ${failures.size} failure(s) out of $totalTests tests.")
            failures.forEachIndexed { index, failure ->
                println("   ${index + 1}. $failure")
            }
        }
        println("--------------------")
    }
}