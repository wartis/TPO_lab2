package math.trigonometry

import math.utils.exception.FunctionNotDefinedException
import math.utils.interfaces.Fun
import math.utils.isSpecial
import kotlin.math.PI
import kotlin.math.abs

open class Tan : Fun {

    var sin = Sin()
    var cos = Cos()

    override fun invoke(x: Double, precision: Double): Double {
        if (x.isSpecial()) throw FunctionNotDefinedException("not defined exception");
        if (abs(x % PI) == PI/2 ) throw FunctionNotDefinedException("not defined in Pi/2*n")

        return sin(x, precision)/cos(x, precision)
    }
}