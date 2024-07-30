## Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort)

-Bubble Sort:

A algorithm where each pair of adjacent elements is compared, and the elements are swapped if they are in the wrong order. This process is repeated until the list is sorted.

Time Complexity: O(n^2) in the worst and average cases, O(n) in the best case when the array is already sorted.

Space Complexity: O(1)

-Insertion Sort:

Builds the sorted array one element at a time by repeatedly picking the next element and inserting it into its correct position among the previously sorted elements.

Time Complexity: O(n^2) in the worst and average cases, O(n) in the best case when the array is already sorted.

Space Complexity: O(1)

-Quick Sort:

A divide-and-conquer algorithm that selects a 'pivot' element from the array and partitions the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.

Time Complexity: O(n^2) in the worst case, O(n log n) on average.

Space Complexity: O(log n) on average due to recursive stack space.

-Merge Sort:

A divide-and-conquer algorithm that divides the array into two halves, sorts each half, and then merges the two sorted halves back together.

Time Complexity: O(n log n) in all cases.

Space Complexity: O(n) due to the additional space needed for the temporary arrays used during merging.

## Compare the performance (time complexity) of Bubble Sort and Quick Sort
-Bubble Sort: O(n^2) on average and in the worst case.
-Quick Sort: O(n log n) on average, O(n^2) in the worst case.

## Discuss why Quick Sort is generally preferred over Bubble Sort.
- Quick Sort is generally much faster than Bubble Sort, especially for large datasets, due to its average time complexity of O(n log n) compared to Bubble Sort's O(n^2).

- Although Quick Sort has a worst-case time complexity of O(n^2), this can be mitigated with good pivot selection (e.g., using the median-of-three method). In practice, Quick Sort outperforms Bubble Sort due to its more efficient partitioning process.

- Quick Sort requires additional stack space due to recursion but still is more space-efficient for larger datasets than the additional swaps in Bubble Sort.