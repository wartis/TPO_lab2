package integration

import math.logarithms.Ln
import math.logarithms.Log
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.test.assertEquals

class LogarithmsTests {

    val lnMock = Mockito.mock(Ln::class.java)

    @Test fun `log integration with ln test`() {
        val log = Log().apply { ln = lnMock }
        Mockito.`when`(lnMock(3.0)).thenReturn(1.0986)
        Mockito.`when`(lnMock(25.0)).thenReturn(3.2189)

        assertEquals(log(3.0, 3.0), 1.0)
        assertEquals(log(25.0, 25.0), 1.0)
    }
}