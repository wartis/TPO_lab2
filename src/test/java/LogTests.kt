import math.logarithms.Log
import math.utils.exception.FunctionNotDefinedException
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

class LogTests {
    val log = Log()

    companion object {
        val LOG_DELTA = 0.001
    }

    @Test
    fun `log for x on the interval from 0 exclusive to 1 inclusive for base eq 2 and 3`() {
        assertAll("x from 0 to 1",
            { Assert.assertEquals(log(0.25, 2.0),-2.0, LOG_DELTA)},
            { Assert.assertEquals(log(0.5, 2.0),-1.0, LOG_DELTA)},
            { Assert.assertEquals(log(0.75, 2.0),-0.415037, LOG_DELTA)},
            { Assert.assertEquals(log(1.0, 2.0),0.0, LOG_DELTA)},
            { Assert.assertEquals(log(0.25, 3.0),-1.261860, LOG_DELTA)},
            { Assert.assertEquals(log(0.5, 3.0),-0.630930, LOG_DELTA)},
            { Assert.assertEquals(log(0.75, 3.0),-0.261859, LOG_DELTA)},
            { Assert.assertEquals(log(1.0, 3.0),0.0, LOG_DELTA)}
        )
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["log.csv"])
    fun `log for x on the interval from 1 exclusive to base pow 5 for base eq 2 and 3`(
        xValue: Double,
        base: Double,
        yResult: Double
    ) {
        Assert.assertEquals(log(xValue, base), yResult, LOG_DELTA)
    }

    @Test
    fun `log for x less or equal zero`() {
        assertAll({
            assertThrows<FunctionNotDefinedException> { log(0.0, 1.0) }
            assertThrows<FunctionNotDefinedException> { log(-1.0, 2.0) }
            assertThrows<FunctionNotDefinedException> { log(-2.0, 3.0) }
            assertThrows<FunctionNotDefinedException> { log(-3.0, 4.0) }
        })
    }

    @Test
    fun `wrong base values`() {
        assertAll({
            assertThrows<FunctionNotDefinedException> { log(12.0, -1.0) }
            assertThrows<FunctionNotDefinedException> { log(1.0, -2.0) }
            assertThrows<FunctionNotDefinedException> { log(2.0, -3.0) }
            assertThrows<FunctionNotDefinedException> { log(3.0, -4.0) }
        })
    }

    @Test
    fun `special x values`() {
        assertAll({
            assertThrows<FunctionNotDefinedException> { log(Double.NaN, 5.0) }
            assertThrows<FunctionNotDefinedException> { log(Double.NEGATIVE_INFINITY, 6.0) }
            assertThrows<FunctionNotDefinedException> { log(Double.POSITIVE_INFINITY, 12314.0) }
        })
    }
}