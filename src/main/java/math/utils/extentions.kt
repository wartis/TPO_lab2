package math.utils

import kotlin.math.absoluteValue

fun Number.isSpecial(): Boolean = this in setOf(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)

fun Double.normalize(accuracy: Double) = if (this.absoluteValue - 0.0 < accuracy) 0.0 else this