package integration

import math.equation_systems.EquationSystem_976428
import math.logarithms.Ln
import math.logarithms.Log
import math.trigonometry.*
import org.junit.Assert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.math.E
import kotlin.math.PI
import kotlin.test.assertFailsWith

class EquationSystemTests {
    companion object {
        private val acc = 0.0001
        private val lnMock  = Mockito.mock(Ln::class.java)
        private val logMock = Mockito.mock(Log::class.java)

        private val sinMock = Mockito.mock(Sin::class.java)
        private val cosMock = Mockito.mock(Cos::class.java)
        private val tanMock = Mockito.mock(Tan::class.java)
        private val secMock = Mockito.mock(Sec::class.java)
        private val cscMock = Mockito.mock(Csc::class.java)
        private val cotMock = Mockito.mock(Cot::class.java)

        @BeforeAll
        @JvmStatic
        fun init() {
            Mockito.`when`(sinMock(-PI)).thenReturn(0.0)
            Mockito.`when`(cosMock(-PI)).thenReturn(-1.0)
            Mockito.`when`(tanMock(-PI)).thenReturn(0.0)
            Mockito.`when`(secMock(-PI)).thenReturn(-1.0)
            Mockito.`when`(cscMock(-PI)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(cotMock(-PI)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))

            Mockito.`when`(sinMock(-2.0)).thenReturn(-0.9092974268256817)
            Mockito.`when`(cosMock(-2.0)).thenReturn(-0.4161468365471424)
            Mockito.`when`(tanMock(-2.0)).thenReturn(2.185039863261519)
            Mockito.`when`(secMock(-2.0)).thenReturn(-2.40299796172)
            Mockito.`when`(cscMock(-2.0)).thenReturn(-1.0997501702946164)
            Mockito.`when`(cotMock(-2.0)).thenReturn(0.45765755436028577)

            Mockito.`when`(sinMock(-PI / 2)).thenReturn(-1.0)
            Mockito.`when`(cosMock(-PI / 2)).thenReturn(0.0)
            Mockito.`when`(tanMock(-PI / 2)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(secMock(-PI / 2)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(cscMock(-PI / 2)).thenReturn(-1.0)
            Mockito.`when`(cotMock(-PI / 2)).thenReturn(0.0)

            Mockito.`when`(sinMock(-0.5)).thenReturn(-0.4794255386042)
            Mockito.`when`(cosMock(-0.5)).thenReturn(0.8775825618903728)
            Mockito.`when`(tanMock(-0.5)).thenReturn(-0.5463024898437905)
            Mockito.`when`(secMock(-0.5)).thenReturn(1.13949392732)
            Mockito.`when`(cotMock(-0.5)).thenReturn(-1.830487721712452)
            Mockito.`when`(cscMock(-0.5)).thenReturn(-2.085829642933488)

            Mockito.`when`(sinMock(0.0)).thenReturn(0.0)
            Mockito.`when`(cosMock(0.0)).thenReturn(1.0)
            Mockito.`when`(secMock(0.0)).thenReturn(1.0)
            Mockito.`when`(tanMock(0.0)).thenReturn(0.0)
            Mockito.`when`(cotMock(0.0)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))
            Mockito.`when`(cscMock(0.0)).thenThrow(IllegalArgumentException("Неопределенное значение функции"))

            Mockito.`when`(lnMock(0.5)).thenReturn(-0.6931471805599453)
            Mockito.`when`(lnMock(1.0)).thenReturn(0.0)
            Mockito.`when`(lnMock(2.0)).thenReturn(0.6931471805599453)
            Mockito.`when`(lnMock(E)).thenReturn(1.0)
            Mockito.`when`(lnMock(3.5)).thenReturn(1.252762968495368)
            Mockito.`when`(lnMock(5.0)).thenReturn(1.6094379124341003)

            Mockito.`when`(logMock(0.5, 2.0)).thenReturn(-1.0)
            Mockito.`when`(logMock(1.0, 2.0)).thenReturn(0.0)
            Mockito.`when`(logMock(2.0, 2.0)).thenReturn(1.0)
            Mockito.`when`(logMock(E, 2.0)).thenReturn(1.442695040889)
            Mockito.`when`(logMock(3.5, 2.0)).thenReturn(1.8073549220576042)
            Mockito.`when`(logMock(5.0, 2.0)).thenReturn(2.3219280949)

            Mockito.`when`(logMock(0.5, 5.0)).thenReturn(-0.431)
            Mockito.`when`(logMock(1.0, 5.0)).thenReturn(0.0)
            Mockito.`when`(logMock(2.0, 5.0)).thenReturn(0.431)
            Mockito.`when`(logMock(E, 5.0)).thenReturn(0.621335)
            Mockito.`when`(logMock(3.5, 5.0)).thenReturn(0.778385)
            Mockito.`when`(logMock(5.0, 5.0)).thenReturn(1.0)

            Mockito.`when`(logMock(0.5, 10.0)).thenReturn(-0.3010300)
            Mockito.`when`(logMock(1.0, 10.0)).thenReturn(0.0)
            Mockito.`when`(logMock(2.0, 10.0)).thenReturn(0.3010300)
            Mockito.`when`(logMock(E, 10.0)).thenReturn(0.4342942)
            Mockito.`when`(logMock(3.5, 10.0)).thenReturn(0.5440680)
            Mockito.`when`(logMock(5.0, 10.0)).thenReturn(0.6989700)
        }
    }

    @Test
    fun `equationSystem(x) test`() {
        val systemFunction = EquationSystem_976428().apply{
            sin = sinMock
            cos = cosMock
            tan = tanMock
            sec = secMock
            csc = cscMock
            cot = cotMock
            log = logMock
        }

        Assertions.assertAll(
            { assertFailsWith<IllegalArgumentException> { systemFunction(-PI/2) } },
            { assertFailsWith<IllegalArgumentException> { systemFunction(-PI) } },
            { assertFailsWith<IllegalArgumentException> { systemFunction(0.0) } },
            { Assertions.assertEquals(-26.489180328105164, systemFunction(-2.0), acc) },
            { Assertions.assertEquals(-10.056969018279434, systemFunction(-0.5), acc) },
            { Assert.assertEquals(Double.NaN, systemFunction(1.0), acc) },
            { Assert.assertEquals(0.03828377282920448, systemFunction(2.0), acc) },
            { Assert.assertEquals(-0.15886115349235563, systemFunction(E), acc) },
            { Assert.assertEquals(-0.2144149418182082, systemFunction(3.5), acc) },
            { Assert.assertEquals(0.09069823894497508, systemFunction(5.0), acc) },
        )
    }
}