package RottenOranges;
import java.util.*;
class Pair{
	int row;
	int col;
	int time;
	Pair(int row,int col,int time){
		this.row=row;
		this.col=col;
		this.time=time;
	}
}
public class node {
	public static int rottenOranges(int[][] oranges) {
		int n=oranges.length;
		int m=oranges[0].length;
		Queue<Pair> q=new LinkedList<Pair>();
		int[][] vis=new int[n][m];
		int countFresh=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(oranges[i][j]==2) {
					q.add(new Pair(i,j,0));
					vis[i][j]=2;
				}
				else {
					vis[i][j]=0;
				}
				if(oranges[i][j]==1)countFresh++;
			}
		}
		int tm=0;
		int count=0;
		int[] delRow= {-1,0,+1,0};
		int[] delCol= {0,+1,0,-1};
		while(q.isEmpty()!=true) {
			int r=q.peek().row;
			int c=q.peek().col;
			int t=q.peek().time;
			q.remove();
			tm=Math.max(tm, t);
			for(int i=0;i<4;i++) {
				int nR=delRow[i]+r;
				int nC=delCol[i]+c;
				if(nR>=0 && nR<n && nC>=0  && nC<m && vis[nR][nC]==0 && oranges[nR][nC]==1) {
					q.add(new Pair(nR,nC,t+1));
					vis[nR][nC]=2;
					count++;
				}
			}
		}
		if(count!=countFresh)return -1;
		return tm;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
