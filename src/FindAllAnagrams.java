import java.util.List;
import java.util.ArrayList;
/*
 * 438. Find All Anagrams in a String
 * 
 * Given two strings s and p, 
 * return an array of all the start indices of p's anagrams in s. 
 * You may return the answer in any order.
 * 
    An Anagram is a word or phrase formed by rearranging 
    the letters of a different word or phrase, 
    typically using all the original letters exactly once.


    Input: s = "abab", p = "ab"
    Output: [0,1,2]
    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 */


public class FindAllAnagrams {
    public static void main(String[] args){
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static boolean isAnagram(String s, String p){

        if(s.length() != p.length())    return false;
        int[] container = new int[26];
        for(int i=0; i<s.length(); i++){
            container[s.charAt(i) - 'a'] ++;
            container[p.charAt(i) - 'a'] --;
        }

        for(int count: container) if(count !=0) return false;

        return true;
    }

    // 2022.10.05 Brute force
    public static List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length())
            return result;

        int p1 = 0;
        int p2 = p.length();

        while(p2 <= s.length()){
            if(isAnagram(s.substring(p1, p2), p))
                result.add(p1);
            p1++;
            p2++;
        }
        return result;
    }
}
