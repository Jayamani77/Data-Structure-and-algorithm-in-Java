
package Matrix;

public class Matrix {
    public void search(int[][] matrix,int n,int x){
        int i=0;
        int j=n-1;
        
        while(i<n&&j>=0){
            if(matrix[i][j]==x){
                System.out.println("X is found at - "+i+","+j);
                return;
            }
            if(matrix[i][j]>x){
                j--;
            }
            else{
                i++;
            }
            
        }
        System.out.println("Value not found "); 
    }
    //Spiral form
    public void spiralPrint(int[][] matrix,int r,int c){
        int i,l=0,k=0;
        while(k<r&&l<c){
            for(i=l;i<c;i++){
                System.out.print(matrix[k][i]+" ");
            }
            k++;
            for(i=k;i<r;i++){
                System.out.print(matrix[i][c-1]+" ");
            }
            c--;
            //if(k<r){
                for(i=c-1;i>=l;i--){
                    System.out.print(matrix[r-1][i]+" ");
                }
                r--;
            //}
            //if(l<c){
                for(i=r-1;i>=k;i--){
                    System.out.print(matrix[i][l]+" ");
                }
                l++;
            //}
        }
    }
   public static void main(String[] args){
       int[][] matrix={
                       {10,20,30,40},
                       {15,25,35,45},
                       {27,29,37,48},
                       {32,33,39,51}
                      };
       
       Matrix sm=new Matrix();
       
       sm.search(matrix,matrix.length, 32);
       
       sm.spiralPrint(matrix,4, 4);
   } 
}
