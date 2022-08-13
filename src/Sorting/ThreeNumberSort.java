
package Sorting;
//problem 0's ,1's ,2's dutch flag
public class ThreeNumberSort {
    public void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void sort(int[] arr){
        int i=0,j=0,k=arr.length-1;
        while(i<=k){
            if(arr[i]==0){
                swap(arr,i,j);
                i++;
                j++;
            }
            else if(arr[i]==1){
                i++;
            }
            else if(arr[i]==2){
                swap(arr,i,k);
                k--;
            }
        }
    }
    public void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
        ThreeNumberSort tms=new ThreeNumberSort();
        int arr[]={2,0,2,2,0,1,1};
        tms.sort(arr);
        tms.printArray(arr);
    }
}
