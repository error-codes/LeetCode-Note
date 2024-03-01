import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @A-作者 young
 * @D-时间 2024-02-21 19:08
 * @E-邮箱 PlutoYcr520@outlook.com
 * * -
 * @S-描述 :
 * * -
 * * -
 */
public class LeetCode$0015 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for (int idx = 0; idx < nums.length; idx++) {
            // 当前元素大于 0，那么后面的 L 和 R 一定也大于 0
            if (nums[idx] > 0) {
                break;
            }
            // 证明和前一个数相等，进行去重
            if (idx > 0 && nums[idx] == nums[idx - 1]) {
                continue;
            }
            int L = idx + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[idx] + nums[L] + nums[R];
                if (sum < 0) {
                    L++;
                }
                if (sum > 0) {
                    R--;
                }
                if (sum == 0) {
                    answer.add(Arrays.asList(nums[idx], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                }
            }
        }
        return answer;
    }
}
