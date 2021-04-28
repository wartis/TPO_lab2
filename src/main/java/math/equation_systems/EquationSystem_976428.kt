package math.equation_systems

import math.logarithms.Ln
import math.logarithms.Log
import math.trigonometry.*
import math.utils.interfaces.Fun
import java.lang.Math.pow
import kotlin.math.pow

open class EquationSystem_976428 : Fun {

    var sec = Sec()
    var sin = Sin()
    var cos = Cos()
    var csc = Csc()
    var tan = Tan()
    var log = Log()
    var ln = Ln()
    var cot = Cot()

    override operator fun invoke(x: Double, precision: Double): Double =
        if (x <= 0) trigPart2(x, precision) else logPart2(x, precision)

    private fun trigPart(x: Double, precision: Double): Double =
        (((((sec(x, precision) - sec(x, precision)) + (sec(x, precision) * sin(x, precision))) * cos(
            x,
            precision
        )) - (sin(x, precision) * csc(x, precision))) / tan(x, precision))

    private fun logPart(x: Double, precision: Double): Double =
        (((((log(x, 2.0, precision) - log(x, 2.0, precision)) + (log(x, 2.0, precision) * log(
            x,
            10.0,
            precision
        ))) * log(x, 3.0, precision)) - (log(x, 3.0, precision) * ln(x, precision))) / log(x, 3.0, precision))

    private fun logPart2(x: Double, precision: Double): Double =
        (((((log(x, 2.0, precision) - ln(x, precision)) / log(x, 10.0, precision)).pow(2)) / ((log(
            x,
            5.0,
            precision
        ) / log(x, 10.0, precision)) - log(x, 5.0, precision))) - log(x, 2.0, precision))

    private fun trigPart2(x: Double, precision: Double): Double =
        (((((((((((((((tan(x, precision) * tan(x, precision) * tan(x, precision)) + tan(x, precision)) - cot(
            x,
            precision
        )) - cos(x, precision)) * tan(x, precision)) - csc(x, precision)) * (cos(x, precision) / (sec(
            x,
            precision
        ) + sin(
            x, precision
        )))) / cos(x, precision)) / cos(x, precision)) / (((sin(x, precision) - csc(x, precision)) + ((sin(
            x,
            precision
        ) / sin(x, precision)) + tan(x, precision))) + (((cot(x, precision) * (sec(x, precision) / sec(
            x,
            precision
        ))) - sec(
            x, precision
        )) + (csc(x, precision) * csc(x, precision) * csc(x, precision))))) - sec(x, precision)) + ((tan(
            x,
            precision
        ) / (sin(x, precision) + (sin(x, precision) / (cos(x, precision) - sin(x, precision))))) - ((((sin(
            x,
            precision
        ) * sin(
            x, precision
        ) * sin(x, precision)) + ((csc(x, precision) * (sec(x, precision) * sec(x, precision) * sec(
            x,
            precision
        ))) + cot(x, precision))) * ((cos(x, precision) + sin(x, precision)) - (sec(x, precision) * (csc(
            x,
            precision
        ) * csc(x, precision) * csc(
            x, precision
        ))))) - (csc(x, precision) * csc(x, precision) * csc(x, precision))))) + ((tan(x, precision) + sin(
            x,
            precision
        )) / (cos(x, precision) * (cos(x, precision) - sec(x, precision))))) * (((csc(x, precision) * cot(
            x,
            precision
        )) / ((sec(
            x, precision
        ) * cos(x, precision)).pow(3.0))) * ((((csc(x, precision) + tan(x, precision)) * (sin(x, precision) * sin(
            x,
            precision
        ))).pow(3.0)) * ((sin(x, precision) * (cot(x, precision) * tan(x, precision))) * sin(
            x, precision
        ))))) + ((tan(x, precision) * tan(x, precision)) * csc(x, precision)))
}




