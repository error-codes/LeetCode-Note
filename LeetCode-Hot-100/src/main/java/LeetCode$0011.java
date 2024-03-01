/**
 * @A-作者 young
 * @D-时间 2024-02-21 15:44
 * @E-邮箱 PlutoYcr520@outlook.com
 * * -
 * @S-描述 :
 * * -
 * * -
 */
public class LeetCode$0011 {

    public int maxArea(int[] height) {
        int head = 0, tail = height.length - 1, maxArea = 0;
        while (head < tail) {
            int area = 0;
            if (height[head] > height[tail]) {
                area = height[tail] * (tail - head);
                tail--;
            } else {
                area = height[head] * (tail - head);
                head++;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
