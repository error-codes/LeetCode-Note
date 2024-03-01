# [LeetCode]-0049 字母异位词分组

给你一个字符串数组，请你将 **字母异位词** 组合在一起。可以按任意顺序返回结果列表。

**字母异位词** 是由重新排列源单词的所有字母得到的一个新单词。

* **示例 1**:
> **输入**: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
> 
> **输出**: [["bat"],["nat","tan"],["ate","eat","tea"]]

* **示例 2**:
> **输入**: strs = [""]
> 
> **输出**: [[""]]

* **示例 3**:
> **输入**: strs = ["a"]
> 
> **输出**: [["a"]]

* **提示**：
  * `1 <= strs.length <= 104`
  * `0 <= strs[i].length <= 100`
  * `strs[i] 仅包含小写字母`

## 排序法
互为字母异位词的两个字符串包含的字母一定相同，只是内部罗列顺序不同，通过对每个字符串进行重新的排序，使其都采用同一种排序方式。

此时经过排序后的字符串，互为字母异位词的一定是相同的字符串，所以我们将排序后的字符串作为 `key`，源字符串保存至列表中，并将列表整体作为 `value`，构建一个 Map 集合。
```java
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String key = new String(charArray);
        List<String> list = map.getOrDefault(key, new ArrayList<>());
        list.add(str);
        map.put(key, list);
    }
    return new ArrayList<>(map.values());
}
```

## 计数法
通过观察可以得知所有的字符串都为小写字母，可以通过构建一个大小为 26 的数组，统计字符串中每个字符出现的次数，对一个字符串进行统计。

而同样在构建一个 `key` 时，我们将字母出现的顺序和次数挨个罗列，如 `eat` 和 `tea`，经过排序后在数组中都会是 `[a1...e1...t1]` 形式。

```java
public List<List<String>> groupAnagramsCount(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
        int[] counts = new int[26];
        int length = str.length();
        for (int i = 0; i < length; i++) {
            counts[str.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                builder.append('a' + i);
                counts[i]--;
            }
        }

        String key = new String(builder);
        List<String> list = map.getOrDefault(key, new ArrayList<>());
        list.add(str);
        map.put(key, list);
    }
    return new ArrayList<>(map.values());
}
```