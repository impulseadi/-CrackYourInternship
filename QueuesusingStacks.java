class MyQueue {
 
    Stack <Integer> s1;
    Stack <Integer> s2;
    
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
        
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        while(s1.empty()==false){
            s2.push(s1.pop());
        }
        int ans=s2.pop();
        while(s2.empty()==false){
            s1.push(s2.pop());
        }
        return ans;
    }
    
    public int peek() {
                while(!s1.empty())
        {
            s2.push(s1.pop());
        }
        
        //TAKE THE VAL OF TOP OF STACK 
        //STORE IN ANS 
        int ans = s2.peek();
        
         //TRANSFER ALL THE ELEMENTS FORM S2 TO S1
        //AND CONTINUE
        while(!s2.empty())
        {
            s1.push(s2.pop());
        }
        
         //RETURN ANS
        return ans;
 
    }
    
    public boolean empty() {
       if(s1.empty())
        {
            return true;
        }
        
        //RETURN FALSE
        return false;
    }
    }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
