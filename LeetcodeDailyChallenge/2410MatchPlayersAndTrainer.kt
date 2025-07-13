
fun main() {
    val solution = Solution2410()
    
    // Test Case 1
    val players1 = intArrayOf(4, 7, 9)
    val trainers1 = intArrayOf(8, 2, 5, 8)
    println(solution.matchPlayersAndTrainers(players1, trainers1)) // Expected: 2

    // Test Case 2
    val players2 = intArrayOf(1, 1, 1)
    val trainers2 = intArrayOf(10)
    println(solution.matchPlayersAndTrainers(players2, trainers2)) // Expected: 1

    // Test Case 3 (All players can be matched)
    val players3 = intArrayOf(2, 3, 5)
    val trainers3 = intArrayOf(3, 5, 6)
    println(solution.matchPlayersAndTrainers(players3, trainers3)) // Expected: 3

    // Test Case 4 (No matches possible)
    val players4 = intArrayOf(10, 20, 30)
    val trainers4 = intArrayOf(5, 5, 5)
    println(solution.matchPlayersAndTrainers(players4, trainers4)) // Expected: 0
}

class Solution2410 {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        players.sort()
        trainers.sort()
        
        var count = 0
        var i = 0 // pointer for players
        var j = 0 // pointer for trainers
        
        while (i < players.size && j < trainers.size) {
            if (players[i] <= trainers[j]) {
                // Match found, move both pointers
                count++
                i++
                j++
            } else {
                // Current trainer can't train this player, try next trainer
                j++
            }
        }
        return count
    }
}