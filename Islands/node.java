package Islands;
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
	public static void bfs(int row,int col,int[][] vis,char[][] grid) {
		int n=grid.length;
		int m=grid[0].length;
		vis[row][col]=1;
		Queue<Pair> q=new LinkedList<Pair>();
		q.add(new Pair(row,col));
		while(q.isEmpty()!=true) {
			int r=q.peek().first;
			int c=q.peek().second;
			q.remove();
			for(int delRow=-1;delRow<=1;delRow++) {
				for(int delCol=-1;delCol<=1;delCol++) {
					int nR=delRow+r;
					int nC=delCol+c;
					if(nR>=0 && nR<n && nC>=0 && nC<m && vis[nR][nC]==0 && grid[nR][nC]=='1') {
						vis[nR][nC]=1;
						q.add(new Pair(nR,nC));
					}
				}
			}
		}
	}
	public static int countIslands(char[][]grid) {
		int count=0;
		int n=grid.length;
		int m=grid[0].length;
		int[][] vis=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(vis[i][j]==0 && grid[i][j]=='1') {
					count++;
					bfs(i,j,vis,grid);
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid= {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};
		System.out.println(countIslands(grid));
	}

}
