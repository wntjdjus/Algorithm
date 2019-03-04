import java.util.Scanner;

public class Main {	// A번 계란으로 계란치기
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
		boolean[] chk=new boolean[n];
		go(0,egg,0,chk);
		System.out.println(max);
	}
	public static void go(int index,int[][] egg,int count,boolean[] chk) {
		if(index==n-1) {
			
		}
		if(egg[index][0]<0) return;
		chk[index]=true;
		for(int i=0;i<n;i++) {
			if(egg[i][0]<0) continue;
			int[][] tegg=new int[n][2];
			clone(egg,tegg);
			tegg[i][0]-=egg[index][1];
			tegg[index][0]-=egg[i][1];
			go(index+1,tegg,count+1,chk);
		}
	}
	public static void clone(int[][] egg, int[][] tegg) {
		for(int i=0;i<n;i++) {
			tegg[i][0]=egg[i][0];
			tegg[i][1]=egg[i][1];
		}
	}
}
