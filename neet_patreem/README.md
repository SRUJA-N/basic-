# 🚀 Neetcode 150: The Ultimate Study Guide

This repository tracks my journey through the **Neetcode 150**, a curated selection of LeetCode problems designed to cover every essential algorithmic pattern.

**Goal:** To master Data Structures & Algorithms (DSA) by focusing on *patterns* rather than memorizing solutions.

## 1\. Arrays & Hashing

**Core Concept:** Storing and retrieving data efficiently. The main weapon here is the **HashMap** (Dictionary), which trades space for time.

### 🧐 Prerequisites & Theory

  * **Hash Maps:** Understand how to achieve $O(1)$ average time complexity for lookups.
  * **Prefix Sums:** A technique to calculate sum of subarrays in $O(1)$ time after $O(n)$ preprocessing.
  * **ASCII/Unicode:** Understanding how characters map to integers (useful for Anagram problems).

### 🛠 Key Templates

**Frequency Map Pattern:**

```python
count = {}
for n in nums:
    count[n] = 1 + count.get(n, 0)
```

### 🧩 The Problem List

| LeetCode \# | Problem | Difficulty | Time / Space | 💡 Key Insight / Approach |
| :--- | :--- | :--- | :--- | :--- |
| 217 | **Contains Duplicate** | Easy | $O(n)$ / $O(n)$ | Don't use a double loop. Add items to a `HashSet`. If an item is already in the set, return True. |
| 242 | **Valid Anagram** | Easy | $O(n)$ / $O(1)$ | Create a frequency map (count of each char) for string A. Decrement for string B. All counts must be zero. |
| 1 | **Two Sum** | Easy | $O(n)$ / $O(n)$ | Iterate through the array. Check if `target - current_num` exists in your HashMap. If yes, you found the pair. If no, add `current_num` to the map. |
| 49 | **Group Anagrams** | Medium | $O(n \cdot k)$ / $O(n \cdot k)$ | Sort each string to use as a key in a HashMap? No, that's slow ($k \log k$). Better: Use an array of size 26 (a-z) representing char counts as the key. |
| 347 | **Top K Frequent Elements** | Medium | $O(n)$ / $O(n)$ | **Bucket Sort strategy:** Map frequencies to a list of numbers. Index `i` of the array contains numbers that appear `i` times. |
| 238 | **Product of Array Except Self** | Medium | $O(n)$ / $O(1)$ | Do not use division. Pass 1: Calculate prefix products (left to right). Pass 2: Multiply by suffix products (right to left). |
| 36 | **Valid Sudoku** | Medium | $O(9^2)$ / $O(9^2)$ | Use sets to track seen numbers. You need a set for each Row, each Column, and each 3x3 Box. Key for box: `(row // 3, col // 3)`. |
| 128 | **Longest Consecutive Sequence** | Medium | $O(n)$ / $O(n)$ | Put all numbers in a HashSet. Iterate the set. Only start counting a sequence if `num - 1` is **not** in the set (this ensures you start at the beginning of a sequence). |

## 2\. Two Pointers

**Core Concept:** Using two indices to traverse a linear structure (array/string) to solve problems without nested loops.

### 🧐 Prerequisites & Theory

  * **Sorted Arrays:** Many Two Pointer problems (like 2Sum II or 3Sum) require the input to be sorted first.
  * **Palindromes:** Comparing start and end characters moving inward.

### 🛠 Key Templates

**Shrinking Window (Sorted Input):**

```python
l, r = 0, len(nums) - 1
while l < r:
    current_sum = nums[l] + nums[r]
    if current_sum > target:
        r -= 1
    elif current_sum < target:
        l += 1
    else:
        return [l, r]
```

### 🧩 The Problem List

| LeetCode \# | Problem | Difficulty | Time / Space | 💡 Key Insight / Approach |
| :--- | :--- | :--- | :--- | :--- |
| 125 | **Valid Palindrome** | Easy | $O(n)$ / $O(1)$ | Use `l` at start, `r` at end. Move inward. Skip non-alphanumeric chars. Compare `lower()` case. |
| 167 | **Two Sum II** | Medium | $O(n)$ / $O(1)$ | Since the array is **sorted**, if sum \> target, decrease right pointer. If sum \< target, increase left pointer. |
| 15 | **3Sum** | Medium | $O(n^2)$ / $O(1)$ | Sort the array. Loop through the array (index `i`). For each `i`, run Two Sum II on the remaining part of the array. **Skip duplicates** to avoid repeating triplets. |
| 11 | **Container With Most Water** | Medium | $O(n)$ / $O(1)$ | Area is determined by the shorter line. Move the pointer of the **shorter** line inward to potentially find a taller line. |
| 42 | **Trapping Rain Water** | Hard | $O(n)$ / $O(1)$ | Water at index `i` = `min(max_left, max_right) - height[i]`. Use two pointers: maintain `max_left` and `max_right` variables while moving inward. |

