import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw6109 {	//sw6109 추억의 2048게임
	static int[] dy= {0,-1,0,1};
	static int[] dx= {1,0,-1,0};
	static int[] dy2= {1,0,-1,0};
	static int[] dx2= {0,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			int n=Integer.parseInt(st.nextToken());
			String command=st.nextToken();
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++) {
				str=br.readLine().trim();
				st=new StringTokenizer(str);
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int startY=0;
			int startX=0;
			int dir=0;
			if(command.equals("up")) {
				startY=0;
				startX=0;
				dir=0;
			}
			else if(command.equals("left")) {
				startY=0;
				startX=0;
				dir=3;
			}
			else if(command.equals("right")) {
				startY=n-1;
				startX=n-1;
				dir=1;
			}
			else if(command.equals("down")) {
				startY=n-1;
				startX=n-1;
				dir=2;
			}
			while(true) {
				if(startX<0||startX>=n||startY<0||startY>=n) break;
				int sy=startY;
				int sx=startX;
				int ssy=sy;
				int ssx=sx;
				Queue<Integer> q=new LinkedList<>();
				while(true) {
					if(sx<0||sx>=n||sy<0||sy>=n) break;
					if(arr[sy][sx]!=0) {
						q.add(arr[sy][sx]);
						arr[sy][sx]=0;
					}
					sy+=dy2[dir];
					sx+=dx2[dir];
				}
				while(!q.isEmpty()) {
					arr[ssy][ssx]=q.poll();
					ssy+=dy2[dir];
					ssx+=dx2[dir];
				}
				sy=startY;
				sx=startX;
				ssy=sy;
				ssx=sx;
				while(true) {
					if(sx<0||sx>=n||sy<0||sy>=n) break;
					if(sx+dx2[dir]<0||sx+dx2[dir]>=n||sy+dy2[dir]<0||sy+dy2[dir]>=n) {
						q.add(arr[sy][sx]);
						arr[sy][sx]=0;
						break;
					}
					if(arr[sy][sx]==arr[sy+dy2[dir]][sx+dx2[dir]]) {
						q.add(arr[sy][sx]*2);
						arr[sy][sx]=0;
						arr[sy+dy2[dir]][sx+dx2[dir]]=0;
						sy+=(dy2[dir]*2);
						sx+=(dx2[dir]*2);
					}
					else {
						q.add(arr[sy][sx]);
						arr[sy][sx]=0;
						sy+=(dy2[dir]);
						sx+=(dx2[dir]);
					}
				}
				while(!q.isEmpty()) {
					arr[ssy][ssx]=q.poll();
					ssy+=dy2[dir];
					ssx+=dx2[dir];
				}
				startY+=dy[dir];
				startX+=dx[dir];
			}
			sb.append("#"+t+"\n");
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) sb.append(arr[i][j]+" ");
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
