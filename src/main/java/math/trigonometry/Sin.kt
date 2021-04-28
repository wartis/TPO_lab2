package math.trigonometry


import math.utils.interfaces.Fun
import math.utils.isSpecial
import math.utils.normalize
import kotlin.math.PI

open class Sin : Fun {

    var cos = Cos()

    override fun invoke(x: Double, precision: Double): Double {

        if (x.isSpecial()) return x;

        return -cos(x + PI / 2, precision)
            .normalize(precision)
    }
}