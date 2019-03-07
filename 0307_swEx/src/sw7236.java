import java.util.Scanner;

public class sw7236 {	//sw7236 저수지의 물의 총 깊이 구하기
	static int[] dx= {-1,0,1,-1,1,-1,0,1};
	static int[] dy= {-1,-1,-1,0,0,1,1,1};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++) {
			int max=0;
			int n=sc.nextInt();
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					String str=sc.next();
					if(str.charAt(0)=='G') arr[i][j]=0;
					else arr[i][j]=1;
//					arr[i][j]=sc.nextInt();
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int count=0;
					for(int d=0;d<8;d++) {
						int ty=i+dy[d];
						int tx=j+dx[d];
						if(ty<0||ty>=n||tx<0||tx>=n) continue;
						if(arr[ty][tx]==1) count++;
					}
					if(count==0) count++;
					max=max>count?max:count;
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
