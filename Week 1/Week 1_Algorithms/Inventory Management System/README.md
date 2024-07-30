## Explain why data structures and algorithms are essential in handling large inventories

- Large inventories require efficient data storage and retrieval data structures and algorithms can optimize these operations, ensuring the system is fast and responsive

- Efficient data structures ensure that the system can handle the increased load without significant performance degradation

## Types of data structures suitable for this problem:

- ArrayList: Suitable where the primary operations are retrieval and updates by index. However, insertion and deletion can be costly due to shifting elements.

- HashMap: Ideal requiring fast access, insertion, and deletion based on unique keys (e.g., productId). HashMaps provide average O(1) time complexity for these operations.

## Analyze the time complexity of each operation (add, update, delete) in your chosen data structure.

- Add Product: O(1) - Adding a product to the HashMap is a constant-time operation.
- Update Product: O(1) - Updating a product by its key in the HashMap is a constant-time operation.
- Delete Product: O(1) - Deleting a product by its key in the HashMap is a constant-time operation.
- Get Product: O(1) - Retrieving a product by its key in the HashMap is a constant-time operation.

## Discuss how you can optimize these operations

- Periodically clean up the HashMap to remove unused entries and manage memory effectively.