import java.util.Scanner;

public class sw3752 {	//sw3752 가능한 시험점수
	static int count;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int t=1;t<=test;t++) {
			count=0;
			int n=sc.nextInt();
			int[] arr=new int[n];
			int max=0;
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextInt();
				max+=arr[i];
			}
			boolean[][] score=new boolean[n][max+1];
			boolean[] s=new boolean[max+1];
			go(arr,score,s,n,-1,0);
			System.out.println("#"+t+" "+(count+1));
		}
	}
	public static void go(int[] arr,boolean[][] score,boolean[] s,int n,int x,int sum) {
		for(int i=x+1;i<n;i++) {
			int temp=sum+arr[i];
			if(score[i][temp]) continue;
			score[i][temp]=true;
			if(!s[temp]) {
//				System.out.println(temp);
				s[temp]=true;
				count++;
			}
			go(arr,score,s,n,i,temp);
		}
	}
}
