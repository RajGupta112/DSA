class Solution {
    public int characterReplacement(String s, int k) {
int n=s.length();
int fre[] = new int[26];
int maxLength=0;
int maxFreq=0;
int low=0,high=0;
while(high<n){
    char ch=s.charAt(high);
    fre[ch-'A']++;
    maxFreq=Math.max(maxFreq,fre[ch-'A']);
    while((high-low+1)-maxFreq>k){
        fre[s.charAt(low)-'A']--;
        low++;
    }
    maxLength=Math.max(maxLength,high-low+1);
    high++;
}

return maxLength;
    }
}
