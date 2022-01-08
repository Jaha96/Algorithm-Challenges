public class LongestSubstringNoRepeat {
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("p"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s){
        if (s.length() < 2) return s.length();

        int longest = 1;
        String longestSubString;
        for(int i=0;i<s.length() - 1;i++){
            longestSubString = String.valueOf(s.charAt(i));
            for(int j=i+1; j<s.length(); j++){
                if (longestSubString.indexOf(s.charAt(j)) == -1){
                    longestSubString += s.charAt(j);
                    if (longestSubString.length() > longest)
                        longest = longestSubString.length();
                }
                else
                    break;
            }

        }
        return longest;
    }
}
