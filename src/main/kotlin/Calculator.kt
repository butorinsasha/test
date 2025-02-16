class Calculator {
    val addition = { a: Double, b: Double -> a + b }

    fun calculate(
        lambda: ((Double, Double) -> Double),
        a: Double,
        b: Double,
    ): Double {
        return lambda(a, b)
    }
}
