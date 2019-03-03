import java.util.Scanner;

public class bj16986 {	// 16986번 인싸들의 가위바위보
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
		int[] index=new int[3];
		int[] win=new int[3];
		for(int i=1;i<3;i++) {
			for(int j=0;j<20;j++) {
				player[i][j]=sc.nextInt();
			}
		}
		boolean[] selected=new boolean[n+1];
		if(go(0,1,index,win,selected,0)) System.out.println(1);
		else System.out.println(0);
	}
	public static boolean go(int winner,int mid, int[] index, int[] win, boolean[] selected, int count) {
		System.out.println("GO!");
		int[] tindex=index.clone();
		int[] twin=win.clone();
		int loser=3-(winner+mid);
		int nWinner=0, nLoser=0;
		if(loser==0) {
			switch(match[player[winner][tindex[winner]++]][player[mid][tindex[mid]++]]) {
			case 0:
				nWinner=mid;
				nLoser=winner;
				break;
			case 1:
				nWinner=winner>mid?winner:mid;
				nLoser=winner<mid?winner:mid;
				break;
			case 2:
				nWinner=winner;
				nLoser=mid;
				break;
				default:
					break;
			}
			twin[nWinner]++;
			if(twin[nWinner]==k) {
				System.out.println("false1");
				return false;
			}
			if(go(nWinner,loser,tindex,twin,selected,count)) return true;
		}
		else {
			for(int i=1;i<=n;i++) {
				if(selected[i]) continue;
				selected[i]=true;
				if(winner==0) {
					switch(match[i][player[mid][tindex[mid]++]]) {
					case 0:
						nWinner=mid;
						nLoser=0;
						break;
					case 1:
						nWinner=mid;
						nLoser=0;
						break;
					case 2:
						nWinner=0;
						nLoser=mid;
						break;
						default:
							break;
					}
				}
				else {
					switch(match[player[mid][tindex[mid]++]][i]) {
					case 0:
						nWinner=0;
						nLoser=mid;
						break;
					case 1:
						nWinner=mid;
						nLoser=0;
						break;
					case 2:
						nWinner=mid;
						nLoser=0;
						break;
					default:
						break;
					}
				}
				twin[nWinner]++;
				if(twin[nWinner]==k) {
					if(nWinner==0) {
						return true;
					}
					System.out.println("false2");
					continue;
				}
				if(go(nWinner,loser,tindex,twin,selected,count)) return true;
				selected[i]=false;
			}
		}
		System.out.println("false3");
		return false;
	}
}
