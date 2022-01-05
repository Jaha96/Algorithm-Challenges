import java.util.HashMap;
//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
//
//        Example 1:
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
//
//        Example 2:
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
//
//        Constraints:
//        1 <= strs.length <= 200
//        0 <= strs[i].length <= 200
//        strs[i] consists of only lower-case English letters.



public class LongestCommonPrefix {
    public static void main(String[] args){
//        System.out.println("Result: " + longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println("Result: " + longestCommonPrefix(new String[]{"dog","racecar","car"}));
//        System.out.println("Result: " + longestCommonPrefix(new String[]{"jaha","habas","japar", "hapar", "hapsatar"}));
        System.out.println("Result: " + longestCommonPrefix(new String[]{"ab", "a"}));
    }
    public static String commonPrefix(String a, String b){
        String commons = null;
        int len = a.length() > b.length() ? b.length() : a.length();
        for(int i=1; i<=len; i++){
            if (a.substring(0, i).equals(b.substring(0, i)))
                commons = a.substring(0,i);
        }
        return commons;
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        HashMap<String, Integer> commonCounts = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            for(int j=i+1; j<strs.length; j++){
                String commonPrefix = commonPrefix(strs[i], strs[j]);
                if(commonPrefix != null){
                    if (commonCounts.containsKey(commonPrefix))
                        commonCounts.put(commonPrefix, commonCounts.get(commonPrefix) + 1);
                    else
                        commonCounts.put(commonPrefix, 1);
                }
                System.out.println(strs[i] +", "+strs[j]);
            }
        }
        if(commonCounts.isEmpty())
            return "";
        else {
            int max = 0;
            String retStr = "";
            for(String key: commonCounts.keySet()){
                if(commonCounts.get(key) > max){
                    max = commonCounts.get(key);
                    retStr = key;
                }
            }

            return retStr;
        }
    }
}
