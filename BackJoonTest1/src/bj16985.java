import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj16985 {	// bj16985 Maaaaaaaaaze
	static int[][][] input;
	static int[] dz= {-1,1,0,0,0,0};
	static int[] dy= {0,0,-1,1,0,0};
	static int[] dx= {0,0,0,0,-1,1};
	static boolean[] useZ;
	static int min=Integer.MAX_VALUE;
	static int c=0;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		input=new int[5][5][5];
		useZ=new boolean[5];
		for(int k=0;k<5;k++) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					input[k][i][j]=sc.nextInt();
				}
			}
		}
		int[][][] cube=new int[5][5][5];
		go(cube,0);
		if(min==Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	public static void go(int[][][] cube,int height) {
		if(height==5) {
			c++;
			bfs(cube,0,0,0);
			bfs(cube,0,0,4);
			bfs(cube,0,4,0);
			bfs(cube,0,4,4);
			return;
		}
		for(int k=0;k<5;k++) {
			if(useZ[k]) continue;
			useZ[k]=true;
			int[][] tarr=new int[5][5];
			clone32(input,tarr,k);
			for(int r=0;r<4;r++) {
				int[][][] tcube=new int[5][5][5];
				clone3(cube,tcube);
 				tarr=rotate(tarr);
				clone2(tarr,tcube,height);
				go(tcube,height+1);
			}
			useZ[k]=false;
		}
	}
	public static void print(int[][][] arr) {
		for(int k=0;k<5;k++) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					System.out.print(arr[k][i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println("=============================");
	}
	public static int[][] rotate(int[][] arr) {
		int[][] tarr=new int[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				tarr[j][4-i]=arr[i][j];
			}
		}
		return tarr;
	}
	public static void bfs(int[][][] cube,int a,int b,int c) {
		if(cube[a][b][c]==0) return;
		boolean[][][] visit=new boolean[5][5][5];
		Queue<int[]> q=new LinkedList<int[]>();
		int[] start= {a,b,c,0};
		visit[a][b][c]=true;
		q.add(start);
		while(!q.isEmpty()) {
			int[] temp=q.remove();
			int z=temp[0];
			int y=temp[1];
			int x=temp[2];
			int length=temp[3];
			if((z==4-a)&&(y==4-b)&&(x==4-c)) {
				min=min<length?min:length;
				return;
			}
			for(int d=0;d<6;d++) {
				int tz=z+dz[d];
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(tz<0||tz>=5||ty<0||ty>=5||tx<0||tx>=5) continue;
				if(cube[tz][ty][tx]==0) continue;
				if(visit[tz][ty][tx]) continue;
				visit[tz][ty][tx]=true;
				int[] next= {tz,ty,tx,length+1};
				q.add(next);
			}
		}
		return;
	}
	public static void clone3(int[][][] arr, int[][][] tarr) {
		for(int k=0;k<5;k++) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					tarr[k][i][j]=arr[k][i][j];
				}
			}
		}
	}
	public static void clone2(int[][] arr, int[][][] tarr, int height) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				tarr[height][i][j]=arr[i][j];
			}
		}
	}
	public static void clone32(int[][][] arr, int[][] tarr, int height) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				tarr[i][j]=arr[height][i][j];
			}
		}
	}
}
