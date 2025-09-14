class Solution {
    public boolean isValid(String s) {
        Stack<Character> st= new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch== '[' || ch=='{'){
                st.push(ch);
            }else{
                if(st.isEmpty())  return false;
                char val=st.peek();

                if(ch==')' && val=='('
                || ch==']' && val=='[' ||
                ch=='}' && val=='{'){
                    st.pop();
                } 
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}