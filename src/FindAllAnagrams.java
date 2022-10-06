import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
        System.out.println(findAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
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

    public static boolean isAnagram(Map<Character, Integer> mapS, Map<Character, Integer> mapP){
    
        if(mapS.size() != mapP.size()) return false;
        
        for(Character key: mapS.keySet()){
            if(!mapP.containsKey(key))
                return false;
            
            if(mapP.get(key) != mapS.get(key))
                return false;
        }
        return true;
    }

    // 2022.10.05 Brute force
    public static List<Integer> findAnagrams_backup1(String s, String p) {
        
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

    // 2022.10.06 Sliding window, Not passed
    // Learned lesson: Give appropriate variable names.
    public static List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        if(s.length() < p.length()) return result;
        
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapP = new HashMap<>();
        
        for(int i=0; i<p.length(); i++){
            if(mapP.containsKey(p.charAt(i))){
                mapP.put(p.charAt(i), mapP.get(p.charAt(i)) + 1);
            }else{
                mapP.put(p.charAt(i), 1);
            }
            
            if(mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
            }else{
                mapS.put(s.charAt(i), 1);
            }
        }
        
        int left = 0;
        if(isAnagram(mapS, mapP))
            result.add(left);
        
        for(int right = p.length();right<s.length();right++){
            
            // Removing left char of s
            if(mapS.get(s.charAt(left)) <= 1)
                mapS.remove(s.charAt(left));
            else
                mapS.put(s.charAt(left), mapS.get(s.charAt(left)) - 1);
            
            left++;

            // Adding right char of s
            if(mapS.containsKey(s.charAt(right)))
                mapS.put(s.charAt(right), mapS.get(s.charAt(right)) + 1);
            else
                mapS.put(s.charAt(right), 1);
            
            // mapS updated, now check is anagram with mapP
            if(isAnagram(mapS, mapP))
                result.add(left);
        }
        
        return result;

    }
}
