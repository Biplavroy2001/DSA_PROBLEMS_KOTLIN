// Two Sum Problem (1-leetcode , Array& Hashing - 3 in neetcode.io)
// The Two Sum problem is a classic coding interview question. Here's the problem statement followed by a detailed Kotlin solution with line-by-line explanations.

// Problem Statement (from NeetCode.io)
// Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

// Example 1:
// text
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Example 2:
// text
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
// Example 3:
// text
// Input: nums = [3,3], target = 6
// Output: [0,1]


// Import necessary Kotlin collections
import java.util.HashMap

// Main function that will be executed when the program runs
fun main() {
    // Test case 1
    val nums1 = intArrayOf(2, 7, 11, 15)
    val target1 = 9
    println(twoSum(nums1, target1).contentToString()) // Expected output: [0, 1]
    
    // Test case 2
    val nums2 = intArrayOf(3, 2, 4)
    val target2 = 6
    println(twoSum(nums2, target2).contentToString()) // Expected output: [1, 2]
    
    // Test case 3
    val nums3 = intArrayOf(3, 3)
    val target3 = 6
    println(twoSum(nums3, target3).contentToString()) // Expected output: [0, 1]
}

// Function to solve the Two Sum problem
fun twoSum(nums: IntArray, target: Int): IntArray {
    // Create a HashMap to store numbers and their indices
    // Key: Number from the array
    // Value: Index of that number in the array
    val numMap = HashMap<Int, Int>()
    
    // Iterate through the array with both index and value
    for ((currentIndex, num) in nums.withIndex()) {
        // Calculate the complement (the number we need to find in the map to reach the target)
        val complement = target - num // here complement means remaining
        
        // Check if the complement exists in our HashMap
        if (numMap.containsKey(complement)) {
            // If found, return the indices of the complement and current number
            return intArrayOf(numMap[complement]!!, currentIndex)

            //The !! operator is called the "not-null assertion operator" in Kotlin. 
            //It forcefully converts a nullable type (T?) to a non-null type (T), telling the compiler:
             // "I guarantee this value is not null—crash if it is."
        }
        
        // If complement not found, add the current number and its index to the HashMap
        numMap[num] = currentIndex
    }
    
    // If no solution is found (though problem states there is exactly one solution)
    throw IllegalArgumentException("No two sum solution")
}




// Time and Space Complexity:

// Time: O(n) - We traverse the list once

// Space: O(n) - In worst case, we might store all elements in the HashMap







// Detailed Line-by-Line Explanation
// Let's break down every part of the code:

// Import Statement:

// kotlin
// import java.util.HashMap
// We import Java's HashMap which we'll use to store numbers and their indices for O(1) lookups.

// Main Function:

// kotlin
// fun main() {
// The entry point of our program where we test our solution with example cases.

// Test Cases:

// kotlin
// val nums1 = intArrayOf(2, 7, 11, 15)
// val target1 = 9
// println(twoSum(nums1, target1).contentToString()) // Expected output: [0, 1]
// We create test cases with input arrays and target values.

// intArrayOf creates an integer array in Kotlin.

// contentToString() converts the result array to a readable string for printing.

// twoSum Function Declaration:

// kotlin
// fun twoSum(nums: IntArray, target: Int): IntArray {
// Defines a function that takes:

// nums: An array of integers

// target: The target sum we want to achieve

// Returns an integer array with the two indices.

// HashMap Initialization:

// kotlin
// val numMap = HashMap<Int, Int>()
// Creates a HashMap to store numbers we've seen and their indices.

// Key: Integer value from the array

// Value: Index of that value in the array

// Array Iteration:

// kotlin
// for ((currentIndex, num) in nums.withIndex()) {
// Uses Kotlin's withIndex() to iterate through the array while getting both:

// currentIndex: The current position in the array

// num: The value at that position

// Complement Calculation:

// kotlin
// val complement = target - num
// Calculates the number we need to find in our map to make the current number add up to the target.

// For example, if current number is 2 and target is 9, complement is 7.

// Complement Check:

// kotlin
// if (numMap.containsKey(complement)) {
// Checks if we've already seen the complement number in our HashMap.

// Return Solution:

// kotlin
// return intArrayOf(numMap[complement]!!, currentIndex)
// If complement exists in the map:

// numMap[complement]!! gets the index of the complement (!! asserts it's not null)

// currentIndex is the index of the current number

// Returns an array with these two indices

// Update HashMap:

// kotlin
// numMap[num] = currentIndex
// If we didn't find the complement, we add the current number and its index to the HashMap.

// This ensures we can check for this number as a complement for future numbers.

// No Solution Case:

// kotlin
// throw IllegalArgumentException("No two sum solution")
// Though the problem states there's exactly one solution, we include this for completeness.

// Throws an exception if no solution is found (shouldn't happen per problem constraints).

