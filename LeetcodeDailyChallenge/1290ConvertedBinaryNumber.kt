class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution1290 {
    fun getDecimalValue(head: ListNode?): Int {
        var num = 0
        var current = head
        while (current != null) {
            num = (num shl 1) or current.`val`
            current = current.next
        }
        return num
    }
}

fun main() {
    val solution = Solution1290()
    
    // Example 1: [1,0,1] -> 5
    val head1 = ListNode(1)
    head1.next = ListNode(0)
    head1.next?.next = ListNode(1)
    
    println("Example 1: ${solution.getDecimalValue(head1)}") // Output: 5
    
    // Example 2: [0] -> 0
    val head2 = ListNode(0)
    println("Example 2: ${solution.getDecimalValue(head2)}") // Output: 0
    
    // Additional test: [1,1,1,1] -> 15
    val head3 = ListNode(1)
    head3.next = ListNode(1)
    head3.next?.next = ListNode(1)
    head3.next?.next?.next = ListNode(1)
    
    println("Additional test: ${solution.getDecimalValue(head3)}") // Output: 15
}