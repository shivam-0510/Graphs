package Provinces;
import java.util.*;
public class node {
	public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis) {
		vis[node]=1;
		for(Integer i:adj.get(node)) {
			if(vis[i]==0) {
			dfs(i,adj,vis);
			}
		}
	}
	public static int countProvinces(int[][] adj) {
		ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
		int V=adj[0].length;
		for(int i=0;i<V;i++) {
			ans.add(new ArrayList<Integer>());
		}
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(adj[i][j]==1 && i!=j) {
					ans.get(i).add(j);
					ans.get(j).add(i);
				}
			}
		}
		int[] vis=new int[V];
		int count=0;
		for(int i=0;i<V;i++) {
			if(vis[i]==0) {
				count++;
				dfs(i,ans,vis);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adj= {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(countProvinces(adj));
	}

}
