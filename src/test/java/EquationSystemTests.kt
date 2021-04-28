import math.equation_systems.EquationSystem_976428
import math.utils.exception.FunctionNotDefinedException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import kotlin.math.PI
import kotlin.test.assertEquals


class EquationSystemTests {

    val equationsystem976428 = EquationSystem_976428()

    @Test
    fun `check that equation system returns the right results on x less than 0`() {
        assertAll({
            assertEquals(-10.59254288570428, equationsystem976428(-PI/6, 0.000001))
            assertEquals(-26.335629119847457, equationsystem976428(-PI/4, 0.000001))
            assertThrows<FunctionNotDefinedException> { equationsystem976428(-PI, 0.000001) }
            assertThrows<FunctionNotDefinedException> { equationsystem976428(-PI/2, 0.000001) }
        })
    }

    @Test
    fun `check that equation system returns the right results on x equal 0`() {
        assertThrows<FunctionNotDefinedException> { equationsystem976428(0.0, 0.000001) }
    }

    @Test
    fun `check that equation system returns the right results on x more than 0`() {
        assertAll({
            assertEquals(1.5004257464112327, equationsystem976428(PI/6, 0.000001))
            assertEquals(1.0058199392715048, equationsystem976428(PI/4, 0.000001))
        })
    }
}