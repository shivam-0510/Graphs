package CycleBFS;
import java.util.*;
class Pair{
	int first;
	int second;
	Pair(int first,int second){
		this.first=first;
		this.second=second;
	}
}
public class node {
	public static boolean checkForCycle(int src,int V, ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        vis[src]=true;
        Queue<Pair>q=new LinkedList<Pair>();
        q.add(new Pair(src,-1));
        while(q.isEmpty()!=true){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(Integer adjList:adj.get(node)){
                if(vis[adjList]==false){
                    vis[adjList]=true;
                    q.add(new Pair(adjList,node));
                }
                else if(parent!=adjList){return true;}
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++)vis[i]=false;
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(checkForCycle(i,V,adj,vis))return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
