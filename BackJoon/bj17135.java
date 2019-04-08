import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17135 {	// 백준17135 캐슬디펜스
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int[][] arr=new int[n][m];
		int[] Xman=new int[3];
		for(int i=0;i<n;i++) {
			str=br.readLine().trim();
			st=new StringTokenizer(str);
			for(int j=0;j<m;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		int max=go(arr,Xman,n,m,d,-1,0);
		System.out.println(max);
	}
	public static int go(int[][] arr,int[] Xman,int n,int m,int d,int index,int cnt) {
		if(cnt==3) {
			int[][] tarr=new int[n][m];
			clone(arr,tarr,n,m);
			return game(tarr,Xman,n,m,d);
		}
		int max=0;
		for(int i=index+1;i<m;i++) {
			Xman[cnt]=i;
			int temp=go(arr,Xman,n,m,d,i,cnt+1);
			max=max>temp?max:temp;
			Xman[cnt]=0;
		}
		return max;
	}
	public static int game(int[][] arr,int[] Xman,int n,int m,int d) {
		int count=0;
		int[] dy= {0,-1,0};
		int[] dx= {-1,0,1};
		int kill=0;
		Queue<int[]> kq=new LinkedList<>();
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1) {
					kill+=1;
					int[] ktemp= {i,j};
					kq.add(ktemp);
				}
			}
		}
		while(kill>0) {
			int mCnt=0;
			boolean[] mchk=new boolean[3];
			boolean[][][] chk=new boolean[n][m][3];
			Queue<int[]> q=new LinkedList<>();
			Queue<int[]> dq=new LinkedList<>();
			for(int i=0;i<3;i++) {
				int[] xman= {n-1,Xman[i],i,1};
				q.add(xman);
			}
			while(!q.isEmpty()&&mCnt!=3) {
				int[] xm=q.remove();
				int y=xm[0];
				int x=xm[1];
				int man=xm[2];
				int time=xm[3];
				if(mchk[man]) continue;
				if(time>d) continue;
				if(arr[y][x]==1) {
					int[] nextKill= {y,x};
					dq.add(nextKill);
					mchk[man]=true;
					mCnt+=1;
					continue;
				}
				for(int dir=0;dir<3;dir++) {
					int ty=y+dy[dir];
					int tx=x+dx[dir];
					if(time+1>d) continue;
					if(ty<0||ty>=n||tx<0||tx>=m) continue;
					if(chk[ty][tx][man]) continue;
					chk[ty][tx][man]=true;
					int[] next= {ty,tx,man,time+1};
					q.add(next);
				}
			}
			while(!dq.isEmpty()) {
				int[] deleteMan=dq.remove();
				if(arr[deleteMan[0]][deleteMan[1]]==1) {
					arr[deleteMan[0]][deleteMan[1]]=0;
					count+=1;
				}
			}
			Queue<int[]> nkq=new LinkedList<>();
			while(!kq.isEmpty()) {
				int[] kMan=kq.remove();
				if(arr[kMan[0]][kMan[1]]==0) {
					kill-=1;
					continue;
				}
				else if(kMan[0]+1>=n) {
					arr[kMan[0]][kMan[1]]=0;
					kill-=1;
					continue;
				}
				arr[kMan[0]+1][kMan[1]]=1;
				arr[kMan[0]][kMan[1]]=0;
				int[] nkMan= {kMan[0]+1,kMan[1]};
				nkq.add(nkMan);
			}
			while(!nkq.isEmpty()) {
				kq.add(nkq.remove());
			}
		}
		return count;
	}
	public static void clone(int[][] arr,int[][] tarr,int n,int m) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				tarr[i][j]=arr[i][j];
			}
		}
	}
}




















