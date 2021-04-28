import math.logarithms.Ln
import math.utils.exception.FunctionNotDefinedException
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource


class LnTests {

    val ln = Ln()

    companion object {
        val LN_DELTA = 0.001
    }

    @Test
    fun `ln for x on the interval from 0 exclusive to 1 inclusive`() {
        assertAll("x from 0 to 1",
            {Assert.assertEquals(ln(0.25),-1.386294, LN_DELTA)},
            {Assert.assertEquals(ln(0.5),-0.693147, LN_DELTA)},
            {Assert.assertEquals(ln(0.75),-0.28768, LN_DELTA)},
            {Assert.assertEquals(ln(1.0),0.0, LN_DELTA)}
        )
    }

    @Test
    fun `ln for x on the interval from 1 exclusive to 2,7182818284 exclusive`() {
        assertAll("x from 1 to e",
            {Assert.assertEquals(ln(1.5), 0.4054651081, LN_DELTA)},
            {Assert.assertEquals(ln(2.0), 0.69314, LN_DELTA)},
            {Assert.assertEquals(ln(2.5),0.91629, LN_DELTA)}
        )
    }

    @Test
    fun `ln for x = 2,7182818284`() {
        Assert.assertEquals(ln(2.7182818284), 1.0, LN_DELTA)
    }

    @Test
    fun `ln for x less or equal zero`() {
        assertAll({
            assertThrows<FunctionNotDefinedException> { ln(0.0) }
            assertThrows<FunctionNotDefinedException> { ln(-1.0) }
            assertThrows<FunctionNotDefinedException> { ln(-2.0) }
            assertThrows<FunctionNotDefinedException> { ln(-3.0) }
        })
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["ln.csv"])
    fun `ln for x on the interval from 2,7182818284`(xValue: Double, yResult: Double) {
        Assert.assertEquals(ln(xValue), yResult, LN_DELTA)
    }

    @Test
    fun `special x values`() {
        assertAll({
            assertThrows<FunctionNotDefinedException> { ln(Double.NaN) }
            assertThrows<FunctionNotDefinedException> { ln(Double.NEGATIVE_INFINITY) }
            assertThrows<FunctionNotDefinedException> { ln(Double.POSITIVE_INFINITY) }
        })
    }

}