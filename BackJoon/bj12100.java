import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj12100 {	// 백준12100 2048(easy)
	// 상하좌우
	static int[] dy= {0,0,0,1,-1};
	static int[] dx= {0,1,-1,0,0};
	static int[] dy2= {0,1,-1,0,0};
	static int[] dx2= {0,0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim());
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			for(int j=0;j<n;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		int max=go(arr,n,0);
		System.out.println(max);
	}
	public static int go(int[][] arr,int n,int count) {
		if(count==5) return bigBlock(arr,n);
		int max=bigBlock(arr,n);
		for(int dir=1;dir<=4;dir++) {
			int[][] tarr=new int[n][n];
			clone(arr,tarr,n);
			int[] start= {0,0};
			if(dir%2==0) {
				start[0]=n-1;
				start[1]=n-1;
			}
			for(int d=0;d<n;d++) {
				int y=start[0]+dy[dir]*d;
				int x=start[1]+dx[dir]*d;
				Queue<Integer> q=new LinkedList<>();
				for(int dd=0;dd<n;dd++) {
					int ty=y+dy2[dir]*dd;
					int tx=x+dx2[dir]*dd;
					if(tarr[ty][tx]==0) continue;
					q.add(tarr[ty][tx]);
					tarr[ty][tx]=0;
				}
				int iy=y;
				int ix=x;
				while(!q.isEmpty()) {
					int num=q.remove();
					if(tarr[iy][ix]==0) tarr[iy][ix]=num;
					else if(tarr[iy][ix]==num) {
						tarr[iy][ix]*=2;
						iy+=dy2[dir];
						ix+=dx2[dir];
					}
					else {
						iy+=dy2[dir];
						ix+=dx2[dir];
						tarr[iy][ix]=num;
					}
				}
			}
			int temp=go(tarr,n,count+1);
			max=max>temp?max:temp;
		}
		return max;
	}
	public static void clone(int[][] arr,int[][] tarr,int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				tarr[i][j]=arr[i][j];
			}
		}
	}
	public static int bigBlock(int[][] arr,int n) {
		int big=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				big=big>arr[i][j]?big:arr[i][j];
			}
		}
		return big;
	}
}
