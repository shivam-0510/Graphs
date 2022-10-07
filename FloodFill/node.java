package FloodFill;
public class node {
	public static void dfs(int[][] image,int row,int col,int[][] ans,int delRow[],int delCol[],int color,int iniColor) {
		ans[row][col]=color;
		int n=image.length;
		int m=image[0].length;
		for(int i=0;i<4;i++) {
			int nR=row+delRow[i];
			int nC=col+delCol[i];
			if(nR>=0 && nR<n && nC>=0 && nC<m && ans[nR][nC]!=color && image[nR][nC]==iniColor) {
				dfs(image,nR,nC,ans,delRow,delCol,color,iniColor);
			}
		}
	}
	public static int[][] floodFill(int[][] image,int sr,int sc,int color) {
		int iniColor=image[sr][sc];
		int[][] ans=image;
		int[] delRow= {-1,0,+1,0};
		int[] delCol= {0,+1,0,-1};
		dfs(image,sr,sc,ans,delRow,delCol,color,iniColor);
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] image= {
				{1,1,1},
				{1,1,0},
				{1,0,1}
		};
		int sr=1,sc=1,color=2;
		System.out.println(floodFill(image,sr,sc,color));
	}

}
