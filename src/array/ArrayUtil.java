
package array;

public class ArrayUtil {
    
    public static void printArray(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static int[] removeEven(int[] arr){
        int oddCount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                oddCount++;
            }
        }
        int[] result=new int[oddCount];
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                result[idx]=arr[i];
                idx++;
            }
        }
        return result;
    }
    public static void reverse(int[] numbers,int start,int end){
        while(start<end){
            int temp=numbers[start];
            numbers[start]=numbers[end];
            numbers[end]=temp;
            start++;
            end--;
        }
    }
    public int findMinimum(int[] arr){
        if(arr==null||arr.length==0){
            throw new IllegalArgumentException("Invalid input");
        }
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    public int findSecondMax(int[] arr){
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                secondMax=max;
                max=arr[i];
            }
            else if(arr[i]>secondMax&&arr[i]!=max){
                secondMax=arr[i];
            }
        }
        return secondMax;
    }
    //move zeros to end
    public void moveZeros(int[] arr,int n){
        int j=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0&&arr[j]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
    } 
    public int[] resize(int[] arr,int capacity){
        int temp[]=new int[capacity];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        return temp;
    }
    //from 1 to n
    public int findMissingNumber(int[] arr){
        int n=arr.length+1;
        int sum=n*(n+1)/2;
        for(int num : arr){
            sum=sum-num;
        }
        return sum;
    }
    public boolean isPalindrome(String word){
        char[] charArray=word.toCharArray();
        int start =0;
        int end=word.length()-1;
        
        while(start<end){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args){
        ArrayUtil au=new ArrayUtil();
        int[] arr={0,2,4,0,10,0,5};
        printArray(arr);
        //int[] result=removeEven(arr);
        //printArray(result);
        //reverse(arr,0,arr.length-1);
        //printArray(arr);
        au.moveZeros(arr,arr.length);
        printArray(arr);
        int[] original =new int[]{5,1,2,9,10};
        System.out.println("The Size of original array - "+original.length);
        original=au.resize(original,10);
        System.out.println("The Size of original array  after resize - "+original.length);
        
        if(au.isPalindrome("madam")){
            System.out.println("The String is palindrome!!");
        }
        else{
            System.out.println("The String is not Palindrome???");
        }
    } 
}
