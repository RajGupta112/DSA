class Solution {
    public String removeKdigits(String num, int k) {
       Stack<Character> st= new Stack<>();
       
       for(char digit:num.toCharArray()){
        while(!st.isEmpty() && k>0 && st.peek()>digit){
            st.pop();
            k--;
        }
        st.push(digit);
       }

       while(k>0 && !st.isEmpty()){
      st.pop();
      k--;
       }

       StringBuilder sb= new StringBuilder();
       for(char ch:st){ sb.append(ch);
       }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

       return sb.length() == 0 ? "0" : sb.toString();
    }
}