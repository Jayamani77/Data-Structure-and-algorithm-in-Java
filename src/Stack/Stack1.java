
package Stack;
import java.util.Stack;
import java.util.EmptyStackException;

public class Stack1 {
    
    private ListNode top;
    private int length;
    
    private class ListNode{
        private int data;
        private ListNode next;
        
        public ListNode(int data){
            this.data=data;
        }
    }
    public Stack1(){
        top=null;
        length=0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public void push(int data){
        ListNode temp=new ListNode(data);
        temp.next=top;
        top=temp;
        length++;
    }
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result=top.data;
        top=top.next;
        length--;
        return result;
    }
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
    public static String reverse(String str){
        Stack<Character> stack=new Stack<>();
        char[] chars=str.toCharArray();
        
        for(char c:chars){
            stack.push(c);
        }
        
        for(int i=0;i<str.length();i++){
            chars[i]=stack.pop();
        }
        return new String(chars);
    }
    //nextGreater element for current element
    public int[] nextGreaterElement(int[] arr){
        int[] result=new int[arr.length];
        Stack<Integer> stack =new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty()&&stack.peek()<=arr[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i]=-1;
            }
            else{
               result[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
    //check brackets are balanced
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    char top=stack.peek();
                    if((c==')'&& top=='(')
                        ||(c=='}'&& top=='{')
                            ||(c==']'&& top=='[')){
                        
                        stack.pop();
                    }
                    else{
                        return false;
                    } 
                }
            }
        }
        return stack.isEmpty();
    }
   public static void main(String[] args){
       Stack1 stack=new Stack1();
       stack.push(10);
       stack.push(15);
       stack.push(20);
       
       System.out.println(stack.peek());
       stack.pop();
       System.out.println(stack.peek());
       
       String str="ABCD";
       System.out.println(reverse(str));
       
       System.out.println(stack.isValid("{(}"));
       
   } 
}
