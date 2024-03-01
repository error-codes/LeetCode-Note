import java.util.Stack;

/**
 * @A-作者 young
 * @D-时间 2024-02-22 13:32
 * @E-邮箱 PlutoYcr520@outlook.com
 * * -
 * @S-描述 :
 * * -
 * * -
 */
public class LeetCode$0042 {

    // 层级计算
    public int trapRow(int[] height) {
        int maxHeight = 0;
        for (int k : height) {
            if (k > maxHeight) {
                maxHeight = k;
            }
        }

        int sum = 0;
        for (int i = 1; i <= maxHeight; i++) {
            boolean hole = false;
            int temp = 0;
            for (int j = 0; j < height.length; j++) {
                if (hole && height[j] < i) {
                    temp++;
                }
                if (height[j] >= i) {
                    hole = true;
                    sum += temp;
                    temp = 0;
                }
            }
        }
        return sum;
    }

    // 列计算
    public int trapColumn(int[] height) {

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxL = 0, maxR = 0;
            for (int j = 0; j < i; j++) {
                if (maxL < height[j]) {
                    maxL = height[j];
                }
            }

            for (int k = i + 1; k < height.length; k++) {
                if (maxR < height[k]) {
                    maxR = height[k];
                }
            }

            if (maxL > height[i] && maxR > height[i]) {
                int low = Math.min(maxL, maxR);
                sum += low - height[i];
            }
        }

        return sum;
    }

    // 动态规划法
    public int trapDP(int[] height) {
        int sum = 0;

        int[] maxL = new int[height.length];
        int[] maxR = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            maxL[i] = Math.max(maxL[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < maxL[i] && height[i] < maxR[i]) {
                sum += Math.min(maxL[i], maxR[i]) - height[i];
            }
        }
        return sum;
    }

    // 双指针
    public int trap(int[] height) {
        int sum = 0;

        int left = 0, right = height.length - 1;
        int maxL = 0, maxR = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                maxL = Math.max(maxL, height[left]);
                sum += maxL - height[left];
                left++;
            } else {
                maxR = Math.max(maxR, height[right]);
                sum += maxR - height[right];
                right--;
            }
        }
        return sum;
    }

    // 单调栈
    public int trapStack(int[] height) {
        int sum = 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(height[0]);

        for (int i = 1; i < height.length - 1; i++) {
            if (height[i] < stack.peek()) {
                stack.add(height[i]);
            } else if (height[i] > stack.peek()) {
                Integer cur = stack.pop();
                Integer left = stack.peek();
                sum += left - cur;
                stack.push(height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        LeetCode$0042 leetCode$0042 = new LeetCode$0042();
        System.out.println(leetCode$0042.trapStack(height));
    }
}
