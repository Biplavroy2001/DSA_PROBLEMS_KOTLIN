
fun main() {
    val solution = Solution3439()

    // Example 1
    val eventTime1 = 5
    val k1 = 1
    val startTime1 = intArrayOf(1, 3)
    val endTime1 = intArrayOf(2, 5)
    println("Output 1: ${solution.maxFreeTime(eventTime1, k1, startTime1, endTime1)}") // Expected: 2

    // Example 2
    val eventTime2 = 10
    val k2 = 1
    val startTime2 = intArrayOf(0, 2, 9)
    val endTime2 = intArrayOf(1, 4, 10)
    println("Output 2: ${solution.maxFreeTime(eventTime2, k2, startTime2, endTime2)}") // Expected: 6

    // Example 3
    val eventTime3 = 5
    val k3 = 2
    val startTime3 = intArrayOf(0, 1, 2, 3, 4)
    val endTime3 = intArrayOf(1, 2, 3, 4, 5)
    println("Output 3: ${solution.maxFreeTime(eventTime3, k3, startTime3, endTime3)}") // Expected: 0
}


class Solution3439 {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size
        var res = 0
        val sum = IntArray(n + 1)

        for (i in 0 until n) {
            sum[i + 1] = sum[i] + (endTime[i] - startTime[i])
        }

        for (i in k - 1 until n) {
            val right = if (i == n - 1) eventTime else startTime[i + 1]
            val left = if (i == k - 1) 0 else endTime[i - k]
            val totalMeetingTime = sum[i + 1] - sum[i - k + 1]
            res = maxOf(res, right - left - totalMeetingTime)
        }

        return res
    }
}
