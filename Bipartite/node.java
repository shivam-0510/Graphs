package Bipartite;
import java.util.*;
public class node {
	public static boolean checkColor(int start,int v,ArrayList<ArrayList<Integer>> al,int[] color) {
		Queue<Integer> q=new LinkedList<>();
		q.add(start);
		color[start]=0;
		while(!q.isEmpty()) {
			int node=q.peek();
			q.remove();
			for(Integer i:al.get(node)) {
				if(color[i]==-1) {
					color[i]=1-color[node];
					q.add(i);
				}
				else if(color[i]==color[node])return false;
			}
		}
		return true;
	}
	public static boolean isBipartite(int v,ArrayList<ArrayList<Integer>> al) {
		int[] color=new int[v];
		for(int i=0;i<v;i++) {
			color[i]=-1;
		}
		for(int i=0;i<v;i++) {
			if(color[i]==-1) {
				if(checkColor(i,v,al,color)==false)return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
