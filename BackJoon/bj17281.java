import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj17281 {
	/*
	 * 백준 17281번 : 야구
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=null;
		
		int n=Integer.parseInt(br.readLine());
		int[][] arr=new int[n][9];
		
		for(int i=0;i<n;i++) {
			String str=br.readLine();
			st=new StringTokenizer(str);
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[] start= {3,1,2,0,4,5,6,7,8};
		boolean[] chk= {false,false,false,true,false,false,false,false,false};
		int[] tasoon=new int[9];
		
		int max=search(arr,n,start,tasoon,chk,0);
		
		System.out.println(max);
		
		bw.flush();
		bw.close();
		br.close();
	}
	public static int search(int[][] arr, int n, int[] input, int[] players, boolean[] chk, int seq) {
		if(seq==9) {
			int score=game(players,arr,n);
			return score;
		}
		int max=0;
		if(seq==3) {
			int tmp=search(arr,n,input,players,chk,seq+1);
			if(tmp>max) max=tmp;
			return max;
		}
		for(int i=0;i<9;i++) {
			if(chk[i]) continue;
			chk[i]=true;
			players[seq]=input[i];
			int tmp=search(arr,n,input,players,chk,seq+1);
			if(tmp>max) max=tmp;
			chk[i]=false;
		}
		return max;
	}
	public static int game(int[] player, int[][] arr, int n) {
		int[] base=new int[4];
		int ining=1;
		int manS=0;
		int man=player[manS];
		int score=0;
		int out=0;
		
		while(ining<=n) {
			int hit=arr[ining-1][man];
			base[0]=1;
			if(hit==0) {
				out+=1;
				base[0]=0;
			}else {
				for(int i=3;i>=0;i--) {
					if(base[i]==1) {
						base[i]=0;
						int next=i+hit;
						if(next>3) {
							score+=1;
						}else {
							base[next]=1;
						}
					}
				}
			}
			man=player[(manS+=1)%9];
			if(out==3) {
				ining+=1;
				base=new int[4];
				out=0;
			}
		}
		
		return score;
	}
}
