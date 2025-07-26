class Solution {
    public int countGoodSubstrings(String s) {
        int count=0;
        for(int i=0;i<=s.length()-3;i++){
     char A=s.charAt(i);
     char B=s.charAt(i+1);
     char C= s.charAt(i+2);
       
       if(A!=B && B!=C && C!=A){
        count++;
       }
        }
        return count;
    }
}