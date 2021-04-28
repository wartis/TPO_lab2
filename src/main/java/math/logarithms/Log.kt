package math.logarithms
import math.utils.exception.FunctionNotDefinedException
import math.utils.interfaces.BiFun
import math.utils.isSpecial

open class Log : BiFun {

    var ln = Ln()

    override fun invoke(x: Double, base: Double, precision: Double): Double {
        if (x.isSpecial() || x<=0) throw FunctionNotDefinedException("Function can't accept this value($x)")
        if (base <= 0 || base == 1.0) throw FunctionNotDefinedException("Function can't accept this base($base)")

        return ln(x, precision) / ln(base, precision)
    }

}