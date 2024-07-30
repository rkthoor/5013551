## Explain how arrays are represented in memory and their advantages

Arrays are a data structure consisting of a collection of elements, each identified by an array index. They are represented in memory as a contiguous block of memory. The size of this block is determined by the number of elements in the array and the size of each element.

Advantages of Arrays:

Constant Time Access: Since arrays use contiguous memory locations, accessing any element using its index takes constant time, O(1).
Ease of Traversal: Traversing the elements of an array is straightforward and can be done efficiently.
Memory Efficiency: Arrays do not have extra overhead, such as pointers in linked lists.

## Time Complexity Analysis:
Add Operation:Time Complexity: O(1)

Search Operation:Time Complexity: O(n)

Traverse Operation:Time Complexity: O(n)

Delete Operation:Time Complexity: O(n)

## Discuss the limitations of arrays and when to use them.
Fixed Size: Arrays have a fixed size, which can be a limitation if the number of elements is not known in advance or can vary significantly.
Costly Insertions and Deletions: Inserting or deleting elements in the middle of an array requires shifting elements, which is inefficient (O(n) time complexity).
Memory Allocation: Arrays require a contiguous block of memory, which can be problematic for large arrays or when memory is fragmented.