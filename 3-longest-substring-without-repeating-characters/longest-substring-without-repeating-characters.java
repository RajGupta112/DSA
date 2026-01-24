import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n=s.length();
       int max=0;

       for(int i=0;i<n;i++){
        HashSet<Character> l= new HashSet<>();
        for(int j=i;j<n;j++){
            char ch=s.charAt(j);
            if( l.contains(ch)){
                break;
            }
            l.add(ch);
           
        }
        max=Math.max(max,l.size());
       }
       return max;

    }
}
