import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test

class AssertionsTest {

    private val calculator = Calculator()

    @Test
    fun calculatorAssertEqualsTest() {
        with(calculator) {
            assertEquals("Ой", 5.0, calculate(addition, 2.0, 3.0), 0.0)
        }
    }

    @Test
    fun calculatorAssertTrueTest() {
        with(calculator) {
            assertTrue("Ой", calculate(addition, 2.0, 3.0) == 5.0)
        }
    }

    @Test
    fun calculatorAssertTrowsTest() {
        with(calculator) {
            assertThrows(UnsupportedOperationException::class.java) {calculate(division, 1.0, 0.0)}
        }
    }
}