import math.trigonometry.Csc
import math.utils.exception.FunctionNotDefinedException
import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.math.PI

class CscTests {

    val csc = Csc()

    companion object {
        val CSC_DEL = 0.001
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["csc.csv"])
    fun `csc on interval from (0) to (pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(csc(xValue), yRes, CSC_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["csc.csv"])
    fun `csc on interval from (pi) to (2 * pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(csc(xValue + PI), -yRes, CSC_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["csc.csv"])
    fun `csc on interval from (2pi) to (3pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(csc(xValue + PI *2), yRes, CSC_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["csc.csv"])
    fun `csc on interval from (-2*pi) to (-pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(csc(xValue - PI), -yRes, CSC_DEL)
    }

    @Test
    fun `csc in undefined points should throw FunctionUndefinedException`() {
        val start = 0

        for (i in -1..2) {
            Assertions.assertThrows(FunctionNotDefinedException::class.java) {
                csc(start + PI *i)
            }
        }
    }
}