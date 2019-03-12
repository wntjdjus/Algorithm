import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class bj16235 {	// bj 16235 나무재테크
	static int[] dx= {0,1,1,1,0,-1,-1,-1};
	static int[] dy= {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int k=sc.nextInt();
		int[][] nong=new int[n+1][n+1];
		int[][] yang=new int[n+1][n+1];
		PriorityQueue<int[]> q=new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		Queue<int[]> deadTree=new LinkedList<int[]>();
		Queue<int[]> tq=new LinkedList<int[]>();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				yang[i][j]=sc.nextInt();
				nong[i][j]=5;
			}
		}
		for(int i=0;i<m;i++) {
			int namuY=sc.nextInt();
			int namuX=sc.nextInt();
			int namuAge=sc.nextInt();
			int[] node= {namuY,namuX,namuAge};
			q.add(node);
		}
		for(int year=1;year<=k;year++) {
			// 봄
			while(!q.isEmpty()) {
				int[] temp=q.remove();
				int y=temp[0];
				int x=temp[1];
				int age=temp[2];
				if(nong[y][x]<age) {
					deadTree.add(temp);
				}
				else {
					nong[y][x]-=age;
					int[] next= {y,x,age+1};
					tq.add(next);
				}
			}
			//여름
			while(!deadTree.isEmpty()) {
				int[] dead=deadTree.remove();
				int deadY=dead[0];
				int deadX=dead[1];
				int deadAge=dead[2]>>1;
				nong[deadY][deadX]+=deadAge;
			}
			//가을
			while(!tq.isEmpty()) {
				int[] burn=tq.remove();
				int burnY=burn[0];
				int burnX=burn[1];
				int burnAge=burn[2];
				if(burnAge%5==0) {
					for(int d=0;d<8;d++) {
						int ty=burnY+dy[d];
						int tx=burnX+dx[d];
						if(ty<=0||ty>n||tx<=0||tx>n) continue;
						int[] next= {ty,tx,1};
						q.add(next);
					}
				}
				q.add(burn);
			}
			// 겨울
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					nong[i][j]+=yang[i][j];
				}
			}
		}
		int count=0;
		while(!q.isEmpty()) {
			int[] live=q.remove();
			count++;
		}
		System.out.println(count);
	}
}
