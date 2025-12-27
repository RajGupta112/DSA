class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int Maxfruits=Integer.MIN_VALUE;
        Map<Integer,Integer> basket= new HashMap<>();
        int  low=0,high=0;
        while(high<n){
            basket.put(fruits[high],basket.getOrDefault(fruits[high],0)+1);
            while(basket.size()>2){
                basket.put(fruits[low],basket.get(fruits[low])-1);
                if(basket.get(fruits[low])==0){
                    basket.remove(fruits[low]);
                }
                low++;
            }
            Maxfruits=Math.max(Maxfruits,high-low+1);
            high++;
        }
        return Maxfruits;
    }
}