import java.util.Scanner;

public class bj14503 {	// bj14503 로봇 청소기
	/*
	 * 북 위
	 * 남 아래
	 * 서 왼쪽
	 * 동 오른쪽
	 */
	static int n;
	static int m;
	static int[] dx= {0,1,0,-1};	// 위 오 아 왼
	static int[] dy= {-1,0,1,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int[][] arr=new int[n][m];
		int startY=sc.nextInt();
		int startX=sc.nextInt();
		int d=sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();	// 벽1 빈칸0
			}
		}
		int count=0;
		while(true) {
			if(arr[startY][startX]==0) {	// 청소기 위치가 있는 곳이 청소할 곳이면
				arr[startY][startX]=2;		// 청소
				count++;					// 청소된 공간 카운트++
			}
			int flag=0;						// 주변에 청소가능한지 여부
			for(int k=0;k<4;k++) {
				d=(d+3)%4;					// 왼쪽방향으로 방향조정
				int ty=startY+dy[d];
				int tx=startX+dx[d];
				if(ty<0||ty>=n||tx<0||tx>=m) continue;
				if(arr[ty][tx]==0) {
					startY=ty;				// 이동
					startX=tx;				
					flag=1;					// 청소가능
					break;
				}
			}
			if(flag==1) continue;
			// 청소가 불가능하면
			startY=(startY+dy[(d+2)%4]);	// 후진
			startX=(startX+dx[(d+2)%4]);	// 후진
			if(startY<0||startY>=n||startX<0||startX>=m) break;	// 나가리
			if(arr[startY][startX]==1) break;	// 벽이면
		}
		System.out.println(count);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
	}
}
