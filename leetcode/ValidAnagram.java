import java.util.HashMap;

public class ValidAnagram {

    /*
     * 242. Valid Anagram
     * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

        An Anagram is a word or phrase formed by rearranging the 
        letters of a different word or phrase, 
        typically using all the original letters exactly once.
        Input: s = "anagram", t = "nagaram"
        Output: true

     */
    public static void main(String[] args){
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    // 2022.10.05 10:25 does not accepted
    public static boolean isAnagram_backup1(String s, String t) {
        
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(mapS.containsKey(s.charAt(i))){
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
            }else{
                mapS.put(s.charAt(i), 1);
            }

            if(mapT.containsKey(t.charAt(i)))
                mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
            else
                mapT.put(t.charAt(i), 1);
        }

        if(mapS.size() != mapT.size())
            return false;

        for(Character key: mapS.keySet()){
            if(!mapT.containsKey(key))
                return false;
            
            if(mapS.get(key) != mapT.get(key))
                return false;
        }
        return true;
    }
    

    // 2022.10.05 ASCII code solution
    public static boolean isAnagram_backup2(String s, String t){

        if(s.length() != t.length()) return false;

        int[] container = new int[26];
        for(int i=0; i<s.length(); i++){
            container[s.charAt(i) - 'a'] ++;
            container[t.charAt(i) - 'a'] --;
        }

        for(int n: container)
            if (n!=0) return false;
        
        return true;
    }

    // 2022.10.17
    public static boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        char[] res = new char[26];
        for(int i=0; i<s.length();i++){
            res[s.charAt(i) - 'a']++;
            res[t.charAt(i) - 'a']--;
        }
        
        for(char r: res){
            if(r != 0)
                return false;
        }
        
        return true;
    }
}
