import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {	//bj16956 ´Á´ë¿Í ¾ç
	/*
	 * . ºóÄ­ 0
	 * s ¾ç 1
	 * w ´Á´ë 2
	 * d ¿ïÅ¸¸® 3
	 */
	static int r;
	static int c;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		char[][] arr=new char[r][c];
		for(int i=0;i<r;i++) {
			String str=sc.next();
			for(int j=0;j<c;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		if(bfs(arr)) {
			System.out.println(1);
			for(int i=0;i<r;i++) {
				for(int j=0;j<c;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
		else System.out.println(0);
	}
	public static boolean bfs(char[][] arr) {
		Queue<int[]> q=new LinkedList<>();
		boolean[][] chk=new boolean[r][c];
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(arr[i][j]=='W') {
					int[] temp= {i,j};
					chk[i][j]=true;
					q.add(temp);
				}
			}
		}
		while(!q.isEmpty()) {
			int[] t=q.remove();
			int y=t[0];
			int x=t[1];
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty<0||ty>=r||tx<0||tx>=c) continue;
				if(arr[ty][tx]=='S'&&arr[y][x]=='W') return false;
				if(arr[ty][tx]=='S'&&arr[y][x]=='.') {
					arr[y][x]='D';
					continue;
				}
				if(chk[ty][tx]) continue;
				chk[ty][tx]=true;
				int[] next= {ty,tx};
				q.add(next);
			}
		}
		return true;
	}
}
