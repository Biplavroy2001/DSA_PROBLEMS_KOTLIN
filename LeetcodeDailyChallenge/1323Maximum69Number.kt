class Solution1323{
    fun maximum69Number(num: Int): Int {
        val numStr = num.toString()
        val sb = StringBuilder(numStr)
        for (i in sb.indices) {
            if (sb[i] == '6') {
                sb[i] = '9'
                break
            }
        }
        return sb.toString().toInt()
    }
}

fun main() {
    val solution = Solution1323()
    val testCases = listOf(9669, 9996, 9999, 6, 9, 6666, 6969, 9966)
    
    for (num in testCases) {
        val result = solution.maximum69Number(num)
        println("Input: $num, Output: $result")
    }
}