import java.util.Scanner;

public class bj14503 {	// bj14503 �κ� û�ұ�
	/*
	 * �� ��
	 * �� �Ʒ�
	 * �� ����
	 * �� ������
	 */
	static int n;
	static int m;
	static int[] dx= {0,1,0,-1};	// �� �� �� ��
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
				arr[i][j]=sc.nextInt();	// ��1 ��ĭ0
			}
		}
		int count=0;
		while(true) {
			if(arr[startY][startX]==0) {	// û�ұ� ��ġ�� �ִ� ���� û���� ���̸�
				arr[startY][startX]=2;		// û��
				count++;					// û�ҵ� ���� ī��Ʈ++
			}
			int flag=0;						// �ֺ��� û�Ұ������� ����
			for(int k=0;k<4;k++) {
				d=(d+3)%4;					// ���ʹ������� ��������
				int ty=startY+dy[d];
				int tx=startX+dx[d];
				if(ty<0||ty>=n||tx<0||tx>=m) continue;
				if(arr[ty][tx]==0) {
					startY=ty;				// �̵�
					startX=tx;				
					flag=1;					// û�Ұ���
					break;
				}
			}
			if(flag==1) continue;
			// û�Ұ� �Ұ����ϸ�
			startY=(startY+dy[(d+2)%4]);	// ����
			startX=(startX+dx[(d+2)%4]);	// ����
			if(startY<0||startY>=n||startX<0||startX>=m) break;	// ������
			if(arr[startY][startX]==1) break;	// ���̸�
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
