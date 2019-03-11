import java.util.Scanner;

public class testAD2 {	// AD2��
	/*
	 * A B ������� 1 , 2 ...
	 */
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++) {
			int maxIndex=0;
			n=sc.nextInt();
			int[][] arr=new int[100][6];
			int[] score=new int[3];	//  1:A 2:B
			for(int i=1;i<=n;i++) {
				int block=sc.nextInt();
				int player=0;
				if(i%2==0) player=2;	// player 구분
				else player=1;
//				arr[index[block]][block]=player;
				int tempIndex=insert(arr,block,player);		// insert 된 부분의 높이 인덱스 추출
				maxIndex=maxIndex>tempIndex?maxIndex:tempIndex;		// 가장 높은 높이의 인덱스 구하기
				while(true) {
					int flag=0;		// 부술 블럭이 있는지 여부
					for(int ii=maxIndex;ii>=0;ii--) {
						for(int j=0;j<=2;j++) {
							int num=dfs(arr,ii,j,1);	// 묶여있는 블럭의 개수 구하기
							if(num>=4) {		// 블럭 개수가 4개 이상이면 (블럭 부시기)
								flag=1;			// 블럭 부술수 있다
								for(int k=j;k<j+num;k++) {
									if(arr[ii][k]==player) score[player]++;	// 현재 player의 블럭이면 점수 획득
									arr[ii][k]=0;		// 블럭 부수기
								}
								break;
							}
						}
					}
					if(flag==0) break;		// 부순 블럭이 없으면 반복종료
					for(int j=0;j<maxIndex;j++) {
						for(int k=0;k<6;k++) {
							if(arr[j][k]==0&&arr[j+1][k]!=0) {	// 블럭 내리기
								arr[j][k]=arr[j+1][k];
								arr[j+1][k]=0;
							}
						}
					}
				}
			}
			//print(arr);	//블럭 배열보기 테스트
			int big=score[1]>score[2]?score[1]:score[2];
			int small=score[1]>score[2]?score[2]:score[1];
			System.out.println("#"+t+" "+(big-small));
		}
	}
	public static int insert(int[][] arr,int block,int player) {	// 블록 넣기
		int index=0;
		for(int i=0;i<100;i++) {
			if(arr[i][block]!=0) continue;
			arr[i][block]=player;
			index=i;
			break;
		}
		return index;		// 넣어진 인덱스 리턴
	}
	public static int dfs(int[][] arr,int ii,int j,int count) {		// 부술 수 있는 블럭 여부 체크
		if(j==5) return count;
		int sum=1;
		if(arr[ii][j]!=0&&arr[ii][j+1]==arr[ii][j]) sum = dfs(arr,ii,j+1,count+1);
		else return count;
		return sum;
	}
	public static void print(int[][] arr) {		// 테스트용
		for(int i=0;i<100;i++) {
			for(int j=0;j<6;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
