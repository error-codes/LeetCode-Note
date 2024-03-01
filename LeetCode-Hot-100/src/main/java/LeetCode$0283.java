/**
 * @A-作者 young
 * @D-时间 2024-02-20 15:04
 * @E-邮箱 PlutoYcr520@outlook.com
 * * -
 * @S-描述 :
 * * -
 * * -
 */
public class LeetCode$0283 {

    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int nonZero = 0; nonZero < nums.length; nonZero++) {
            if(nums[nonZero] != 0) {
                int temp = nums[nonZero];
                nums[nonZero] = nums[zero];
                nums[zero] = temp;
            }
        }
    }
}
