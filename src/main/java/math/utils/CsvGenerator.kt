package math.utils

import math.trigonometry.Sin
import math.utils.interfaces.Fun
import java.io.File
import java.io.FileWriter

class CsvGenerator : AutoCloseable{
    private lateinit var fileWriter: FileWriter

    fun write(filename: String, function: Fun, start: Double, end: Double, stepBy: Double) {
        val file = File(filename)
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw IllegalArgumentException("Не удалось создать файл по указанному пути")
            }
        }
        fileWriter = FileWriter(file)

        fileWriter.write("X,Y\n")

        var cur = start
        while (cur < end) {
            try {
                val res = function(cur)
                fileWriter.write("$cur,$res\n")
            } catch(e: Exception) {
                fileWriter.write("$cur,exception\n")
            }
            cur += stepBy
        }
        fileWriter.flush()
    }


    override fun close() {
        fileWriter.close()
    }
}

fun main() {
    val csvGen = CsvGenerator()
    csvGen.write("./sin.csv", Sin(), -2.0, 2.0, 0.1)
//    csvGen.write("./ln.csv", Ln(acc), 0.1, 3.0, 0.1)
//    csvGen.write("./system.csv", SystemFunction(acc), -2.0, 2.0, 0.1)
}