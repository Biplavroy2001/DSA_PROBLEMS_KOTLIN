class Solution1957 {
    fun makeFancyString(s: String): String {
        if (s.length < 3) return s
        
        val chars = s.toCharArray()
        var last = chars[0]
        var count = 1
        var pos = 1

        for (i in 1 until chars.size) {
            if (chars[i] != last) {
                last = chars[i]
                count = 0
            }

            if (++count > 2) continue

            chars[pos++] = chars[i]
        }

        return String(chars, 0, pos)
    }
}

fun main() {
    val solution = Solution1957()
    
    // Test cases from the problem
    println(solution.makeFancyString("leeetcode"))  // Output: "leetcode"
    println(solution.makeFancyString("aaabaaaa"))    // Output: "aabaa"
    println(solution.makeFancyString("aab"))         // Output: "aab"
    
    
}