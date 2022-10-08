import java.util.List;
import java.util.ArrayList;

public class GroupAnagrams {


    /*
     * 49. Group Anagrams
     * 
     * Given an array of strings strs, group the anagrams together. 
     * You can return the answer in any order.
     * 
     * 
     *  Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    public static void main(String[] args){

        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }

    private static boolean isAnagram(String str1, String str2){
        if (str1.length() != str2.length())
            return false;

        int[] alphabets = new int[26];
        for(int i=0; i<str1.length();i++){
            alphabets[str1.charAt(i) - 'a']++;
            alphabets[str2.charAt(i) - 'a']--;
        }

        for(int letter: alphabets){
            if(letter != 0)
                return false;
        }

        return true;
    }
    

    // 2022.10.08 Almost brute force
    public static List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        
        if(strs.length == 0)
            return result;
        
        List<String> subList = new ArrayList<>();
        if(strs.length == 1){
            subList.add(strs[0]);
            result.add(subList);
            return result;
        }
            
        
        subList.add(strs[0]);
        result.add(subList);
        
        for(int i=1; i<strs.length; i++){
            
            String currentStr = strs[i];
            for(List<String> group: result){
                if(isAnagram(currentStr, group.get(0))){
                    group.add(currentStr);
                    currentStr = "-1";
                    break;
                }
            }
            
            //  If currentStr not anagram of any groups, create new group      
            if(!"-1".equals(currentStr)){
                subList = new ArrayList<>();
                subList.add(strs[i]);
                result.add(subList);
            }
        }
        
        return result;
        
    }
}
