import org.assertj.core.api.SoftAssertions
import org.junit.Test

class SoftAssertionsTest {

    @Test
    fun softAssertionsTest() {
        val calculator = Calculator()
        val softAssertions = SoftAssertions()
        with(calculator) {
            softAssertions.assertThat(calculate(division, 4.0, 2.0)).isEqualTo(3.0)         // 1) expected:<[3].0> but was:<[2].0>
            softAssertions.assertThat(calculate(multiplication, 2.0, 3.0)).isEqualTo(6.0)
            softAssertions.assertThat(calculate(addition, 2.0, 3.0)).isEqualTo(7.0)         // 2) expected:<[7].0> but was:<[5].0>
        }
        softAssertions.assertAll()
    }
}