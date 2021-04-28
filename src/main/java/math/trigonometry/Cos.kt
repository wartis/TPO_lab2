package math.trigonometry


import math.utils.interfaces.Fun
import math.utils.normalize
import kotlin.math.PI
import kotlin.math.absoluteValue
import kotlin.math.pow

open class Cos : Fun {

    override fun invoke(x: Double, precision: Double): Double {

        val X = x % (2 * PI)

        return generateSequence(Pair(1.0, 1)) {
            it.first * -X.pow(2) / ((2 * it.second - 1) * (2 * it.second)) to it.second + 1
        }.takeWhile {
            it.first.absoluteValue > precision
        }.sumByDouble {
            it.first
        }.normalize(precision)
    }

}