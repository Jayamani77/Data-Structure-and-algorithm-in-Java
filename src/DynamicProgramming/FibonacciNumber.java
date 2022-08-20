
package DynamicProgramming;

public class FibonacciNumber {
    /*public int fib(int n){
        if(n==0)return 0;
        if(n==1)return 1;   plain recursion
        int left=fib(n-1);
        int right=fib(n-2);
        return left+right; 
    }*/ 
    //bottom up appoarch
    public int fib(int n){
        int[] table=new int[n+1];
        
        table[0]=0;
        table[1]=1;
        
        for(int i=2;i<=n;i++){
            table[i]=table[i-1]+table[i-2];
        }
        return table[n];
    }
    //top down approach
    public int fib(int[] memo,int n){
        if(memo[n]==0){
            if(n<2){
                memo[n]=n;//0 and 1
            }
            else{
                int left=fib(memo,n-1);
                int right=fib(memo,n-2);
                memo[n]=left+right;
            }
        }
        return memo[n];
    }
    public static void main(String[] args){
        FibonacciNumber fn=new FibonacciNumber();
        System.out.println(fn.fib(new int[6+1],6));
    }
}
