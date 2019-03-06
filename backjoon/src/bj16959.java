import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj16959 {	// bj16959 Ã¼½ºÆÇ ¿©Çà1
	/*
	 * 0³ªÀÌÆ® 1ºñ¼ó 2·è
	 */
	static int n;
	static int[][] arr;
	static int[] nightX= {1,2,2,1,-1,-2,-2,-1};
	static int[] nightY= {-2,-1,1,2,2,1,-1,-2};
	static int[] bishopX= {1,1,-1,-1};
	static int[] bishopY= {-1,1,1,-1};
	static int[] rookX= {0,1,0,-1};
	static int[] rookY= {-1,0,1,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		arr=new int[n][n];
		int sy=0;
		int sx=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==1) {
					sy=i;
					sx=j;
				}
			}
		}
		int snum=1;
		int min=go(sy,sx,snum);
		System.out.println(min);
	}
	public static int go(int sy,int sx,int snum) {
		int min=9999;
		boolean[][][][] chk=new boolean[n][n][n*n+1][3];
		Queue<int[]> q=new LinkedList<>();
		int[] start= {sy,sx,snum,0,0};
		q.add(start);
		chk[sy][sx][snum][0]=true;
		int[] start2= {sy,sx,snum,1,0};
		q.add(start2);
		chk[sy][sx][snum][1]=true;
		int[] start3= {sy,sx,snum,2,0};
		chk[sy][sx][snum][2]=true;
		q.add(start3);
		while(!q.isEmpty()) {
			int[] temp=q.remove();
			int y=temp[0];
			int x=temp[1];
			int num=temp[2];
			int mal=temp[3];
			int time=temp[4];
			if(arr[y][x]==num+1) num++;
			if(num==n*n) {
//				System.out.println(num);
				return time;
			}
			for(int k=1;k<=2;k++) {
				if(!chk[y][x][num][(mal+k)%3]) {
					chk[y][x][num][(mal+k)%3]=true;
					int[] nnext= {y,x,num,(mal+k)%3,time+1};
					q.add(nnext);
				}
			}
			if(mal==0) {	// ³ªÀÌÆ®
				for(int d=0;d<8;d++) {
					int ty=y+nightY[d];
					int tx=x+nightX[d];
					if(ty<0||ty>=n||tx<0||tx>=n) continue;
					if(chk[ty][tx][num][mal]) continue;
					chk[ty][tx][num][mal]=true;
					int[] next= {ty,tx,num,mal,time+1};
					q.add(next);
				}
			}
			else if(mal==1) {	// ºñ¼ó
				for(int d=0;d<4;d++) {
					int dis=1;
					while(true) {
						int ty=y+bishopY[d]*dis;
						int tx=x+bishopX[d]*dis;
						if(ty<0||ty>=n||tx<0||tx>=n) break;
						if(chk[ty][tx][num][mal]) {
							dis++;
							continue;
						}
						chk[ty][tx][num][mal]=true;
						int[] next= {ty,tx,num,mal,time+1};
						q.add(next);
						dis++;
					}
				}
			}
			else if(mal==2) {	// ·è
				for(int d=0;d<4;d++) {
					int dis=1;
					while(true) {
						int ty=y+rookY[d]*dis;
						int tx=x+rookX[d]*dis;
						if(ty<0||ty>=n||tx<0||tx>=n) break;
						if(chk[ty][tx][num][mal]) {
							dis++;
							continue;
						}
						chk[ty][tx][num][mal]=true;
						int[] next= {ty,tx,num,mal,time+1};
						q.add(next);
						dis++;
					}
				}
			}
		}
		return min;
	}
}
