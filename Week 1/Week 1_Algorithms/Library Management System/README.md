## Explain linear search and binary search algorithms

-Linear Search
Linear search is a straightforward searching algorithm that checks each element in the list one by one until the desired element is found or the list ends.

Time Complexity: O(n), where n is the number of elements in the list.

-Binary search 
Binary Searcch - is an efficient searching algorithm that works on sorted lists. It repeatedly divides the search interval in half and compares the target value to the middle element of the list.

Time Complexity: O(log n), where n is the number of elements in the list.

## Compare the time complexity of linear and binary search

Linear Search: O(n)
Binary Search: O(log n)


## Discuss when to use each algorithm based on the data set size and order.

-Linear Search:

Advantages: Simple to implement and does not require the list to be sorted.
Disadvantages: Slow for large datasets

-Binary Search:

Advantages: Much faster for large datasets due to its logarithmic time complexity.
Disadvantages: Requires the list to be sorted, which may add overhead if the list needs to be sorted frequently.