class Solution {
    public int totalFruit(int[] fruits) {
       int n=fruits.length;
       int max=0;
      HashMap<Integer,Integer> map= new HashMap<>();
       int low=0,high=0;
       while(high<n){
      map.put(fruits[high],map.getOrDefault(fruits[high],0)+1);
      while(map.size()>2){
        map.put(fruits[low],map.get(fruits[low])-1);
        if(map.get(fruits[low])==0){
            map.remove(fruits[low]);
        }
        low++;
      }
      max=Math.max(max,high-low+1);
      high++;
       }
       
       return max;
    }
}