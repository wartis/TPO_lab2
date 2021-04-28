package math.utils.interfaces

import math.utils.MathConst

interface Fun {
    operator fun invoke(x: Double, precision: Double = MathConst.PRECISION) : Double
}