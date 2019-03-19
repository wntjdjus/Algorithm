import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw7280 {	// sw7280 Å»Ãâ
	/*
	 * ½ºÄ±S7 ¾Ç´çV2 Å»ÃâE3
	 * ±æA0 º®W1 ¸øÁö³ª°¨X-1 ºÒF4
	 */
	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			int[][] arr=new int[n][m];
			int min=-1;
			Queue<int[]> q=new LinkedList<>();
			boolean[][][] chkA=new boolean[n][m][k+1];
			boolean[][] chkB=new boolean[n][m];
			int[] start=new int[5];
			for(int i=0;i<n;i++) {
				str=br.readLine().trim();
				for(int j=0;j<m;j++) {
					char c=str.charAt(j);
					if(c=='S') {
						arr[i][j]=7;
						start[0]=i;
						start[1]=j;
						start[2]=7;
						start[3]=k;
						start[4]=0;
					}
					else if(c=='V') {
						arr[i][j]=2;
						int[] temp= {i,j,2,0,0};
						q.add(temp);
						chkB[i][j]=true;
					}
					else if(c=='E') arr[i][j]=3;
					else if(c=='A') arr[i][j]=0;
					else if(c=='W') arr[i][j]=1;
					else if(c=='X') arr[i][j]=-1;
					else if(c=='F') {
						arr[i][j]=4;
						int[] fire= {i,j,4,0,0};
						q.add(fire);
					}
				}
			}
			q.add(start);
			chkA[start[0]][start[1]][k]=true;
			while(!q.isEmpty()) {
				int[] node=q.remove();
				int y=node[0];
				int x=node[1];
				int man=node[2];
				int magic=node[3];
				int time=node[4];
				if(arr[y][x]==3) {
					if(man==2) min=-1;
					else {
						min=time;
					}
					break;
				}
				for(int d=0;d<4;d++) {
					int ty=y+dy[d];
					int tx=x+dx[d];
					if(ty<0||ty>=n||tx<0||tx>=m) continue;
					if(man==7) {
						if(arr[ty][tx]==-1||arr[ty][tx]==4||chkA[ty][tx][magic]) continue;
						if(arr[ty][tx]==1&&magic==0) continue;
						chkA[ty][tx][magic]=true;
						if(arr[ty][tx]==1) {
							int[] next= {ty,tx,7,magic-1,time+1};
							q.add(next);
						}
						else {
							int[] next= {ty,tx,7,k,time+1};
							q.add(next);
						}
//						else {
//							int[] next= {ty,tx,7,magic,time+1};
//							q.add(next);
//						}
					}
					else if(man==2) {
						if(arr[ty][tx]==-1||chkB[ty][tx]) continue;
						chkB[ty][tx]=true;
						int[] next= {ty,tx,7,magic,time+1};
						q.add(next);
					}
					else if(man==4) {
						if(arr[ty][tx]==3||arr[ty][tx]==4||arr[ty][tx]==1||arr[ty][tx]==-1) continue;
						arr[ty][tx]=4;
						int[] next= {ty,tx,4,magic,time+1};
						q.add(next);
					}
				}
			}
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb.toString());
	}
}
