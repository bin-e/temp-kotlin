class Solution {
    fun solution(call: String): String {
        var answer: String = ""

        var splitter = 1
//        val pattern = mutableListOf<String>()
        var pattern = mutableMapOf<String, Int>()
        while (splitter < call.length) {
            for (i in 0..call.length step splitter) {
                var counterTemp = 0
                var temp = if (i + splitter >= call.length + 1) continue//call.substring(i, call.length) // 길이 초과
                else call.substring(i, i + splitter)

                for (j in call.indices step splitter) {
                    if (j + splitter > call.length) break
                    if (call.substring(j, j + splitter) == temp) {

                        ++counterTemp
                    }
                }

                if (pattern.containsKey(temp)) continue
                pattern[temp] = counterTemp // add subStrings
            }

            splitter++
        }

        val lastPatterns = mutableListOf<String>()
        pattern.forEach { t, u ->
            if (u >= pattern.values.toList().maxOrNull()!!) lastPatterns.add(t)
        }

        val minCounter = call.length
        lastPatterns.forEach {
            val temp = call.replace(it, "")

            if (temp.length < minCounter) answer = temp
        }

        return answer
    }
}

fun main() {
    val temp = Solution().solution("abcabcdefabc")
    println(temp)
}