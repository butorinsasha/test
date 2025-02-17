import org.junit.After
import org.junit.AfterClass
import org.junit.Assert.*
import org.junit.Assume.assumeTrue
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CalculatorTest{

    lateinit var calculator : Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
        println("In @Before setUp()")
    }

    @Test
    fun calculatorTest1() {
        with(Calculator()) {
            println("In @Test calculatorTest1()")
            assertEquals("Ой", 5.0, calculate(addition, 2.0, 3.0), 0.0)
        }
    }

    @Test(expected = UnsupportedOperationException::class)
    fun calculatorTest2() {
        with(Calculator()) {
            println("In @Test calculatorTest2()")
            assertEquals("Ой", 4.0, calculate(division, 2.0, 0.0), 0.0)
        }
    }

    @Test
    fun calculatorTest3() {
        with(Calculator()) {
            assumeTrue(false)
            println("In @Test calculatorTest3()")
            assertEquals("Ой", 3.0, calculate(addition, 1.0, 2.0), 0.0)
        }
    }

    @After
    fun tearDown() {
        println("In @After tearDown()")
    }

    companion object {
        @JvmStatic
        @BeforeClass
        fun beforeClassMethod(): Unit {
            println("In @BeforeClass beforeClassMethod()")
        }

        @JvmStatic
        @AfterClass
        fun afterClassMethod(): Unit {
            println("In @AfterClass afterClassMethod()")
        }
    }
}