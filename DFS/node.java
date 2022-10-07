package DFS;
import java.util.*;
public class node {
	public static void DFS(int node,boolean[] vis,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> adj) {
		vis[node]=true;
		ans.add(node);
		
		for(Integer it:adj.get(node)) {
			if(vis[it]==false) {
				DFS(it,vis,ans,adj);
			}
		}
	}
	public static ArrayList<Integer> dfs(int v,ArrayList<ArrayList<Integer>> adj){
		ArrayList<Integer> ans=new ArrayList<Integer>();
		boolean[] vis=new boolean[v];
		vis[1]=true;
		DFS(1,vis,ans,adj);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
		int n=3,m=3;
		for(int i=0;i<=n;i++) {
			adj.add(new ArrayList<Integer>());
		}
		//edge 1---2
		adj.get(1).add(2);
		adj.get(2).add(1);
		//edge 2---3
		adj.get(2).add(3);
		adj.get(3).add(2);
		//edge 1---3
		adj.get(1).add(3);
		adj.get(3).add(1);
		for(int i=1;i<=n;i++) {
			for(int j=0;j<adj.get(i).size();j++) {
				System.out.print(adj.get(i).get(j)+" ");
			}
			System.out.println();
		}
		System.out.println(dfs(n,adj));
	}

}
