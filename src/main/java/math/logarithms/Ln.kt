package math.logarithms

import math.utils.MathConst
import math.utils.exception.FunctionNotDefinedException
import math.utils.interfaces.Fun
import math.utils.isSpecial
import kotlin.math.absoluteValue
import kotlin.math.pow


open class Ln : Fun {
    override fun invoke(x: Double, precision: Double): Double {
        if (x.isSpecial() || x<=0) throw FunctionNotDefinedException("Function can't accept this value($x)");

        val isAbsLessThen1 = (x - 1).absoluteValue <= 1
        val raw = generateSequence(Pair(0.0, 1)) {
            it.first - ((-1.0).pow(it.second) * (x - 1).pow(if (isAbsLessThen1) it.second else -it.second) / it.second) to it.second + 1
        }.takeWhile { precision <= (it.first - precision).absoluteValue && it.second < MathConst.MAX_ITERATIONS }
            .toList()
            .last().first

        return if (isAbsLessThen1) raw else raw + invoke(x - 1)
    }
}