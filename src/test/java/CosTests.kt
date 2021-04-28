import math.trigonometry.Cos
import math.utils.exception.FunctionNotDefinedException
import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.math.PI

class CosTests {

    val cos = Cos()

    companion object {
        val COS_DEL = 0.001
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["cos.csv"])
    fun `cos on interval from (0) to (2pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(cos(xValue), yRes, COS_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["cos.csv"])
    fun `csc on interval from (2pi) to (4pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(-cos(xValue + 2 * PI), -yRes, COS_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["cos.csv"])
    fun `csc on interval from (4pi) to (6pi)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(cos(xValue + PI *2), yRes, COS_DEL)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["cos.csv"])
    fun `csc on interval from (-2*pi) to (0)`(xValue: Double, yRes: Double) {
        Assert.assertEquals(-cos(xValue - 2 * PI), -yRes, COS_DEL)
    }


}