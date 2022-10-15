import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args){
        
        LongestConsecutiveSequence longest = new LongestConsecutiveSequence();
        System.out.println(longest.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longest.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longest.longestConsecutive(new int[]{0}));
        System.out.println(longest.longestConsecutive(new int[]{}));
    }

    // 2022.10.15 
    public int longestConsecutive(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();

        for(int n: nums) numsSet.add(n);

        int longest = 0;
        for(int n: nums){
            int counter = 1;
            // Find and count next value, if n not have previous value
            if(!numsSet.contains(n-1)){
                int nextValue = n+1;
                while(numsSet.contains(nextValue)){
                    counter++;
                    nextValue++;
                }
            }
            if(counter > longest) longest = counter;
        }


        return longest;
    }
}