import org.junit.Assert.*
import org.junit.Test

class CalculatorTest{

    @Test
    fun calculatorTest() {
        with(Calculator()) {
            assertEquals("Ой", 5.0, calculate(addition, 2.0, 3.0), 0.0)
        }
    }
}