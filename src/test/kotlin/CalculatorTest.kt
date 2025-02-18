import org.junit.After
import org.junit.AfterClass
import org.junit.Assert.*
import org.junit.Assume.assumeTrue
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import rules.MyTestRule

@RunWith(JUnit4::class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@FixMethodOrder(MethodSorters.JVM)
//@FixMethodOrder(MethodSorters.DEFAULT)
class CalculatorTest{
//OUTPUT:

//    In @BeforeClass beforeClassMethod()

//    In @TestRule First before Test
//    In @TestRule Second before Test
//    In @TestRule Third before Test
//    In @Before setUp()
//    In @Test calculatorTest1()
//    In @After tearDown()
//    In @TestRule Third after Test
//    In @TestRule Second after Test
//    In @TestRule First after Test

//    In @TestRule First before Test
//    In @TestRule Second before Test
//    In @TestRule Third before Test
//    In @Before setUp()
//    In @Test calculatorTest2()
//    In @After tearDown()
//    In @TestRule Third after Test
//    In @TestRule Second after Test
//    In @TestRule First after Test

//    In @TestRule First before Test
//    In @TestRule Second before Test
//    In @TestRule Third before Test
//    In @Before setUp()
//    In @Test calculatorTest3()
//    In @After tearDown()
//    In @TestRule Third after Test
//    In @TestRule Second after Test
//    In @TestRule First after Test

//    In @AfterClass afterClassMethod()




//    @Rule val rule // WRONG
//    @get:Rule val rule = MyTestRule("First")
//    @Rule lateinit var rule = MyTestRule("First")
//    @Rule @JvmField var rule = MyTestRule("First")

    @JvmField
    @Rule
    val ruleChain : RuleChain = RuleChain
        .outerRule(MyTestRule("First"))
        .around(MyTestRule("Second"))
        .around(MyTestRule("Third"))

    lateinit var calculator : Calculator

    @Before
    fun setUp() {
        calculator = Calculator()
        println("In @Before setUp()")
    }

    @Test(expected = UnsupportedOperationException::class)
    fun calculatorTest2() {
        with(Calculator()) {
            println("In @Test calculatorTest2()")
            assertEquals("Ой", 4.0, calculate(division, 2.0, 0.0), 0.0)
        }
    }

    @Test
    fun calculatorTest1() {
        with(Calculator()) {
            println("In @Test calculatorTest1()")
            assertEquals("Ой", 5.0, calculate(addition, 2.0, 3.0), 0.0)
        }
    }

    @Test
    fun calculatorTest3() {
        with(Calculator()) {
            assumeTrue(true)
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
        fun beforeClassMethod() {
            println("In @BeforeClass beforeClassMethod()")
        }

        @JvmStatic
        @AfterClass
        fun afterClassMethod() {
            println("In @AfterClass afterClassMethod()")
        }
    }
}