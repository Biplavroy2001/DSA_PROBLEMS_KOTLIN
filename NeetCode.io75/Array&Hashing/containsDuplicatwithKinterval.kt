
//219. Contains Duplicate II NOTE: sliding window approach is the most optimized one, follow that


fun main() {
   
    val nums = intArrayOf(1,2,3,1,1)
    val k = 3
    println(containsNearbyDuplicate(nums, k))
}



fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    // Create a map to store the last seen index of each value
    val lastSeen = mutableMapOf<Int, Int>()
    
    // Iterate through the array with both index and value
    nums.forEachIndexed { index, num ->
        // Check if we've seen this number before
        lastSeen[num]?.let { prevIndex ->
            // If the distance between current and previous index is <= k, return true
            if (index - prevIndex <= k) return true
        }
        // Update the map with the current index for this number
        lastSeen[num] = index
    }
    // If we finish the loop without finding any valid duplicates
    return false
}






// The problem requires finding if there are any duplicate values within a certain index distance k in the array. The solution uses a HashMap to efficiently track and check these distances.

// Detailed Step-by-Step Approach
// 1. Initialization
// kotlin
// val lastSeen = mutableMapOf<Int, Int>()
// Purpose: Creates a mapping from array values to their most recent indices

// Why HashMap?: Provides O(1) average time complexity for both insertions and lookups

// Structure:

// Key: The integer value from the array

// Value: The last index where this value appeared

// 2. Array Traversal
// kotlin
// nums.forEachIndexed { index, num ->
// Iteration: Goes through each element in the array with both its index and value

// Advantage: More idiomatic Kotlin than traditional for-loops

// Efficiency: Single pass through array → O(n) time complexity

// 3. Duplicate Check
// kotlin
// lastSeen[num]?.let { prevIndex ->
// Safe Call Operator (?.): Handles the case where the number hasn't been seen before

// let Scope Function: Only executes the block if the number exists in the map

// prevIndex: Contains the previous index where this number appeared

// 4. Distance Validation
// kotlin
// if (index - prevIndex <= k) return true
// Calculation: Computes the distance between current and previous occurrence

// Comparison: Checks if the distance satisfies the problem's condition (≤ k)

// Early Termination: Returns immediately when a valid pair is found

// 5. Map Update
// kotlin
// lastSeen[num] = index
// Purpose: Updates the last seen index for the current number

// Behavior:

// If new number: Creates a new entry

// If existing number: Overwrites with current (more recent) index

// Critical Point: Always updates to the latest index to ensure we're checking the minimal possible distances

// 6. Final Return
// kotlin
// return false
// Condition: Reached only if no valid duplicates were found

// Position: After complete array traversal

// Key Optimizations
// Single Pass Algorithm: Processes the array in one loop

// HashMap Efficiency: Leverages O(1) average case operations

// Early Termination: Returns immediately upon finding a valid pair

// Index Tracking: Only needs to remember the most recent index for each value

