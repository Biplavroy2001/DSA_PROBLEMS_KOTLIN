fun main() {
    val solution = Solution3440()
    
    // Example 1
    val eventTime1 = 5
    val startTime1 = intArrayOf(1, 3)
    val endTime1 = intArrayOf(2, 5)
    println("Example 1: ${solution.maxFreeTime(eventTime1, startTime1, endTime1)}") // Expected: 2
    
    // Example 2
    val eventTime2 = 10
    val startTime2 = intArrayOf(0, 7, 9)
    val endTime2 = intArrayOf(1, 8, 10)
    println("Example 2: ${solution.maxFreeTime(eventTime2, startTime2, endTime2)}") // Expected: 7
    
    // Example 3
    val eventTime3 = 10
    val startTime3 = intArrayOf(0, 3, 7, 9)
    val endTime3 = intArrayOf(1, 4, 8, 10)
    println("Example 3: ${solution.maxFreeTime(eventTime3, startTime3, endTime3)}") // Expected: 6
    
    // Example 4
    val eventTime4 = 5
    val startTime4 = intArrayOf(0, 1, 2, 3, 4)
    val endTime4 = intArrayOf(1, 2, 3, 4, 5)
    println("Example 4: ${solution.maxFreeTime(eventTime4, startTime4, endTime4)}") // Expected: 0
    
    // Additional test case with no possible rescheduling
    val eventTime5 = 8
    val startTime5 = intArrayOf(1, 4, 6)
    val endTime5 = intArrayOf(3, 5, 8)
    println("Additional Test: ${solution.maxFreeTime(eventTime5, startTime5, endTime5)}") // Expected: 3
}



class Solution3440 {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        var lastEnd = 0
        val n = startTime.size
        var maxLeft = 0
        var res = 0

        val gaps = IntArray(n + 1)

        for (i in startTime.indices) {
            gaps[i] = startTime[i] - lastEnd
            lastEnd = endTime[i]
        }

        gaps[n] = eventTime - lastEnd

        val maxRight = IntArray(n + 1)
        for (i in n - 1 downTo 0) {
            maxRight[i] = maxOf(maxRight[i + 1], gaps[i + 1])
        }

        for (i in 1..n) {
            val dur = endTime[i - 1] - startTime[i - 1]

            if (maxLeft >= dur || maxRight[i] >= dur) {
                res = maxOf(res, gaps[i - 1] + dur + gaps[i])
            }

            res = maxOf(res, gaps[i - 1] + gaps[i])
            maxLeft = maxOf(maxLeft, gaps[i - 1])
        }

        return res
    }
}