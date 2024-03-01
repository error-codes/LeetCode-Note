# [LeetCode]-0001 两数之和

给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值** `target` 的那 **两个** 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 

你可以按任意顺序返回答案。

* **示例 1**：
> **输入**：nums = [2,7,11,15], target = 9
> 
> **输出**：[0,1]
> 
> **解释**：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

* **示例 2**：
> **输入**：nums = [3,2,4], target = 6
> 
> **输出**：[1,2]

* **示例 3**：
> **输入**：nums = [3,3], target = 6
> 
> **输出**：[0,1]

* **提示**：
  * `2 <= nums.length <= 104`
  * `-109 <= nums[i] <= 109`
  * `-109 <= target <= 109`
  * `只会存在一个有效答案`

## 暴力法
通过挨个遍历，进行比较，如果有两个数之和为 target，则返回元素对应下标
```java
public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            }
        }
    }
    return null;
}
```

## Hash法
创建一个哈希表，对于每一个元素 `element` ，我们首先查询哈希表中是否存在 `target - element`;

如果不存在，则将 `element` 及其下标作为键值对插入到哈希表中，即可保证不会让 `element` 和自己匹配。

如果存在，则证明两数之和已经存在，返回 `target - element` 和当前元素 `element` 的下标。
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> hashTable = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
        if (hashTable.containsKey(target - nums[i])) {
            return new int[]{i, hashTable.get(target - nums[i])};
        } else {
            hashTable.put(nums[i], i);
        }
    }
    return null;
}
```