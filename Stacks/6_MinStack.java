/*
LC: 155. Min Stack

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

*/


class MinStack {

    /** initialize your data structure here. */
    
    Stack<Integer> s;
    int min_e;
    public MinStack() {
         s = new Stack<Integer>();
         min_e = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x <= min_e){
            s.push(min_e);
            min_e = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if(s.pop()== min_e){
            min_e = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min_e;
    }
    
    /*public void printStack(Stack res, String c){
        System.out.println("From : "+ c);
        Iterator value = res.iterator(); 
        while(value.hasNext()){
            System.out.println(value.next());
        }
    }*/
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */