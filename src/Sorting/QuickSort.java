
package Sorting;


public class QuickSort {
    public void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void sort(int[]arr,int low,int high){
        if(low<high){
            int p=partition(arr,low,high);
            sort(arr,low,p-1);
            sort(arr,p+1,high);
        }
    }
    private int partition(int[] arr,int low,int high){
        int pivot=arr[high];//our wish to take any 
        int i=low,j=low;
        while(i<=high){
            if(arr[i]<=pivot){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
            i++;       
        }
        return j-1;
    }
    //low to j-1 (smaller than or equal to pivot)
    //j to i-1 (greater than pivot)
    public static void main(String[] args){
        int arr[]={5,2,0,1,6,3};
        QuickSort qs=new QuickSort();
        qs.sort(arr, 0, arr.length-1);
        qs.printArray(arr);
    }
}
