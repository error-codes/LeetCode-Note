import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode$0001 {

    // 哈希
    public int[] twoSumHash(int[] nums, int target) {
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

    // 暴力法
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

    public static void main(String[] args) {
        LeetCode$0001 solution = new LeetCode$0001();
        System.out.println(Arrays.toString(solution.twoSum(new int[]{3, 2, 4}, 6)));
    }
}