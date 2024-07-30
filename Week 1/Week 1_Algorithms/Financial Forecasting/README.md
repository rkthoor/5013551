## Explain the concept of recursion and how it can simplify certain problems

Recursion is a programming technique where a function calls itself to solve a problem. Each recursive call breaks down the problem into smaller subproblems until a base case is reached, which provides a straightforward solution.

## Time complexity 
The time complexity of this recursive algorithm is 𝑂(𝑛)
n is the number of periods. This is because the function makes a recursive call for each period until it reaches the base case.

## Recursive solution 
To avoid excessive computation and redundant calculations, we can use memoization. Memoization stores the results of expensive function calls and returns the cached result when the same inputs occur again.