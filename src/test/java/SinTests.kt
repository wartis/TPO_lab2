import math.trigonometry.Sin
import org.junit.Assert
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.math.PI

class SinTests {

    val sin = Sin()

    companion object {
        val SIN_DEL = 0.001
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["sin.csv"])
    fun `sin on interval from (0) to (2pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(sin(xValue), yRes, SIN_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["sin.csv"])
    fun `sin on interval from (2pi) to (4pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(-sin(xValue + 2 * PI), -yRes, SIN_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["sin.csv"])
    fun `sin on interval from (4pi) to (6pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(sin(xValue + PI *2), yRes, SIN_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["sin.csv"])
    fun `sin on interval from (-2*pi) to (0)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(-sin(xValue - 2 * PI), -yRes, SIN_DEL)
    }


}