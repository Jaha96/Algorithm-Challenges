import java.util.Map;
import java.util.HashMap;


/* 
 * 451. Sort Characters By Frequency
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 * Return the sorted string. If there are multiple answers, return any of them.
 * 
 * Input: s = "tree"
 * Output: "eert"
 * 
 * Input: s = "cccaaa"
 * Output: "aaaccc"
*/
public class SortCharactersByFrequency {
    public static void main(String[] args){
        SortCharactersByFrequency program = new SortCharactersByFrequency();
        System.out.println(program.frequencySort("cccaaa"));
        System.out.println(program.frequencySort("tree"));
        System.out.println(program.frequencySort("Aabb"));
    }

    // 2022.10.11 Bucket sort
    public String frequencySort(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch: s.toCharArray())  map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        String[] bucket = new String[s.length() + 1];
        
        for(char key: map.keySet()){
            int val = map.get(key);
            if(bucket[val] == null) bucket[val] = "";
            int counter = val;
            while(counter-- > 0)    bucket[val] += key;
        }
        
        String result = "";
        for(int i=s.length(); i>0; i--){
            if(bucket[i] != null){
                result += bucket[i];
            }
        }
        
        return result;
    }
}
