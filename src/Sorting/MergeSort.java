
package Sorting;

public class MergeSort {
    public void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void sort(int[] arr,int[] temp,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            sort(arr,temp,low,mid);
            sort(arr,temp,mid+1,high);
            merge(arr,temp,low,mid,high);
        }
    }
    private void merge(int[] arr,int[] temp,int low,int mid,int high){
        for(int i=low;i<=high;i++){
            temp[i]=arr[i];
        }
        int i=low;//traverse left sorted array
        int j=mid+1;//traverse right sorted array
        int k=low;//wiil merge both array into original array(arr)
        
        while(i<=mid&&j<=high){
            if(temp[i]<temp[j]){
                arr[k]=temp[i];
                i++;
            }
            else{
                arr[k]=temp[j];
                j++;
            }
            k++;
        }
        while(i<=mid){//if right array is exhausted(j>high)
            arr[k]=temp[i];
            k++;i++;
        }
        //not need for if left array is exhausted (i>mid)
                
    }
    public static void main(String[] args){
        MergeSort ms=new MergeSort();
        int[] arr=new int[] {9,5,2,4,3};
        ms.sort(arr,new int[arr.length], 0,arr.length-1);
        ms.printArray(arr);
    }
}
