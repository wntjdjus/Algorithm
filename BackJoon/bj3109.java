import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B3109_户笼_冠林己 {	// 归霖 3109 户笼
	static int[] dy= {-1,0,1};
	static int[] dx= {1,1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[][] arr=new int[n][m];
		boolean[][] visit=new boolean[n][m];
		boolean[][] chk=new boolean[n][m];
		for(int i=0;i<n;i++) {
			str=br.readLine().trim();
			for(int j=0;j<m;j++) {
				char c=str.charAt(j);
				if(c=='.') arr[i][j]=0;
				else arr[i][j]=1;
			}
		}
		int cnt=0;
		for(int i=0;i<n;i++) if(go(arr,visit,chk,i,0,n,m)) cnt++;
		System.out.println(cnt);
	}
	public static boolean go(int[][] arr,boolean[][] visit,boolean[][] chk,int y,int x,int n,int m) {
		if(x==m-1) return true;
		for(int d=0;d<3;d++) {
			int ty=y+dy[d];
			int tx=x+dx[d];
			if(ty<0||ty>=n||tx<0||tx>=m) continue;
			if(arr[ty][tx]==1||visit[ty][tx]||chk[ty][tx]) continue;
			visit[ty][tx]=true;
			if(go(arr,visit,chk,ty,tx,n,m)) return true;
			visit[ty][tx]=false;
		}
		chk[y][x]=true;
		return false;
	}
}
