class Calculator {
    val addition = { a: Double, b: Double -> a + b }
    val subtraction = { a: Double, b: Double -> a - b }
    val multiplication = { a: Double, b: Double -> a * b }
    val division = { a: Double, b: Double ->
        if (b == 0.0) throw UnsupportedOperationException("Division by zero")
        else a / b
    }


    fun calculate(
        lambda: ((Double, Double) -> Double),
        a: Double,
        b: Double,
    ): Double {
        return lambda(a, b)
    }
}
