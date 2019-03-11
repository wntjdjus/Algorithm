import java.util.Scanner;

public class Main {	// 16986번 인싸들의 가위바위보
	static int n;
	static int k;
	static int[][] match;
	static int[][] player;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		match=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				match[i][j]=sc.nextInt();
			}
		}
		player=new int[3][20];
		int[] win=new int[3];
		for(int i=1;i<3;i++) {
			for(int j=0;j<20;j++) {
				player[i][j]=sc.nextInt();
			}
		}
		boolean[] input=new boolean[n+1];
		if(go(win,input,0,0,1,0,0)) System.out.println(1);
		else System.out.println(0);
	}
	public static boolean go(int[] win,boolean[] input, int count, int winner, int no, int index1, int index2) {
		int[] twin;
		if(win[winner]==k) {
			if(winner==0) {
				return true;
			}
			else {
				return false;
			}
		}
		if(count>=n) {
			return false;
		}
		int front=0;
		int rear=0;
		if(winner==0&&no==1 || winner==1&&no==0) {
			for(int i=1;i<=n;i++) {
				if(input[i]) continue;
				input[i]=true;
				front=i;
				rear=player[1][index1];
				if(match[front][rear]==0) {
					twin=new int[3];
					clone(win,twin);
					twin[1]++;
					if(go(twin,input,count+1,1,2,index1+1,index2)) return true;
				}
				else if(match[front][rear]==1) {
					twin=new int[3];
					clone(win,twin);
					twin[1]++;
					if(go(twin,input,count+1,1,2,index1+1,index2)) return true;
				}
				else {
					twin=new int[3];
					clone(win,twin);
					twin[0]++;
					if(go(twin,input,count+1,0,2,index1+1,index2)) return true;
				}
				input[i]=false;
			}
		}
		else if(winner==0&&no==2 || winner==2&&no==0) {
			for(int i=1;i<=n;i++) {
				if(input[i]) continue;
				input[i]=true;
				front=i;
				rear=player[2][index2];
				if(match[front][rear]==0) {
					twin=new int[3];
					clone(win,twin);
					twin[2]++;
					if(go(twin,input,count+1,2,1,index1,index2+1)) return true;
				}
				else if(match[front][rear]==1) {
					int big=winner>no?winner:no;
					twin=new int[3];
					clone(win,twin);
					twin[2]++;
					if(go(twin,input,count+1,2,1,index1,index2+1)) return true;
				}
				else {
					twin=new int[3];
					clone(win,twin);
					twin[0]++;
					if(go(twin,input,count+1,0,1,index1,index2+1)) return true;
				}
				input[i]=false;
			}
		}
		else if(winner==1&&no==2||winner==2&&no==1) {
			front=player[1][index1];
			rear=player[2][index2];
			if(match[front][rear]==0) {
				twin=new int[3];
				clone(win,twin);
				twin[2]++;
				if(go(twin,input,count,2,0,index1+1,index2+1)) return true;
			}
			else if(match[front][rear]==1) {
				twin=new int[3];
				clone(win,twin);
				twin[2]++;
				if(go(twin,input,count,2,0,index1+1,index2+1)) return true;
			}
			else {
				twin=new int[3];
				clone(win,twin);
				twin[1]++;
				if(go(twin,input,count,1,0,index1+1,index2+1)) return true;
			}
		}
		return false;
	}
	public static void clone(int[] arr, int[] tarr) {
		for(int i=0;i<3;i++) {
			tarr[i]=arr[i];
		}
	}
}
