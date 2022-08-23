
public class findproduct {//except that element arr[i]
    public static int[] findProduct(int[] arr){
        int temp=1;
        int[] result=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i]=temp;  //--> i left side of that element
            temp=temp*arr[i];
        }
        temp=1;
        for(int i=arr.length-1;i>=0;i--){
            result[i]=result[i]*temp;  // i <-- right of that element
            temp=temp*arr[i];
        }
        return result;
    }
    public static void main(String[] args){
        int arr[]={1,2,3,4};
        int result[]=findProduct(arr);
        System.out.println(result[1]);
    }
}
