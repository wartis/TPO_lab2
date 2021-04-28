package math.trigonometry

import math.utils.exception.FunctionNotDefinedException
import math.utils.interfaces.Fun
import math.utils.isSpecial
import kotlin.math.PI
import kotlin.math.abs

open class Csc : Fun {
    var sin = Sin()

    override fun invoke(x: Double, precision: Double): Double {
        if (x.isSpecial()) return x;
        if (abs(x % PI) == 0.0 ) throw FunctionNotDefinedException("not defined in pi*n")

        return 1/sin(x, precision)
    }
}