## 3\. Sliding Window

**Core Concept:** Analyzing a specific subarray or substring. The window can be **Fixed Size** (e.g., sum of every 3 elements) or **Dynamic Size** (e.g., smallest subarray with sum \>= X).

### 🧐 Prerequisites & Theory

  * **Valid Window Condition:** You must know exactly when a window becomes invalid (e.g., too many duplicate characters).
  * **Expansion vs. Contraction:** Always expand `right` pointer. Only shrink `left` pointer when the condition is broken.

### 🛠 Key Templates

**Dynamic Window:**

```python
l = 0
for r in range(len(s)):
    # add s[r] to window
    while window_is_invalid:
        # remove s[l] from window
        l += 1
    # update max_len or result
```

### 🧩 The Problem List

| LeetCode \# | Problem | Difficulty | Time / Space | 💡 Key Insight / Approach |
| :--- | :--- | :--- | :--- | :--- |
| 121 | **Best Time to Buy & Sell Stock** | Easy | $O(n)$ / $O(1)$ | "Left" pointer is buy day, "Right" is sell day. If `price[l] < price[r]`, calculate profit. If `price[r]` is lower than `price[l]`, move `l` to `r` (found a new low). |
| 3 | **Longest Substring Without Repeating Characters** | Medium | $O(n)$ / $O(n)$ | Use a Set. If `s[r]` is in Set, remove `s[l]` and increment `l` until `s[r]` is no longer in Set. Then add `s[r]`. |
| 424 | **Longest Repeating Character Replacement** | Medium | $O(n)$ / $O(26)$ | `WindowLen - MostFrequentCharCount <= k`. If this is false, the window is invalid; shrink it. |
| 567 | **Permutation in String** | Medium | $O(n)$ / $O(26)$ | Fixed window size (len of s1). Compare frequency maps of s1 and current window in s2. Optimize by tracking "matches" count. |
| 76 | **Minimum Window Substring** | Hard | $O(n)$ / $O(n)$ | Expand `r` until you have all needed chars. Then increment `l` to shrink window as much as possible while still valid. |
| 239 | **Sliding Window Maximum** | Hard | $O(n)$ / $O(k)$ | Use a **Monotonic Decreasing Deque**. Store *indices*. Remove indices out of window range. Remove indices whose values are smaller than current `num`. |

## 4\. Stack

**Core Concept:** LIFO (Last In, First Out). Essential for parsing, backtracking, and finding "next greater" elements.

### 🧐 Prerequisites & Theory

  * **Monotonic Stack:** A stack that keeps elements in strictly increasing or decreasing order. This is the "magic" trick for many Hard problems.
  * **Backtracking:** Using the stack implicitly (recursion) or explicitly to remember previous states.

### 🛠 Key Templates

**Monotonic Stack (Next Greater Element):**

```python
stack = [] # stores indices or values
for val in nums:
    while stack and val > stack[-1]:
        popped = stack.pop()
        # logic for popped element
    stack.append(val)
```

### 🧩 The Problem List

| LeetCode \# | Problem | Difficulty | Time / Space | 💡 Key Insight / Approach |
| :--- | :--- | :--- | :--- | :--- |
| 20 | **Valid Parentheses** | Easy | $O(n)$ / $O(n)$ | Map closing brackets to opening ones `{')': '(', ...}`. If char is closing, check if stack top matches. If opening, push to stack. |
| 155 | **Min Stack** | Medium | $O(1)$ Ops | Keep *two* stacks. One for actual values, one for the minimum value *at that point in time*. |
| 150 | **Evaluate Reverse Polish Notation** | Medium | $O(n)$ / $O(n)$ | If number: push. If operator: pop twice, apply math, push result. |
| 22 | **Generate Parentheses** | Medium | $O(4^n / \sqrt{n})$ | Backtracking. Two rules: 1. Can add `(` if `open < n`. 2. Can add `)` if `closed < open`. |
| 739 | **Daily Temperatures** | Medium | $O(n)$ / $O(n)$ | **Monotonic Stack.** Store indices. If current temp \> stack top temp, pop stack (we found the warmer day for that index). |
| 853 | **Car Fleet** | Medium | $O(n \log n)$ | Sort cars by starting position (desc). Calculate time to target. If a car behind arrives faster/same time as one ahead, they become a fleet. |
| 84 | **Largest Rectangle in Histogram** | Hard | $O(n)$ / $O(n)$ | Monotonic Increasing Stack. When current bar is shorter than stack top, the stack top's area can be calculated (it can't extend further right). |

