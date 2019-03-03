import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int[][] arr=new int[n][m];
		boolean[][][][] visit=new boolean[20][20][20][20];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int max=go(arr,0);
		System.out.println(max);
	}
	public static int go(int[][] arr,int count) {
		if(count==2) {
			int num=search(arr);
			return num;
		}
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]!=0) continue;
				arr[i][j]=1;
				int temp=go(arr,count+1);
				max=max>temp?max:temp;
				arr[i][j]=0;
			}
		}
		return max;
	}
	public static int search(int[][] arr) {
		boolean[][] visit=new boolean[n][m];
		int sum=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]!=2||visit[i][j]) continue;
				visit[i][j]=true;
				sum+=dfs(i,j,arr,visit,1);
			}
		}
		return sum;
	}
	public static int dfs(int i, int j,int[][] arr,boolean[][] visit,int count) {
		boolean flag=true;
		int t=count;
		for(int d=0;d<4;d++) {
			int x=j+dx[d];
			int y=i+dy[d];
			if(x<0||x>=m||y<0||y>=n) continue;
			if(arr[y][x]==0) flag=false;
			if(arr[y][x]==2&&!visit[y][x]) {
				visit[y][x]=true;
				t=dfs(y,x,arr,visit,t+1);
			}
		}
		if(!flag) return 0;
		return t;
	}
}
