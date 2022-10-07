package BFS;
import java.util.*;
public class node {
	public static ArrayList BFS(ArrayList<ArrayList<Integer>> adj,int V) {
		ArrayList<Integer> ans=new ArrayList<Integer>();
		boolean[] vis=new boolean[V];
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(1);
		vis[1]=true;
		while(q.isEmpty()!=true) {
			Integer node=q.poll();
			ans.add(node);
			for(Integer i:adj.get(node)) {
				if(vis[i]==false) {
					vis[i]=true;
					q.add(i);
				}
			}
		}
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
		System.out.println(BFS(adj,n));
	}

}
