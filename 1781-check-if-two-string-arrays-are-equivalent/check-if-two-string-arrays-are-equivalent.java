class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
       
     StringBuilder res1 = new StringBuilder();
      for(String ch:word1){
        res1.append(ch);
      }
       StringBuilder res2= new StringBuilder();
        for(String ch:word2){
        res2.append(ch);
      }
      return res1.toString().equals(res2.toString());
    }
}