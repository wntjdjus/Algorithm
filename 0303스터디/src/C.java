import java.util.Scanner;

public class C {	// bj14500 테트로미노
	static int n;
	static int m;
	static int[][] basic;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		basic=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				basic[i][j]=sc.nextInt();
			}
		}
		int max=go(basic);
		System.out.println(max);
	}
	public static int go(int[][] arr) {
		int max=0;
		boolean[][] visit=new boolean[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int temp=dfs(arr,i,j,visit,1,arr[i][j]);
				max=max>temp?max:temp;
				temp=fuck(arr,i,j);
				max=max>temp?max:temp;
			}
		}
		return max;
	}
	public static int dfs(int[][] arr,int y,int x,boolean[][] visit,int count,int sum) {
		if(count==4) {
			return sum;
		}
		visit[y][x]=true;
		int max=0;
		for(int d=0;d<4;d++) {
			int ty=y+dy[d];
			int tx=x+dx[d];
			if(tx<0||tx>=m||ty<0||ty>=n) continue;
			if(visit[ty][tx]) continue;
			int temp=dfs(arr,ty,tx,visit,count+1,sum+arr[ty][tx]);
			max=max>temp?max:temp;
		}
		visit[y][x]=false;
		return max;
	}
	public static int fuck(int[][] arr,int y,int x) {
		int max=0;
		int sum=0;
		//ㅗ
		if(y-1>=0&&x+2<m) sum=arr[y][x]+arr[y][x+1]+arr[y][x+2]+arr[y-1][x+1];
		max=max>sum?max:sum;
		//ㅜ
		if(y+1<n&&x+2<m) sum=arr[y][x]+arr[y][x+1]+arr[y][x+2]+arr[y+1][x+1];
		max=max>sum?max:sum;
		//ㅏ
		if(y+2<n&&x+1<m) sum=arr[y][x]+arr[y+1][x]+arr[y+2][x]+arr[y+1][x+1];
		max=max>sum?max:sum;
		//ㅓ
		if(y-1>=0&&y+1<n&&x+1<m) sum=arr[y][x]+arr[y-1][x+1]+arr[y][x+1]+arr[y+1][x+1];
		max=max>sum?max:sum;
		return max;
	}
}
