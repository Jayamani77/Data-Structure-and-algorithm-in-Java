
package Graph;
// undirected graph
public class Graph {
    private int V;
    private int E;
    private int[][] adjMatrix;
    
    public Graph(int nodes){
        this.V=nodes;
        this.E=0;
        this.adjMatrix=new int[nodes][nodes];
    }
 
    public void addEdges(int u,int v){
        adjMatrix[u][v]=1;
        adjMatrix[v][u]=1;//undirected graph
        E++;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(V+" vertices"+E+" edges "+"\n");
        for(int v=0;v<V;v++){
            sb.append(v+": ");   
            for(int w:adjMatrix[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
   public static void main(String[] args){
       Graph g=new Graph(4);
       g.addEdges(0,1);
       g.addEdges(1,2);
       g.addEdges(2,3);
       g.addEdges(3,0);
       
       System.out.println(g);
   } 
}
