# [LeetCode]-0128 最长连续序列

给定一个未排序的整数数组 `nums` ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 `O(n)` 的算法解决此问题。



* **示例 1**：
> **输入**：nums = [100,4,200,1,3,2]
> 
> **输出**：4
> 
> **解释**：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 

* **示例 2**：
> **输入**：nums = [0,3,7,2,5,8,4,6,0,1]
> 
> **输出**：9


* **提示**：
  * `0 <= nums.length <= 105`
  * `-109 <= nums[i] <= 109`


## 暴力法
先将数组进行排序，之后从数组中依次抽取一个数，然后再和后面的元素进行比较，如果存在一个连续数，那么连续序列加 1。

然后每次和之前记录的最长连续序列长度进行对比，保留最大值。
```java
public int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
        int left = nums[i];
        int tempMax = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == left + 1) {
              tempMax++;
              left = nums[j];
            }
        }
        max = Math.max(max, tempMax);
    }
    return max;
}
```

## Hash法
经过观察上面的暴力法，我们发现存在重复的计算，如果数组为【1，2，3】，
1 计算后，其实囊括了 2 和 3，所以其实没有必要再去循环计算 2 和 3 的序列。

观察后可得，如果当前的元素，存在一个前继连续元素，那么这个元素没有必要再进行计算。

首先通过将所有的元素添加到 HashSet 中进行去重，减少后续无效比较，接着从集合中遍历元素 `x`，
如果这个集合中包含当前元素 `x - 1`，那么证明当前元素 `x` 已经在 `x - 1` 那一轮里计算过了，直接略过。

如果不包含 `x - 1`，证明这是一个新序列，然后在集合中循环遍历并将最大长度 `tempMax++` ，
直到遇见一个不连续，断开的位置，此时当前序列的最大长度就是 `tempMax`，再和之前保存的最大值 `max` 进行比对并替换。
```java
public int longestConsecutive(int[] nums) {
    Set<Integer> sets = new HashSet<>();
    for (int num : nums) {
        sets.add(num);
    }
  
    int max = 0;
    for (Integer set : sets) {
        int tempMax = 0;
        if (!sets.contains(set - 1)) {
            while (sets.contains(set++)) {
              tempMax++;
            }
        }
        max = Math.max(max, tempMax);
    }
    return max;
}
```