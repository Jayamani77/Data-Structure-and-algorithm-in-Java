
public class ArrangeMaxMin {
    //1-max 2-min 3-second max in sorted array
    public void printArray(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void arrangeMaxMin(int[] arr){
        int maxIdx=arr.length-1;
        int minIdx=0;
        int max=arr[maxIdx]+1;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){//even index has max value
                arr[i]=arr[i]+(arr[maxIdx]%max)*max;
                maxIdx--;
            }
            else{//odd index has min value
                arr[i]=arr[i]+(arr[minIdx]%max)*max;
                minIdx++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]/max;
        }
    }
    public static void main(String[] args){
        ArrangeMaxMin amm=new ArrangeMaxMin();
        int arr[]={2,3,5,6,7};
        amm.arrangeMaxMin(arr);
        amm.printArray(arr);
    }
}
