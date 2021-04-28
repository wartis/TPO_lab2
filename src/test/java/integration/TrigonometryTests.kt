package integration

import math.trigonometry.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import kotlin.math.PI
import kotlin.test.assertEquals

class TrigonometryTests {
    val cosMock = Mockito.mock(Cos::class.java)
    val sinMock = Mockito.mock(Sin::class.java)

    @Test fun `sin integration with cos test`() {
        val sin = Sin().apply { cos = cosMock }
        Mockito.`when`(cosMock(0.0)).thenReturn(1.0)
        assertEquals(-1.0, sin(-PI / 2))
    }

    @Test fun `tan integration with cos and sin test`() {
        val tan = Tan().apply {
            cos = cosMock
            sin = sinMock
        }
        Mockito.`when`(cosMock(PI)).thenReturn(-1.0)
        Mockito.`when`(sinMock(PI)).thenReturn(0.0)
        assertEquals(-0.0, tan(PI))
    }

    @Test fun `sec integration with cos test`() {
        val sec = Sec().apply { cos = cosMock }
        Mockito.`when`(cosMock(PI)).thenReturn(-1.0)
        assertEquals(-1.0, sec(PI))
    }

    @Test fun `csc integration with sin test`() {
        val csc = Csc().apply { sin = sinMock }
        Mockito.`when`(sinMock(PI/2)).thenReturn(1.0)
        assertEquals(1.0, csc(PI/2))
    }
}