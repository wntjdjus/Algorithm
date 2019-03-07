import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj16957 {	//bj16957 체스판 위의 공
	static int[] dx= {-1,0,1,-1,1,-1,0,1};
	static int[] dy= {-1,-1,-1,0,0,1,1,1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int c=sc.nextInt();
		int[][] arr=new int[r][c];
		int[][] ball=new int[r][c];
		int[][] point=new int[r*c][3];
		int index=0;
		Queue<int[]> q=new LinkedList<>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				ball[i][j]=1;
				arr[i][j]=sc.nextInt();
				point[index][0]=i;
				point[index][1]=j;
				point[index][2]=arr[i][j];
				index++;
			}
		}
		Arrays.sort(point, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o2[2]-o1[2];
			}
		});
		for(int i=0;i<r*c;i++) {
			int nextY=point[i][0];
			int nextX=point[i][1];
			int flag=0;
			for(int d=0;d<8;d++) {
				int ty=point[i][0]+dy[d];
				int tx=point[i][1]+dx[d];
				if(ty<0||ty>=r||tx<0||tx>=c) continue;
				if(arr[ty][tx]<arr[nextY][nextX]) {
					nextY=ty;
					nextX=tx;
					flag=1;
				}
			}
			if(flag==0) continue;
			ball[nextY][nextX]+=ball[point[i][0]][point[i][1]];
			ball[point[i][0]][point[i][1]]=0;
		}
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(ball[i][j]+" ");
			}
			System.out.println();
		}
	}
}
