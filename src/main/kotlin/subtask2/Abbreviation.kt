package subtask2

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        if(a.length < b.length) {
            return "NO"
        }

        val matched = mutableListOf<Char>()
        val aUppercase = a.toUpperCase()
        var matcher: Char = b[0]
        var index = 0

        for (element in aUppercase) {
            if (matcher == element) {
                matched.add(matcher)
                index +=1
                if(index >= b.length) {
                    break
                } else {
                    matcher = b[index]
                }
            }
        }

        val matchedString = matched.joinToString("")

        if (b == matchedString) {
            return "YES"
        }
        return "NO"
    }
}
