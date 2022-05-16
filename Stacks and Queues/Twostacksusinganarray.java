class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        //Pushing and poping elements in stack s1
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(s1.size() != 0){
                    s1.pop();
                }
            }
            else{
                s1.push(s.charAt(i));
            }
        }
        //Pushing and poping elements in stack s2
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(s2.size() != 0){
                    s2.pop();
                }
                
            }
            else{
                s2.push(t.charAt(i));
            }
        }
        
        if((s1.toString()).equals(s2.toString())){//Converting stack to string and then comparing them
            return true;
        }
        
        return false;
    }
}
