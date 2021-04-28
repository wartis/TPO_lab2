package math.utils.interfaces

import math.utils.MathConst


interface BiFun {
    operator fun invoke(x: Double, base: Double, precision: Double = MathConst.PRECISION) : Double
}
