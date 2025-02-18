import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ParametrizedTest(
    private val firstOperand: Double,
    private val secondOperand: Double,
    private val expectedValue: Double,
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): List<Array<Double>> {
            return listOf(arrayOf(10.0, 20.0, 30.0), arrayOf(-4.0, 7.0, 3.0), arrayOf(0.0, 0.0, 0.0))
        }
    }

    @Test
    fun parameterizedTest() {
        with(Calculator()) {
            assertEquals("Ой", expectedValue, calculate(addition, firstOperand, secondOperand), 0.0)
        }
    }
}

