import java.util.Scanner;

public class bj3190 {	// bj3190 ��
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
			arr[a][b]=7;	// ���
		}
		int l=sc.nextInt();
		int[] time=new int[l];		// ������ �ٲ�� �ð� ����
		char[] dir=new char[l];		// �ٲ�� ���� ����
		for(int i=0;i<l;i++) {
			time[i]=sc.nextInt();
			dir[i]=sc.next().charAt(0);
		}
		int timeIndex=0;			// time�� dir�� �����ϴ� �ε���. �� ������ 1�� ����
		arr[1][1]=1;
		int headY=1;
		int headX=1;
		int[][] tail=new int[n*n][2];	// �������� ����. ���߿� ���� 0���� ������ֱ� ����.
		tail[0][0]=1;
		tail[0][1]=1;
		int tailIndex=0;			// ���� �ε���. ������ 0���� ���� �� ���� �ε��� ����
		int length=1;				// ���� �߰��ϱ� ���� ������ �ε��� ����
		int d=1;					// ����
		int t=0;					// �ð�����
		
		while(true) {
			t++;
			headY+=dy[d];
			headX+=dx[d];
			if(headY<=0||headY>n||headX<=0||headX>n) break;
			if(arr[headY][headX]==1) break;
			if(arr[headY][headX]!=7) {	// ��� �� ������
				arr[tail[tailIndex][0]][tail[tailIndex][1]]=0;	// ���� �ڸ���
				tailIndex++;
			}
			arr[headY][headX]=1;
			tail[length][0]=headY;	// �Ӹ� ��ġ�� ������ ���� �����迭�� ����
			tail[length][1]=headX;
			length++;
			if(timeIndex!=l&&t==time[timeIndex]) {	// �Է��س��� ������ �ð��� �Ǹ�
				if(dir[timeIndex]=='D') d=(d+1)%4;	// ���� ����
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
