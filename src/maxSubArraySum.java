
public class maxSubArraySum { //window slinding
    public int maxSubArray(int[] arr,int k){
        int maxSum=0;
        int windowSum=0;
        int start=0;
        //sum of first k element
        //subtract(1 element goes out)
        //Add (1 element comes in)
        for(int end=0;end<arr.length;end++){
            windowSum=windowSum+arr[end];
            if(end>=k-1){
                maxSum=Math.max(maxSum,windowSum);
                windowSum=windowSum-arr[start];
                start++;
            }
        }
        return maxSum;
    }
    public static void main(String[] args){
        maxSubArraySum ms=new maxSubArraySum();
        int[] arr={2,7,3,5,8,1};
        System.out.println(ms.maxSubArray(arr, 3));
    }
}
