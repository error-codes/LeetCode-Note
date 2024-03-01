import java.util.*;

public class LeetCode$0049 {

    // 排序穷举法
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

    // 计数法
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
                    builder.append('a' + i).append(counts[i]);
                }
            }

            String key = new String(builder);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        LeetCode$0049 leetCode$0049 = new LeetCode$0049();
        System.out.println(leetCode$0049.groupAnagramsCount(strs));
    }
}
