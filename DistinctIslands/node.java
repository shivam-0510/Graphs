package DistinctIslands;
import java.util.*;
public class node {
	public static void dfs(int row,int col,int[][] vis,int[][] grid,ArrayList<String> al,int row0,int col0) {
		vis[row][col]=1;
		int n=grid.length;
		int m=grid[0].length;
		al.add(toString(row0-row,col0-col));
		int[] delRow= {-1,0,+1,0};
		int[] delCol= {0,+1,0,-1};
		for(int i=0;i<4;i++) {
			int nR=delRow[i]+row;
			int nC=delCol[i]+col;
			if(nR>=0 && nR<n && nC>=0 && nC<m && vis[nR][nC]==0 && grid[nR][nC]==1) {
				dfs(nR,nC,vis,grid,al,row0,col0);
			}
		}
	}
	public static String toString(int a,int b) {
		return Integer.toString(a)+" "+Integer.toString(b);
	}
	public static int islands(int[][] grid) {
		int n=grid.length;
		int m=grid[0].length;
		int[][] vis=new int[n][m];
		HashSet<ArrayList<String>> ans=new HashSet<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(vis[i][j]==0 && grid[i][j]==1) {
					ArrayList<String> al=new ArrayList<>();
					dfs(i,j,vis,grid,al,i,j);
					ans.add(al);
				}
			}
		}
		return ans.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
