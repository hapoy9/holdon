
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: guoyongkui
 * @date: 2020/5/6 22:01
 * @projectName: holdon
 * @description:
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s){
        int result = 0;
        List<Character> list = new ArrayList<>();
        int j = 0;
        boolean isEnd = false;
        while (j < s.length()){
            for (int i = j; i<s.length(); i++){
                if (list.contains(s.charAt(i))){
                    if (list.size() > result){
                        result = list.size();
                    }
                    j = j + list.indexOf(s.charAt(i)) + 1;
                    list.clear();
                    break;
                }else {
                    list.add(s.charAt(i));
                    if ((i +1) == s.length()){
                        isEnd = true;
                    }
                }
            }
            if (isEnd) {
                if (list.size() > result){
                    result = list.size();
                }
                break;
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring1(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("a"));
    }

}
