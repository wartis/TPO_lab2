package math.trigonometry

import math.utils.exception.FunctionNotDefinedException
import math.utils.interfaces.Fun
import math.utils.isSpecial
import kotlin.math.PI
import kotlin.math.abs

open class Sec : Fun {

    var cos = Cos()

    override fun invoke(x: Double, precision: Double): Double {
        if (x.isSpecial()) return x;
        if (abs(x % PI) == PI /2 ) throw FunctionNotDefinedException("not defined in Pi/2*n")

        return 1/cos(x, precision)
    }
}