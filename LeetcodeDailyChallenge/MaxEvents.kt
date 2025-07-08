

// 1353. Maximum Number of Events That Can Be Attended


import java.util.*

fun main() {
    val solution = Solutionss()

    // Test Case 1
    val events1 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4)
    )
    println("Test Case 1: ${solution.maxEvents(events1)}") // Expected: 3


}

class Solutionss {
    fun maxEvents(events: Array<IntArray>): Int {
        // Sort events by start day
        events.sortBy { it[0] }
        
        var day = 0
        var index = 0
        var result = 0
        val n = events.size
        val pq = PriorityQueue<Int>()
        
        while (pq.isNotEmpty() || index < n) {
            if (pq.isEmpty()) {
                day = events[index][0]
            }
            
            // Add all events that can be attended on current day
            while (index < n && events[index][0] <= day) {
                pq.offer(events[index][1])
                index++
            }
            
            // Attend the event with earliest end day
            pq.poll()
            result++
            day++
            
            // Remove events that can't be attended anymore
            while (pq.isNotEmpty() && pq.peek() < day) {
                pq.poll()
            }
        }
        
        return result
    }
}