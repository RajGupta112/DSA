class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    Map<String ,List<String>> map= new HashMap<>();
    for(String ch:strs){
        char[] charArray= ch.toCharArray();
        Arrays.sort(charArray);
        String s= new String(charArray);
        if(!map.containsKey(s)){
            map.put(s,new ArrayList<>());
        }
        map.get(s).add(ch);
    }
    return new ArrayList<>(map.values());
    }
}