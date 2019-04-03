import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol1733 {	// 정올1733 오목
	static int[] dy= {-1,0,1,1};
	static int[] dx= {1,1,1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][] arr=new int[19][19];
		boolean[][][] chk=new boolean[19][19][4];
		for(int i=0;i<19;i++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			for(int j=0;j<19;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(arr[i][j]==0) continue;
				for(int d=0;d<4;d++) {
					if(d==0) {
						if(i+1>=0&&i+1<19&&j-1>=0&&j-1<19) {
							if(arr[i+1][j-1]==arr[i][j]) continue;
						}
					}
					if(chk[i][j][d]) continue;
					int temp=go(arr,chk,i,j,d,1);
					if(temp==5) {
						System.out.println(arr[i][j]+"\n"+(i+1)+" "+(j+1)+"\n");
						return;
					}
				}
			}
		}
		System.out.println("0\n");
	}
	public static int go(int[][] arr,boolean[][][] chk,int y,int x,int d,int cnt) {
		chk[y][x][d]=true;
		int ty=y+dy[d];
		int tx=x+dx[d];
		if(ty<0||ty>=19||tx<0||tx>=19) return cnt;
		if(chk[ty][tx][d]) return cnt;
		if(arr[ty][tx]!=arr[y][x]) return cnt;
		return go(arr,chk,ty,tx,d,cnt+1);
	}
}
