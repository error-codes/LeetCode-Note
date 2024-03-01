import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @A-作者 young
 * @D-时间 2024-02-20 13:19
 * @E-邮箱 PlutoYcr520@outlook.com
 * * -
 * @S-描述 :
 * * -
 * * -
 */
public class LeetCode$0128 {

    // 暴力法
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

    /**
     * 经过观察上面的暴力法，我们发现存在重复的计算，如果数组为【1，2，3】
     * 1 计算后，其实囊括了 2 和 3，所以其实没有必要再去循环计算 2 和 3 的序列
     * <p>
     * 观察后可得，如果当前的元素，存在一个前继连续元素，那么这个元素没有必要再进行计算
     */
    public int longestConsecutiveHashSet(int[] nums) {
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

    public static void main(String[] args) {
        LeetCode$0128 leetCode$0128 = new LeetCode$0128();
        int[] ints = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(leetCode$0128.longestConsecutiveHashSet(ints));
    }
}
