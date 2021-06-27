package subtask3

import java.time.LocalDate
import java.time.format.DateTimeParseException
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        val result = mutableListOf<Any>()

        when (blockB) {
            String::class -> {
                for (i in blockA.indices) {
                    if ((blockA[i] as? String) != null) {
                        blockA[i]?.let { result.add(it) }
                    }
                }
                return result.joinToString("") { it.toString() }
            }

            Int::class -> {
                for (i in blockA.indices) {
                    if ((blockA[i] as? Int) != null) {
                        blockA[i]?.let { result.add(it) }
                    }
                }
                return result.sumBy { it.toString().toInt() }
            }

            LocalDate::class -> {
                for (i in blockA.indices) {
                    if ((blockA[i] as? LocalDate) != null) {
                        blockA[i]?.let { result.add(it) }
                    }
                }

                val resultDate = mutableListOf<LocalDate>()
                for (i in 0 until result.size) {
                    val date = result[i].toString()
                    try {
                        resultDate.add(LocalDate.parse(date))
                    } catch (e: DateTimeParseException){
                        throw NotImplementedError("Date is not correct")
                    }
                }
                val maxDate = resultDate.max()
                return "${maxDate?.dayOfMonth}.${maxDate?.monthValue}.${maxDate?.year}"
            }

            else -> {
                throw NotImplementedError("KClass<> is not Int or String, or LocalDate")
            }
        }
    }
}