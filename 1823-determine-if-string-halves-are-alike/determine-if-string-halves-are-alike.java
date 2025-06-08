class Solution {
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int size=n/2;
        int i=0,j=size;
        int countl=0,countr=0;

        Set<Character> p= new HashSet<>();
        String vowels="aeiouAEIOU";
        for(char c:vowels.toCharArray()){
            p.add(c);
        }

        while(i<size && j<n){
            if(p.contains(s.charAt(i))) countl++;
            if(p.contains(s.charAt(j))) countr++;
            i++;
            j++;
        }
        return countl==countr;
    }
}