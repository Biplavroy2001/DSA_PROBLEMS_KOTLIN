fun main() {
    val solution = Solution2402()

    // Example 1
    val n1 = 2
    val meetings1 = arrayOf(
        intArrayOf(0, 10),
        intArrayOf(1, 5),
        intArrayOf(2, 7),
        intArrayOf(3, 4)
    )
    println("Most booked room (Example 1): ${solution.mostBooked(n1, meetings1)}")  // Output: 0

    // Example 2
    val n2 = 3
    val meetings2 = arrayOf(
        intArrayOf(1, 20),
        intArrayOf(2, 10),
        intArrayOf(3, 5),
        intArrayOf(4, 9),
        intArrayOf(6, 8)
    )
    println("Most booked room (Example 2): ${solution.mostBooked(n2, meetings2)}")  // Output: 1
}




class Solution2402 {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val count = IntArray(n)        // Number of meetings in each room
        val busy = LongArray(n)        // When each room becomes free

        meetings.sortBy { it[0] }      // Sort meetings by start time

        for (meeting in meetings) {
            val start = meeting[0]
            val end = meeting[1]
            var earliest = Long.MAX_VALUE
            var roomIndex = -1
            var assigned = false

            for (i in 0 until n) {
                if (busy[i] < earliest) {
                    earliest = busy[i]
                    roomIndex = i
                }
                if (busy[i] <= start) {
                    busy[i] = end.toLong()
                    count[i]++
                    assigned = true
                    break
                }
            }

            if (!assigned) {
                // Delay the meeting to the earliest available room's time
                busy[roomIndex] += (end - start).toLong()
                count[roomIndex]++
            }
        }

        var maxCount = 0
        var resultRoom = 0
        for (i in 0 until n) {
            if (count[i] > maxCount) {
                maxCount = count[i]
                resultRoom = i
            }
        }

        return resultRoom
    }
}
