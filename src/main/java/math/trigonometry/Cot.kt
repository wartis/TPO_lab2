package math.trigonometry

import math.utils.exception.FunctionNotDefinedException
import math.utils.interfaces.Fun
import math.utils.isSpecial
import kotlin.math.PI
import kotlin.math.abs

open class Cot : Fun {

    var sin = Sin()
    var cos = Cos()

    override fun invoke(x: Double, precision: Double): Double {
        if (x.isSpecial()) throw FunctionNotDefinedException("not defined exception");
        if (abs(x % PI) == 0.0) throw FunctionNotDefinedException("not defined in Pi/2*n")

        return cos(x, precision)/sin(x, precision)
    }
}