## 5\. Binary Search

**Core Concept:** Divide and conquer. Halve the search space each time. Requires sorted input.

### 🧐 Prerequisites & Theory

  * **Sorted Input:** Binary search only works on sorted arrays. If not sorted, sort first (but that changes time complexity).
  * **Edge Cases:** Empty array, target not found, duplicates.
  * **Answer Space:** For optimization problems, binary search on possible answers (e.g., minimum speed).

### 🛠 Key Templates

**Standard Binary Search:**

```python
def binary_search(nums, target):
    l, r = 0, len(nums) - 1
    while l <= r:
        mid = (l + r) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] < target:
            l = mid + 1
        else:
            r = mid - 1
    return -1
```

### 🧩 The Problem List

| LeetCode \# | Problem | Difficulty | Time / Space | 💡 Key Insight / Approach |
| :--- | :--- | :--- | :--- | :--- |
| 704 | **Binary Search** | Easy | $O(\log n)$ / $O(1)$ | Standard implementation. `l <= r` to include all elements. |
| 74 | **Search a 2D Matrix** | Medium | $O(\log (m \cdot n))$ / $O(1)$ | Treat 2D as 1D: `mid = (l + r) // 2`, row = `mid // cols`, col = `mid % cols`. |
| 875 | **Koko Eating Bananas** | Medium | $O(n \log (\max(p)))$ / $O(1)$ | Binary search on eating speed (1 to max(p)). Check if can eat all piles in `h` hours. |
| 153 | **Find Minimum in Rotated Sorted Array** | Medium | $O(\log n)$ / $O(1)$ | If `nums[mid] > nums[r]`, min is in right half. Else, left half. |
| 33 | **Search in Rotated Sorted Array** | Medium | $O(\log n)$ / $O(1)$ | Find pivot first, then search in appropriate half. Or check both halves in one pass. |
| 981 | **Time Based Key-Value Store** | Medium | $O(\log n)$ / $O(n)$ | Store list of [timestamp, value] per key. Binary search on timestamps. |
| 4 | **Median of Two Sorted Arrays** | Hard | $O(\log (\min(n, m)))$ / $O(1)$ | Partition both arrays so left parts have median. Use binary search on smaller array. |

## 6\. Linked List

