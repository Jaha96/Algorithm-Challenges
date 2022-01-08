import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeat {
    public static void main(String[] args){
//        System.out.println(lengthOfLongestSubstring(""));
//        System.out.println(lengthOfLongestSubstring("p"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> m = new HashMap<>();
        for(int j=0, i=0; j<n; j++){
            if(m.containsKey(s.charAt(j))){
                i = Math.max(m.get(s.charAt(j)), i);
            }
            m.put(s.charAt(j), j + 1);
            ans = Math.max(j - i + 1, ans);
        }
        return ans;
    }
}
