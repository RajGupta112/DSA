class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int index=0;
        int i=0;
        while(i<n){
            int count=0;
            char curr_char=chars[i];
            while(i<n && chars[i]== curr_char){
                count++;
                i++;
            }
            chars[index++]=curr_char;
            if(count>1){
                String count_str=String.valueOf(count);
                for(char ch:count_str.toCharArray() ){
                    chars[index++]=ch;
                }
            }
        }
        return index;
    }
}