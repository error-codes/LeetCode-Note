import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @A-作者 young
 * @D-时间 2024-02-29 17:42
 * @E-邮箱 PlutoYcr520@outlook.com
 * * -
 * @S-描述 :
 * * -
 * * -
 */
public class LeetCode$0003 {

    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (queue.contains(c)) {
                queue.remove();
            }
            queue.add(c);
            longest = Math.max(queue.size(), longest);
        }
        return queue.size();
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LeetCode$0003 leetCode$0003 = new LeetCode$0003();
        System.out.println(leetCode$0003.lengthOfLongestSubstring(s));
    }
}
