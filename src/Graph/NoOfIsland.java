
package Graph;
// leetcode problem
public class NoOfIsland {
    public int numIsLand(char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int numOfIslands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    dfs(grid,i,j,visited);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
    public void dfs(char[][] grid,int row,int col,boolean[][] visited){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||
                visited[row][col]||grid[row][col]=='0'){
            return;
        }
            
        visited[row][col]=true;
        dfs(grid,row,col-1,visited);//left
        dfs(grid,row-1,col,visited);//up
        dfs(grid,row,col+1,visited);//right
        dfs(grid,row+1,col,visited);//down
    }
    public static void main(String[] args){
        NoOfIsland isl=new NoOfIsland();
        char[][] grid={{'1','1','0','0'},
                       {'1','0','0','0'},
                       {'0','0','1','0'},
                       {'0','0','0','1'}   
                       };
        
        System.out.println(isl.numIsLand(grid));
            
        
        
    }
}
