## Explain the different types of linked lists (Singly Linked List, Doubly Linked List).

Singly Linked List:
 A singly linked list is a data structure consisting of nodes, where each node contains a value and a reference (or pointer) to the next node in the sequence.

Doubly Linked List:

A doubly linked list is similar to a singly linked list but each node has two pointers: one to the next node and one to the previous node.

## Analyze the time complexity of each operation
Add Task: O(n) - Need to traverse to the end of the list to add a new node.
Search Task: O(n) - May need to traverse the entire list to find the task.
Delete Task: O(n) - May need to traverse the entire list to find and delete the task.
Traverse Tasks: O(n) - Need to traverse the entire list to gather all tasks.

## Advantages of Linked Lists over Arrays for Dynamic Data:

- Linked lists can grow and shrink in size by simply adjusting pointers, whereas arrays have a fixed size or require resizing (which is costly).
- Linked lists can insert and delete elements without shifting elements, making these operations more efficient compared to arrays.
- Linked lists allocate memory as needed, unlike arrays which may allocate more memory than required upfront.