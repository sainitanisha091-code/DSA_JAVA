# Two Pointers Technique — Complete Notes

A beginner-friendly guide to the Two Pointers technique in Java, covering five useful patterns, algorithms, dry runs, code examples, and time complexity.

## Table of Contents

1. [Introduction to Two Pointers](#1-what-is-the-two-pointers-technique)
2. [Overview of the Five Patterns](#2-overview-of-the-five-patterns)
3. [Type 1 — Opposite Directions](#3-type-1--opposite-directions)
4. [Type 2 — Same Direction, Different Roles](#4-type-2--same-direction-different-roles)
5. [Type 3 — Two Separate Arrays](#5-type-3--two-separate-arrays)
6. [Type 4 — Three-Pointer Partition](#6-type-4--three-pointer-partition)
7. [Type 5 — Split Then Merge](#7-type-5--split-then-merge-merge-sort)
8. [Quick Revision Sheet](#8-quick-revision-sheet)
9. [How to Identify the Pattern](#9-how-to-identify-the-pattern)

---

## 1. What Is the Two Pointers Technique?

The **Two Pointers technique** is a problem-solving approach in which two index variables are used to traverse an array, string, or another data structure.

Common pointer names include:

- `left` and `right`
- `slow` and `fast`
- `i` and `j`
- `low`, `mid`, and `high`

Instead of checking every possible pair using nested loops, we move pointers intelligently according to the conditions of the problem.

This can reduce the time complexity of many problems from `O(n²)` to `O(n)`.

### Example: Find a Pair with a Target Sum

Given a sorted array:

```java
int[] arr = {1, 2, 4, 6, 9};
int target = 10;
```

We need to find two elements whose sum equals `10`.

```text
Array: [1, 2, 4, 6, 9]
        L           R

arr[left] + arr[right]
      1 + 9 = 10

Pair found!
```

**Important:** Two Pointers is not just about declaring two variables. The key is understanding:

- Where each pointer starts.
- What each pointer represents.
- When a pointer should move.
- Why it should move in that direction.

---

## 2. Overview of the Five Patterns

These five patterns are a useful learning classification. They are not a universal or exhaustive list of all Two Pointers variations.

| Type | Pattern | Main Idea | Examples |
|---|---|---|---|
| Type 1 | Opposite Directions | Move pointers toward each other | Reverse Array, Sorted Two Sum |
| Type 2 | Same Direction, Different Roles | One pointer scans while another tracks the write position | Move Zeroes, Remove Duplicates |
| Type 3 | Two Separate Arrays | Each array has its own pointer | Merge Sorted Arrays, Intersection |
| Type 4 | Three-Pointer Partition | Divide elements into different regions | Sort Colors |
| Type 5 | Split Then Merge | Recursively split, sort, and merge | Merge Sort |

**Note:** Type 5 is a Divide and Conquer algorithm that uses multiple pointers during merging. It is related to pointer-based techniques but is not usually classified as a basic Two Pointers pattern.

---

# 3. Type 1 — Opposite Directions

## 3.1 Concept

In this pattern, two pointers start at opposite ends of an array and move toward each other.

- `left = 0` points to the first element.
- `right = arr.length - 1` points to the last element.

```text
Array: [1, 2, 4, 6, 9]
        L           R

left moves  →
right moves ←
```

The pointers move according to the problem's conditions.

### When Should You Use This Pattern?

Consider this pattern when:

- You need to find a pair with a target sum in a sorted array.
- You need to reverse an array.
- You need to check whether a string is a palindrome.
- You need to compare elements from opposite ends.

**Important:** The standard Two Sum approach using these pointer movements requires a sorted array. It is not generally safe to use the same logic directly on an unsorted array.

## 3.2 Example A — Find a Pair with a Target Sum

**Problem:** Find two elements in a sorted array whose sum equals the target.

Input:

```java
int[] arr = {1, 2, 4, 6, 9};
int target = 8;
```

Expected pair:

```text
2 + 6 = 8
```

### Algorithm

1. Initialize `left = 0`.
2. Initialize `right = arr.length - 1`.
3. Calculate `arr[left] + arr[right]`.
4. If the sum equals the target, return `true`.
5. If the sum is smaller than the target, increment `left`.
6. If the sum is greater than the target, decrement `right`.
7. Repeat until the pointers meet or cross.
8. If no pair is found, return `false`.

### Dry Run

Input: `[1, 2, 4, 6, 9]`

Target: `8`

| Step | Left Value | Right Value | Sum | Action |
|---|---:|---:|---:|---|
| 1 | 1 | 9 | 10 | Sum too large → `right--` |
| 2 | 1 | 6 | 7 | Sum too small → `left++` |
| 3 | 2 | 6 | 8 | Pair found |

Answer: `(2, 6)`

### Java Code

```java
static boolean hasPairSum(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];

        if (sum == target) {
            return true;
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }

    return false;
}
```

### Why Do the Pointers Move This Way?

**Case 1: Sum is smaller than the target**

We need a larger sum. Since the array is sorted, moving `left` forward gives us a value that is at least as large as the current left value.

Therefore:

```java
left++;
```

**Case 2: Sum is greater than the target**

We need a smaller sum. Moving `right` backward gives us a value that is no larger than the current right value.

Therefore:

```java
right--;
```

**Case 3: Sum equals the target**

The required pair has been found.

### Why Use `left < right`?

This condition prevents using the same array element twice.

```java
while (left < right)
```

If `left == right`, both pointers refer to the same element, which is not allowed when the problem requires two distinct elements.

## 3.3 Example B — Reverse an Array

**Problem:** Reverse an array in-place.

Input:

```java
int[] arr = {1, 2, 3, 4, 5};
```

Expected output:

```text
[5, 4, 3, 2, 1]
```

### Java Code

```java
static void reverseArray(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
}
```

### How It Works

1. Swap the first and last elements.
2. Move `left` one step forward.
3. Move `right` one step backward.
4. Repeat until the pointers meet.

Dry run:

```text
Initial: [1, 2, 3, 4, 5]
          L           R

Swap 1 and 5:
         [5, 2, 3, 4, 1]
             L     R

Swap 2 and 4:
         [5, 4, 3, 2, 1]
                L
                R

Reversed array: [5, 4, 3, 2, 1]
```

## 3.4 Common Mistakes

- Applying sorted Two Sum logic to an unsorted array.
- Using `left <= right` when two distinct elements are required.
- Moving the wrong pointer after comparing the sum.
- Confusing the values of a pair with their indices.
- Forgetting to swap elements correctly while reversing an array.

## 3.5 Complexity

For Sorted Two Sum:

- **Time:** `O(n)`
- **Extra space:** `O(1)`

For Reverse Array:

- **Time:** `O(n)`
- **Extra space:** `O(1)`

### Practice Problems

- Reverse an Array
- Valid Palindrome
- [LeetCode 167 — Two Sum II: Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
- [LeetCode 125 — Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
- [LeetCode 11 — Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

---

# 4. Type 2 — Same Direction, Different Roles

## 4.1 Concept

In this pattern, both pointers generally move from left to right, but they perform different jobs.

- `fast` scans or reads elements.
- `slow` tracks the position where the next valid element should be written.

The exact meaning of `slow` depends on the problem.

For example:

- In Move Zeroes, `slow` represents the next position for a non-zero value.
- In Remove Duplicates, `slow` represents the index of the last unique element.

### When Should You Use This Pattern?

Consider it when:

- You need to remove duplicates from a sorted array.
- You need to move zeroes to the end.
- You need to modify an array in-place.
- You need to place valid elements at the beginning of an array.

## 4.2 Example A — Move Zeroes to the End

**Problem:** Move all zeroes to the end while preserving the relative order of non-zero elements.

Input:

```java
int[] arr = {1, 0, 2, 0, 3};
```

Expected output:

```text
[1, 2, 3, 0, 0]
```

### Algorithm

1. Initialize `slow = 0`.
2. Use `fast` to scan the array.
3. If `arr[fast] != 0`, copy that value to `arr[slow]`.
4. Increment `slow`.
5. After scanning all elements, fill the remaining positions with zeroes.

### Dry Run

Initial array:

```text
[1, 0, 2, 0, 3]
```

| `fast` | Read Value | Action | Array After Action |
|---:|---:|---|---|
| 0 | 1 | Write at index 0 | `[1, 0, 2, 0, 3]` |
| 1 | 0 | Skip | `[1, 0, 2, 0, 3]` |
| 2 | 2 | Write at index 1 | `[1, 2, 2, 0, 3]` |
| 3 | 0 | Skip | `[1, 2, 2, 0, 3]` |
| 4 | 3 | Write at index 2 | `[1, 2, 3, 0, 3]` |

After the loop, `slow = 3`.

Fill the remaining indices with zeroes:

```text
[1, 2, 3, 0, 0]
```

**Note:** Intermediate duplicate values are normal. The remaining positions are overwritten with zeroes at the end.

### Java Code

```java
static void moveZeroes(int[] arr) {
    int slow = 0;

    for (int fast = 0; fast < arr.length; fast++) {
        if (arr[fast] != 0) {
            arr[slow] = arr[fast];
            slow++;
        }
    }

    while (slow < arr.length) {
        arr[slow] = 0;
        slow++;
    }
}
```

## 4.3 Example B — Remove Duplicates from a Sorted Array

**Problem:** Keep only one occurrence of each value in a sorted array.

Input:

```text
[1, 1, 2, 2, 3]
```

Expected valid portion:

```text
[1, 2, 3]
```

Expected length:

```text
3
```

### Algorithm

1. If the array is empty, return `0`.
2. Initialize `slow = 0`.
3. Start `fast = 1`.
4. Compare `arr[fast]` with `arr[slow]`.
5. If they are different, a new unique value has been found.
6. Increment `slow` and copy the new value to `arr[slow]`.
7. Return `slow + 1`.

### Java Code

```java
static int removeDuplicates(int[] arr) {
    if (arr.length == 0) {
        return 0;
    }

    int slow = 0;

    for (int fast = 1; fast < arr.length; fast++) {
        if (arr[fast] != arr[slow]) {
            slow++;
            arr[slow] = arr[fast];
        }
    }

    return slow + 1;
}
```

### Why Return `slow + 1`?

Array indices start from zero.

If the last unique element is at index `2`, the number of unique elements is:

```text
Number of elements = Last index + 1
                   = 2 + 1
                   = 3
```

The method returns the valid length. Any remaining elements beyond that length can be ignored.

### Common Mistakes

- Incrementing `slow` when the current value is zero in Move Zeroes.
- Forgetting that Remove Duplicates requires a sorted array.
- Returning `slow` instead of `slow + 1`.
- Assuming `slow` has the same meaning in every slow-fast problem.

## 4.4 Complexity

For both examples:

- **Time:** `O(n)`
- **Extra space:** `O(1)`

### Practice Problems

- [LeetCode 283 — Move Zeroes](https://leetcode.com/problems/move-zeroes/)
- [LeetCode 26 — Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
- [LeetCode 27 — Remove Element](https://leetcode.com/problems/remove-element/)

---

# 5. Type 3 — Two Separate Arrays

## 5.1 Concept

In this pattern, each input array has its own pointer.

- `i` points to the current element in the first array.
- `j` points to the current element in the second array.
- `k` points to the next position in the output array, when an output array is used.

This pattern is especially useful when both input arrays are sorted.

### When Should You Use This Pattern?

- To merge two sorted arrays.
- To find common elements between two sorted arrays.
- To find the intersection of sorted arrays.
- To compare or combine sorted data.

## 5.2 Example A — Find Common Elements

**Problem:** Find the common elements between two sorted arrays.

Input:

```java
int[] arr1 = {1, 2, 4, 5, 7};
int[] arr2 = {2, 3, 5, 6, 7};
```

Expected output:

```text
[2, 5, 7]
```

### Algorithm

1. Initialize `i = 0` and `j = 0`.
2. Compare `arr1[i]` and `arr2[j]`.
3. If the first value is smaller, increment `i`.
4. If the second value is smaller, increment `j`.
5. If both values are equal, store the common value and increment both pointers.
6. Stop when either array has no elements left to examine.

### Dry Run

| `arr1[i]` | `arr2[j]` | Action |
|---:|---:|---|
| 1 | 2 | First value smaller → `i++` |
| 2 | 2 | Match found: `2`; increment both |
| 4 | 3 | Second value smaller → `j++` |
| 4 | 5 | First value smaller → `i++` |
| 5 | 5 | Match found: `5`; increment both |
| 7 | 6 | Second value smaller → `j++` |
| 7 | 7 | Match found: `7`; increment both |

Result:

```text
[2, 5, 7]
```

### Java Code

```java
import java.util.Arrays;

static int[] commonElements(int[] arr1, int[] arr2) {
    int i = 0;
    int j = 0;
    int k = 0;

    int[] result = new int[Math.min(arr1.length, arr2.length)];

    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            i++;
        } else if (arr1[i] > arr2[j]) {
            j++;
        } else {
            result[k] = arr1[i];
            k++;
            i++;
            j++;
        }
    }

    return Arrays.copyOf(result, k);
}
```

This implementation records matching values as the pointers advance. If duplicate values need to be counted or returned in a particular way, additional rules may be required.

## 5.3 Example B — Merge Two Sorted Arrays

**Problem:** Merge two sorted arrays into one sorted array.

Input:

```java
int[] arr1 = {1, 3, 5};
int[] arr2 = {2, 4, 6};
```

Expected output:

```text
[1, 2, 3, 4, 5, 6]
```

### Algorithm

1. Create an output array of size `arr1.length + arr2.length`.
2. Initialize `i = 0`, `j = 0`, and `k = 0`.
3. Compare the current values of both arrays.
4. Copy the smaller value into the output array.
5. Move the pointer belonging to the array from which the value was taken.
6. Continue until either array is exhausted.
7. Copy any remaining elements from both arrays.

### Dry Run

| Left Value | Right Value | Value Added |
|---:|---:|---:|
| 1 | 2 | 1 |
| 3 | 2 | 2 |
| 3 | 4 | 3 |
| 5 | 4 | 4 |
| 5 | 6 | 5 |
| — | 6 | 6 (remaining element) |

Final output:

```text
[1, 2, 3, 4, 5, 6]
```

### Java Code

```java
static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
    int i = 0;
    int j = 0;
    int k = 0;

    int[] result = new int[arr1.length + arr2.length];

    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] < arr2[j]) {
            result[k] = arr1[i];
            i++;
        } else {
            result[k] = arr2[j];
            j++;
        }

        k++;
    }

    while (i < arr1.length) {
        result[k] = arr1[i];
        i++;
        k++;
    }

    while (j < arr2.length) {
        result[k] = arr2[j];
        j++;
        k++;
    }

    return result;
}
```

### Why Are Leftover Loops Necessary?

The main loop stops as soon as either array runs out of elements.

The other array may still contain elements, which must be copied into the result.

For example:

```text
arr1 = [1, 3, 5]
arr2 = [2, 4, 6, 8, 10]
```

The main loop stops when `arr1` is exhausted. The remaining elements `6, 8, 10` must still be copied into the result.

```java
while (j < arr2.length) {
    result[k] = arr2[j];
    j++;
    k++;
}
```

### Important Difference

| Finding Common Elements | Merging Sorted Arrays |
|---|---|
| Stores only matching values | Stores every value |
| Increments both pointers on a match | Increments only the pointer used |
| Output contains common elements | Output contains all elements |
| Duplicates depend on the chosen rules | All input occurrences are preserved |

### Why Use `&&` in the Main Loop?

```java
while (i < arr1.length && j < arr2.length)
```

The loop continues only while both arrays still have elements available.

When either array finishes, the main loop stops and the leftover loops handle the remaining elements.

## 5.4 Common Mistakes

- Forgetting to increment `i`, `j`, or `k`.
- Creating an output array that is too small.
- Forgetting the leftover loops.
- Confusing merging with finding common elements.
- Applying these pointer rules to unsorted arrays without additional processing.

## 5.5 Complexity

Let the array lengths be `n` and `m`.

- **Time:** `O(n + m)`
- **Extra space:** `O(n + m)` when creating a new merged array.

### Practice Problems

- Merge Two Sorted Arrays
- Intersection of Two Sorted Arrays
- [LeetCode 88 — Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

---

# 6. Type 4 — Three-Pointer Partition

## 6.1 Concept

This pattern uses three pointers to divide an array into different regions.

A classic example is sorting an array containing only `0`, `1`, and `2`.

It is also known as the **Dutch National Flag algorithm**.

The three pointers are:

- `low` — position where the next `0` should go.
- `mid` — current element being examined.
- `high` — position where the next `2` should go.

### Initial Positions

```java
int low = 0;
int mid = 0;
int high = arr.length - 1;
```

The array gradually develops these regions:

```text
[ Processed 0s | Processed 1s | Unknown Elements | Processed 2s ]
                 low          mid                high
```

Initially, the processed regions are empty. Each iteration classifies one unknown element.

## 6.2 Example — Sort Colors

**Problem:** Sort an array containing only `0`, `1`, and `2` without using a sorting library.

Input:

```java
int[] arr = {2, 0, 1, 2, 0, 1};
```

Expected output:

```text
[0, 0, 1, 1, 2, 2]
```

## 6.3 The Three Rules

### Case 1: `arr[mid] == 0`

Move the zero to the left region by swapping `arr[low]` and `arr[mid]`.

```java
int temp = arr[low];
arr[low] = arr[mid];
arr[mid] = temp;

low++;
mid++;
```

Both pointers move forward because the zero is now in its correct region, and the current position has been processed.

### Case 2: `arr[mid] == 1`

The value already belongs in the middle region.

```java
mid++;
```

No swap is needed.

### Case 3: `arr[mid] == 2`

Move the two to the right region by swapping `arr[mid]` and `arr[high]`.

```java
int temp = arr[mid];
arr[mid] = arr[high];
arr[high] = temp;

high--;
```

**Important:** Do not increment `mid` here. The value brought from `high` into the current position has not been checked yet.

## 6.4 Complete Dry Run

Input:

```text
arr = [2, 0, 1, 2, 0, 1]

low = 0
mid = 0
high = 5
```

| Step | `arr[mid]` | Action | Array After Action | Pointer Update |
|---|---:|---|---|---|
| 1 | 2 | Swap `mid` and `high` | `[1, 0, 1, 2, 0, 2]` | `high--` |
| 2 | 1 | No swap | `[1, 0, 1, 2, 0, 2]` | `mid++` |
| 3 | 0 | Swap `mid` and `low` | `[0, 1, 1, 2, 0, 2]` | `low++`, `mid++` |
| 4 | 2 | Swap `mid` and `high` | `[0, 1, 0, 2, 1, 2]` | `high--` |
| 5 | 0 | Swap `mid` and `low` | `[0, 0, 1, 2, 1, 2]` | `low++`, `mid++` |
| 6 | 2 | `mid > high` | `[0, 0, 1, 2, 1, 2]` | Loop stops |

Final sorted array:

```text
[0, 0, 1, 1, 2, 2]
```

## 6.5 Complete Java Code

```java
static void sortColors(int[] arr) {
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;

    while (mid <= high) {
        if (arr[mid] == 0) {
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;

            low++;
            mid++;
        } else if (arr[mid] == 1) {
            mid++;
        } else {
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;

            high--;
        }
    }
}
```

## 6.6 Why Use `mid <= high`?

```java
while (mid <= high)
```

When `mid == high`, one unknown element may still need to be examined.

When `mid > high`, the unknown region is empty, so sorting is complete.

## 6.7 Common Mistakes

- Incrementing `mid` in the `2` case.
- Incrementing `low` but forgetting to increment `mid` in the `0` case.
- Using `while (mid < high)`, which can skip the final unknown element.
- Assuming every three-pointer problem follows exactly the same rules.

## 6.8 Complexity

- **Time:** `O(n)`
- **Extra space:** `O(1)`
- **Sorting method:** In-place.

### Practice Problems

- [LeetCode 75 — Sort Colors](https://leetcode.com/problems/sort-colors/)
- Partition an Array Around a Pivot
- Three-Way Partitioning

---

# 7. Type 5 — Split Then Merge (Merge Sort)

## 7.1 Concept

**Merge Sort** is a Divide and Conquer sorting algorithm.

It follows three main steps:

1. **Divide:** Split the array into smaller halves.
2. **Conquer:** Recursively sort each half.
3. **Combine:** Merge the sorted halves into one sorted array.

This pattern uses recursion to sort the halves and multiple pointers during the merge step.

Unlike the first four patterns, Merge Sort is a complete sorting algorithm rather than a basic Two Pointers pattern.

## 7.2 Example — Sort an Array

Input:

```java
int[] arr = {8, 3, 6, 2};
```

Expected output:

```text
[2, 3, 6, 8]
```

### Step 1: Split

```text
             [8, 3, 6, 2]
              /         \
          [8, 3]       [6, 2]
          /   \         /   \
        [8]   [3]     [6]   [2]
```

Continue splitting until each part contains one element.

### Step 2: Base Case

```java
if (arr.length <= 1) {
    return;
}
```

An array containing zero or one element is already sorted, so the function returns.

### Step 3: Merge in Sorted Order

```text
[8] + [3]       -> [3, 8]
[6] + [2]       -> [2, 6]

[3, 8] + [2, 6] -> [2, 3, 6, 8]
```

Splitting alone does not sort the array. The comparisons happen during merging.

## 7.3 Understanding the `merge()` Function

Suppose we have two sorted arrays:

```java
int[] left = {3, 8};
int[] right = {2, 6};
```

The result array will contain four elements.

```text
left   = [3, 8]
right  = [2, 6]
result = [_, _, _, _]
```

We use three pointers:

- `i` — current index in `left`.
- `j` — current index in `right`.
- `k` — next position in `result`.

### Dry Run

| Comparison | Action | Result |
|---|---|---|
| 3 vs 2 | Add 2 | `[2, _, _, _]` |
| 3 vs 6 | Add 3 | `[2, 3, _, _]` |
| 8 vs 6 | Add 6 | `[2, 3, 6, _]` |
| Right array finished | Copy remaining 8 | `[2, 3, 6, 8]` |

### Merge Function

```java
static void merge(int[] left, int[] right, int[] result) {
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] <= right[j]) {
            result[k] = left[i];
            i++;
        } else {
            result[k] = right[j];
            j++;
        }

        k++;
    }

    while (i < left.length) {
        result[k] = left[i];
        i++;
        k++;
    }

    while (j < right.length) {
        result[k] = right[j];
        j++;
        k++;
    }
}
```

### Why Are Leftover Loops Necessary?

The main loop stops when either the left or right array runs out of elements.

The other array may still contain elements. Since the remaining elements are already sorted, they can be copied directly into the result.

## 7.4 Understanding the `mergeSort()` Function

The function performs the following steps:

1. Checks the base case.
2. Finds the middle index.
3. Creates left and right arrays.
4. Copies elements into the two halves.
5. Recursively sorts both halves.
6. Merges the sorted halves back into the original array.

### Java Code

```java
static void mergeSort(int[] arr) {
    if (arr.length <= 1) {
        return;
    }

    int mid = arr.length / 2;

    int[] left = new int[mid];
    int[] right = new int[arr.length - mid];

    for (int i = 0; i < mid; i++) {
        left[i] = arr[i];
    }

    for (int i = mid; i < arr.length; i++) {
        right[i - mid] = arr[i];
    }

    mergeSort(left);
    mergeSort(right);

    merge(left, right, arr);
}
```

## 7.5 Complete Working Java Program

```java
import java.util.Arrays;

public class Main {

    static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    static void merge(int[] left, int[] right, int[] result) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 6, 2};

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
```

Output:

```text
[2, 3, 6, 8]
```

## 7.6 Understanding Recursion

The call sequence looks like this:

```text
mergeSort(arr)
    |
    |-- Check base case
    |
    |-- Split into left and right
    |
    |-- mergeSort(left)
    |
    |-- mergeSort(right)
    |
    |-- merge(left, right, arr)
```

`mergeSort(left)` means that the left half is sorted by applying the same algorithm to it.

The merge step runs after both recursive calls have returned.

## 7.7 Common Mistakes

- Forgetting the base case, which can cause infinite recursion.
- Writing `right[i]` instead of `right[i - mid]` when copying elements.
- Merging before recursively sorting both halves.
- Forgetting the leftover loops.
- Assuming splitting automatically sorts the array.
- Passing the wrong array as the destination to `merge()`.
- Using `<` instead of `<=` when stable handling of equal elements is required.

## 7.8 Complexity

- **Time:** `O(n log n)`
- **Extra space:** `O(n)` for temporary arrays, excluding the recursion stack.
- **Stability:** Merge Sort can be stable. Choosing the left element first when values are equal preserves the relative order of equal elements.

---

# 8. Quick Revision Sheet

Use this table for quick revision before coding practice or interviews.

| Type | Pointer Setup | Main Idea | Example | Typical Time |
|---|---|---|---|---|
| Type 1 — Opposite Directions | `left`, `right` | Move toward the center | Sorted Two Sum | `O(n)` |
| Type 2 — Same Direction | `slow`, `fast` | Scan and write valid elements | Move Zeroes | `O(n)` |
| Type 3 — Two Separate Arrays | `i`, `j`, optionally `k` | Compare and combine two arrays | Merge Sorted Arrays | `O(n + m)` |
| Type 4 — Three-Pointer Partition | `low`, `mid`, `high` | Divide elements into categories | Sort Colors | `O(n)` |
| Type 5 — Split Then Merge | Recursive calls and merge pointers | Split, sort, and combine | Merge Sort | `O(n log n)` |

### Important Complexity Reminder

| Complexity | Meaning |
|---|---|
| `O(1)` | Constant time or extra space |
| `O(n)` | Linear growth |
| `O(n + m)` | Linear growth in two input sizes |
| `O(n²)` | Quadratic growth |
| `O(n log n)` | Common complexity for efficient comparison sorting |

---

# 9. How to Identify the Pattern

When reading a coding question, first identify what the pointers need to do.

### Question 1: Is the array sorted, and do I need a pair sum?

Consider **Type 1 — Opposite Directions**.

Example: Two Sum II.

### Question 2: Do I need to modify an array in-place?

Consider **Type 2 — Same Direction, Different Roles**.

Examples: Move Zeroes, Remove Duplicates.

### Question 3: Are there two sorted arrays to compare or combine?

Consider **Type 3 — Two Separate Arrays**.

Examples: Merge Sorted Arrays, Intersection.

### Question 4: Do elements need to be separated into categories?

Consider **Type 4 — Three-Pointer Partition**.

Example: Sort Colors.

### Question 5: Do I need to recursively divide an array and sort its parts?

Consider **Type 5 — Split Then Merge**.

Example: Merge Sort.

---

## Final Tips

1. Read the problem statement carefully before writing code.
2. Identify the role of each pointer.
3. Write down the initial pointer positions.
4. Dry-run at least one example using a table.
5. Explain why each pointer moves.
6. Check empty arrays, single-element arrays, and duplicate values.
7. Test your code with multiple inputs.
8. Learn the pattern first, then practise similar problems.

**Remember:** The goal is not to memorize pointer movements. The goal is to understand what each pointer represents and why moving it is safe.
