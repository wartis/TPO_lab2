import math.trigonometry.Tan
import math.utils.exception.FunctionNotDefinedException
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.math.PI

class TanTests {
    val tan = Tan()

    companion object {
        val TAN_DEL = 0.001
    }

    @Test
    fun `wrong x values`() {
        assertAll({
            assertThrows<FunctionNotDefinedException> { tan(Double.NaN) }
            assertThrows<FunctionNotDefinedException> { tan(Double.NEGATIVE_INFINITY) }
            assertThrows<FunctionNotDefinedException> { tan(Double.POSITIVE_INFINITY) }
        })
    }

    @Test
    fun `values pi div 2 + pin`() {
        assertAll({
            assertThrows<FunctionNotDefinedException> { tan(PI/2) }
            assertThrows<FunctionNotDefinedException> { tan(PI/2 + PI) }
            assertThrows<FunctionNotDefinedException> { tan(PI/2 + 3 * PI) }
        })
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["tan.csv"])
    fun `x ok values on the interval from 0 to 5,75958`(xValue: Double, yResult: Double) {
        Assert.assertEquals(tan(xValue), yResult, TAN_DEL)
    }
}