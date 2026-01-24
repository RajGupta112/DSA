import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int max=0;
        int low=0;
        int high=0;
         HashSet<Character> l = new HashSet<>();
   while(high<n){
        char ch=s.charAt(high);
        
        while(l.contains(ch)){

            l.remove(s.charAt(low));
            low++;
        }
        l.add(ch);
        max=Math.max(max,high-low+1);
        high++;
      }
      return max;
    }
}