**Core Concept:** Nodes connected by pointers. No random access (can't do `arr[5]`). Good for insertions/deletions.

### 🧐 Prerequisites & Theory

  * **Node Structure:** Each node has `val` and `next` (sometimes `prev` for doubly linked).
  * **Dummy Node:** Use a fake head to simplify edge cases (e.g., inserting at head).
  * **Fast/Slow Pointers:** Slow moves 1 step, fast moves 2 steps. Detect cycles or find middle.

### 🛠 Key Templates

**Reverse Linked List (Iterative):**

```python
def reverseList(head):
    prev = None
    curr = head
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt
    return prev
```

### 🧩 The Problem List

| LeetCode \# | Problem | Difficulty | Time / Space | 💡 Key Insight / Approach |
| :--- | :--- | :--- | :--- | :--- |
| 206 | **Reverse Linked List** | Easy | $O(n)$ / $O(1)$ | Iterative: Use three pointers (`prev`, `curr`, `nxt`). Recursive: Reverse from end to start. |
| 21 | **Merge Two Sorted Lists** | Easy | $O(n + m)$ / $O(1)$ | Use a dummy node. Compare `l1.val` and `l2.val`, append smaller one. |
| 143 | **Reorder List** | Medium | $O(n)$ / $O(1)$ | Find middle with fast/slow. Reverse second half. Merge two halves alternately. |
| 19 | **Remove Nth Node From End** | Medium | $O(n)$ / $O(1)$ | Use two pointers with gap `n`. When fast reaches end, slow is at node to remove. |
| 138 | **Copy List with Random Pointer** | Medium | $O(n)$ / $O(n)$ | Create copies interleaved with originals. Fix random pointers. Separate the lists. |
| 2 | **Add Two Numbers** | Medium | $O(\max(n, m))$ / $O(1)$ | Traverse both lists. Add digits + carry. Create new nodes for result. |
| 141 | **Linked List Cycle** | Easy | $O(n)$ / $O(1)$ | Fast/slow pointers. If they meet, cycle exists. |
| 287 | **Find the Duplicate Number** | Medium | $O(n)$ / $O(1)$ | Treat array as linked list (index = next). Use Floyd's cycle detection. |
| 146 | **LRU Cache** | Medium | $O(1)$ Ops | Doubly linked list + HashMap. Move accessed nodes to head. Remove tail when full. |
| 23 | **Merge k Sorted Lists** | Hard | $O(n \log k)$ / $O(k)$ | Use a min-heap (priority queue) to always pick the smallest head. |
| 25 | **Reverse Nodes in k-Group** | Hard | $O(n)$ / $O(1)$ | Reverse every k nodes. Use a dummy node. Keep track of group start/end. |

## 7\. Trees

**Core Concept:** Hierarchical data structure. Each node has children. No cycles. Perfect for recursive problems.

### 🧐 Prerequisites & Theory

  * **Tree Traversals:** In-order (left, root, right), Pre-order (root, left, right), Post-order (left, right, root).
  * **DFS vs BFS:** DFS uses recursion/stack (depth-first). BFS uses queue (level-by-level).
  * **BST Properties:** Left subtree < root < right subtree. In-order traversal gives sorted order.

### 🛠 Key Templates

**DFS (Recursive):**

```python
def dfs(node):
    if not node:
        return
    # Pre-order: process node here
    dfs(node.left)
    # In-order: process node here
    dfs(node.right)
    # Post-order: process node here
```

**BFS (Level Order):**

```python
from collections import deque
def bfs(root):
    if not root:
        return
    q = deque([root])
    while q:
        node = q.popleft()
        # process node
        if node.left:
            q.append(node.left)
        if node.right:
            q.append(node.right)
```

### 🧩 The Problem List

| LeetCode \# | Problem | Difficulty | Time / Space | 💡 Key Insight / Approach |
| :--- | :--- | :--- | :--- | :--- |
| 226 | **Invert Binary Tree** | Easy | $O(n)$ / $O(h)$ | Recursively swap left and right children. Post-order works well. |
| 104 | **Maximum Depth of Binary Tree** | Easy | $O(n)$ / $O(h)$ | DFS: `max(dfs(left), dfs(right)) + 1`. BFS: Count levels. |
| 543 | **Diameter of Binary Tree** | Easy | $O(n)$ / $O(h)$ | Diameter = max path through any node. Use DFS to compute height and track max diameter. |
| 110 | **Balanced Binary Tree** | Easy | $O(n)$ / $O(h)$ | Bottom-up DFS: Return height, or -1 if unbalanced. Check `abs(left - right) <= 1`. |
| 100 | **Same Tree** | Easy | $O(n)$ / $O(h)$ | Recursively check if both nodes are None or have same val and same subtrees. |
| 572 | **Subtree of Another Tree** | Easy | $O(n \cdot m)$ / $O(h)$ | Serialize both trees and check substring, or recursive subtree match. |
| 235 | **Lowest Common Ancestor of a BST** | Easy | $O(h)$ / $O(1)$ | If both values < root, go left. If both > root, go right. Else, root is LCA. |
| 102 | **Binary Tree Level Order Traversal** | Medium | $O(n)$ / $O(w)$ | BFS with queue. Process level by level. |
| 199 | **Binary Tree Right Side View** | Medium | $O(n)$ / $O(w)$ | BFS: Last node of each level. DFS: Pre-order, right first, track depth. |
| 1448 | **Count Good Nodes in Binary Tree** | Medium | $O(n)$ / $O(h)$ | DFS: Pass current max down. If node.val >= max, it's good. |
| 98 | **Validate Binary Search Tree** | Medium | $O(n)$ / $O(h)$ | In-order traversal: Keep track of previous value, ensure increasing. Or use range checks. |
| 230 | **Kth Smallest Element in a BST** | Medium | $O(h + k)$ / $O(h)$ | In-order traversal. Use a counter to find the kth element. |
| 105 | **Construct Binary Tree from Preorder and Inorder** | Medium | $O(n)$ / $O(n)$ | Preorder gives root. Inorder gives left/right split. Use hash map for inorder indices. |
| 124 | **Binary Tree Maximum Path Sum** | Hard | $O(n)$ / $O(h)$ | Post-order DFS: For each node, max path = node.val + max(left, 0) + max(right, 0). Track global max. |
| 297 | **Serialize and Deserialize Binary Tree** | Hard | $O(n)$ / $O(n)$ | Serialize: Pre-order DFS, use '#' for None. Deserialize: Use queue to rebuild tree. |
