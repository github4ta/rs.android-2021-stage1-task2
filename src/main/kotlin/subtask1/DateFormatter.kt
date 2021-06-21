package subtask1

import java.time.DateTimeException
import java.time.LocalDate

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        var resultTextDay = ""
        val russianMonths = arrayListOf<String>("января", "февраля", "марта", "апреля", "мая", "июня",
            "июля", "августа", "сентября", "октября", "ноября", "декабря")
        val russianDayOfWeek = arrayListOf<String>("понедельник", "вторник", "среда", "четверг",
            "пятница", "суббота", "воскресенье")

        try {
            val dayOfWeek = LocalDate.of(year.toInt(), month.toInt(), day.toInt()).dayOfWeek.value
            resultTextDay = "${day} ${russianMonths[month.toInt() - 1]}, ${russianDayOfWeek[dayOfWeek - 1]}"
        } catch (e: DateTimeException) {
            resultTextDay = "Такого дня не существует"
        }
        return resultTextDay
    }
}
