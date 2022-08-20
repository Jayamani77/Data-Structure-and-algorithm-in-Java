
package Graph;
//LinkedList Representation

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph1 {
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;
    
    public Graph1(int nodes){
        this.V=nodes;
        this.E=0;
        this.adj=new LinkedList[nodes];
        for(int v=0;v<V;v++){
            adj[v]=new LinkedList<>();
        }
    }
    public void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(V+" vertices ,"+E+" edges "+"\n");
        for(int v=0;v<V;v++){
            sb.append(v+": ");
            for(int w:adj[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    // breadth first search //uses vertices
     public void bfs(int s){
        boolean[] visited =new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.offer(s);
        
        while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for(int v:adj[u]){
                if(!visited[v]){
                    visited[v]=true;
                    q.offer(v);
                }
            }
        }
    }
    //iterative
    public void dfs(int s){
        boolean[] visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()){
            int u=stack.pop();
            if(!visited[u]){
                visited[u]=true;
                System.out.print(u+" ");
                for(int v:adj[u]){
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
            
        }
    }
    //recursive dfs
    public void Rdfs(){
        boolean[] visited=new boolean[V];
        for(int v=0;v<V;v++){
            if(!visited[v]){//for unconnected vertices
                Rdfs(v,visited);
            }
        }
    }
    public void Rdfs(int v,boolean[] visited){
        visited[v]=true;
        System.out.print(v+" ");
        for(int w:adj[v]){
            if(!visited[w]){
               Rdfs(w,visited);
            }
        }
    }
    //connected components in undirected graph
    int count=0;
    int[] compId;
    public void cdfs(){
        boolean[] visited=new boolean[V];
        compId=new int[V];//to check the connectivity
         count=0;
        for(int v=0;v<V;v++){
            if(!visited[v]){ 
                cdfs(v,visited,compId,count);
                count++;
            }
        }
    }
    public void cdfs(int v,boolean[] visited,int[] compId,int count){
        visited[v]=true;
        System.out.print(v+" ");
        compId[v]=count;
        for(int w:adj[v]){
            if(!visited[w]){
                cdfs(w,visited,compId,count);
            }
        }
    }
    public int getCountcc(){
        return count;
    }
    public boolean isConnected(int x,int y){
        return compId[x]==compId[y];
    }
    public static void main(String[] args){
        Graph1 g=new Graph1(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
 
        System.out.println(g);
        g.cdfs();
        
        System.out.println("\n"+g.getCountcc());
        System.out.println(g.isConnected(4, 1));
    }
}
