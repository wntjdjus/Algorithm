import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea1949 {	// swea1949 등산로 조성
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++) {
				str=br.readLine().trim();
				st=new StringTokenizer(str);
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int maxLength=0;
			int[][] start=new int[5][3];
			int index=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					maxLength=maxLength>arr[i][j]?maxLength:arr[i][j];
				}
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]==maxLength) {
						start[index][0]=i;
						start[index][1]=j;
						start[index][2]=1;
						index++;
					}
				}
			}
			int max=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					for(int w=0;w<=k;w++) {
						if(arr[i][j]-w<0) continue;
						arr[i][j]-=w;
						int temp=bfs(arr,n,start,index);
						max=max>temp?max:temp;
						arr[i][j]+=w;
					}
				}
			}
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb.toString());
	}
	public static int bfs(int[][] arr,int n,int[][] start,int index) {
		int[] dy= {-1,0,1,0};
		int[] dx= {0,1,0,-1};
		Queue<int[]> q=new LinkedList<int[]>();
		for(int i=0;i<index;i++) q.add(start[i]);
		int max=0;
		while(!q.isEmpty()) {
			int[] node=q.remove();
			int y=node[0];
			int x=node[1];
			int dis=node[2];
			max=max>dis?max:dis;
			for(int d=0;d<4;d++) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty<0||ty>=n||tx<0||tx>=n) continue;
				if(arr[ty][tx]>=arr[y][x]) continue;
				int[] next= {ty,tx,dis+1};
				q.add(next);
			}
		}
		return max;
	}
}
























