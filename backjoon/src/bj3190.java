import java.util.Scanner;

public class bj3190 {	// bj3190 뱀
	static int n;
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int[][] arr=new int[n+1][n+1];
		int k=sc.nextInt();
		for(int i=0;i<k;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			arr[a][b]=7;	// 사과
		}
		int l=sc.nextInt();
		int[] time=new int[l];		// 방향이 바뀌는 시간 저장
		char[] dir=new char[l];		// 바뀌는 방향 저장
		for(int i=0;i<l;i++) {
			time[i]=sc.nextInt();
			dir[i]=sc.next().charAt(0);
		}
		int timeIndex=0;			// time과 dir에 접근하는 인덱스. 쓸 때마다 1씩 증가
		arr[1][1]=1;
		int headY=1;
		int headX=1;
		int[][] tail=new int[n*n][2];	// 꼬리정보 저장. 나중에 꼬리 0으로 만들어주기 위해.
		tail[0][0]=1;
		tail[0][1]=1;
		int tailIndex=0;			// 꼬리 인덱스. 꼬리를 0으로 만들 때 마다 인덱스 증가
		int length=1;				// 꼬리 추가하기 위한 마지막 인덱스 저장
		int d=1;					// 방향
		int t=0;					// 시간측정
		
		while(true) {
			t++;
			headY+=dy[d];
			headX+=dx[d];
			if(headY<=0||headY>n||headX<=0||headX>n) break;
			if(arr[headY][headX]==1) break;
			if(arr[headY][headX]!=7) {	// 사과 못 먹으면
				arr[tail[tailIndex][0]][tail[tailIndex][1]]=0;	// 꼬리 자르기
				tailIndex++;
			}
			arr[headY][headX]=1;
			tail[length][0]=headY;	// 머리 위치를 나중을 위해 꼬리배열에 저장
			tail[length][1]=headX;
			length++;
			if(timeIndex!=l&&t==time[timeIndex]) {	// 입력해놓은 정해진 시간이 되면
				if(dir[timeIndex]=='D') d=(d+1)%4;	// 방향 결정
				else d=(d+3)%4;
				timeIndex++;
			}
		}
		System.out.println(t);
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		} 
	}
}
