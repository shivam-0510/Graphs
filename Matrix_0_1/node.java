package Matrix_0_1;
import java.util.*;
class Pair{
	int first;
	int second;
	int dis;
	Pair(int first,int second,int dis){
		this.first=first;
		this.second=second;
		this.dis=dis;
	}
}
public class node {
	public static int[][] nearest(int[][] matrix){
		int n=matrix.length;
		int m=matrix[0].length;
		int[][] vis=new int[n][m];
		int[][] dis=new int[n][m];
		int[] delRow= {-1,0,+1,0};
		int[] delCol= {0,+1,0,-1};
		Queue<Pair> q=new LinkedList<Pair>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(matrix[i][j]==1) {
					vis[i][j]=1;
					q.add(new Pair(i,j,0));
				}
			}
		}
		while(q.isEmpty()!=true) {
			int r=q.peek().first;
			int c=q.peek().second;
			int d=q.peek().dis;
			q.remove();
			dis[r][c]=d;
			for(int i=0;i<4;i++) {
				int nR=delRow[i]+r;
				int nC=delCol[i]+c;
				if(nR>=0 && nR<n && nC>=0 && nC<m && vis[nR][nC]!=1){
                    vis[nR][nC]=1;
                    q.add(new Pair(nR,nC,d+1));
                }
			}
		}
		return dis;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= {
				{0,0,0},
				{0,1,0},
				{0,0,0}
		};
		System.out.print(nearest(matrix));
	}

}
