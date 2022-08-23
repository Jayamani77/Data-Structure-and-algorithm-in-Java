
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class maxSlidingWindow {
    // max in sliding window
    public List<Integer> maxSlidingWindows(int[] arr,int k){
        int[] ngeArr=nextGreaterElement(arr);
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<=arr.length-k;i++){
            int max=arr[i];
            int j=i;
            while(ngeArr[j]<i+k){
                j=ngeArr[j];
            }
            result.add(arr[j]);
        }
        return result;
        
    }
    private int[] nextGreaterElement(int[] arr){
        int[] result=new int[arr.length];
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(!stack.isEmpty()){
                while(!stack.isEmpty()&&arr[stack.peek()]<=arr[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i]=arr.length;
            }
            else{
                result[i]=stack.peek();
            }
            stack.push(i);
        }
        return result;
        
    }
   public static void main(String[] args){
       maxSlidingWindow msw=new maxSlidingWindow();
       int[] arr={44,77,33,44,88,11};
       System.out.println(msw.maxSlidingWindows(arr,3));
   } 
}
