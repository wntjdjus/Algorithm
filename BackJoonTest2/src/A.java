import java.util.Scanner;

public class A {	// A번 계란으로 바위치기
	static int n;
	static int max=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int[][] egg=new int[n][2];
		for(int i=0;i<n;i++) {
			egg[i][0]=sc.nextInt();
			egg[i][1]=sc.nextInt();
		}
		go(0,egg,0);
		System.out.println(max);
	}
	public static void go(int index,int[][] tegg,int count) {
		if(index>n-1) {
			max=max>count?max:count;
			return;
		}
		if(tegg[index][0]<0) {
			go(index+1,tegg,count);
			return;
		}
		for(int i=0;i<n;i++) {
			if(i==index||tegg[i][0]<0) continue;
			int[][] ttegg=new int[n][2];
			clone(tegg,ttegg);
			int tcount=count;
			ttegg[i][0]=ttegg[i][0]-ttegg[index][1];
			ttegg[index][0]=ttegg[index][0]-ttegg[i][1];
			if(ttegg[i][0]<0) tcount++;
			if(ttegg[index][0]<0) tcount++;
			go(index+1,ttegg,tcount);
		}
		go(index+1,tegg,count);
	}
	public static void clone(int[][] arr, int[][] tarr) {
		for(int i=0;i<n;i++) {
			tarr[i][0]=arr[i][0];
			tarr[i][1]=arr[i][1];
		}
	}
}
