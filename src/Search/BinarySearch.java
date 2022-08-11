
package Search;

public class BinarySearch {
    public int binarySearch(int[] nums,int key){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==key){
                return mid;
            }
            if(nums[mid]>key){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
            
        }
        return -1;
    }
    //leetcode problem insert position in sorted array 
    public int searchInsert(int[] arr,int target){
         int low=0;
         int high=arr.length-1;
         while(low<=high){
             int mid=low+(high-low)/2;
             if(arr[mid]==target)return mid;
             if(target<arr[mid]){
                 high=mid-1;
             }
             else{
                 low=mid+1;
             }
            
         }
         return low;
    }
    public static void main(String[] args){
        BinarySearch bs=new BinarySearch();
        int[] nums={1,10,20,47,59,65,75,88,99};
        System.out.println(bs.binarySearch(nums,65));
        System.out.println(bs.searchInsert(nums, 77));
    }
}
