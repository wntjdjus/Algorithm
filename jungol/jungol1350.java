import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class jungol1350 {	// 정올1350 최대신장트리
	static class Node implements Comparable<Node>{
		int a;
		int b;
		int c;
		public Node(int a,int b,int c) {
			this.a=a;
			this.b=b;
			this.c=c;
		}
		public int compareTo(Node o) {
			if(this.c>o.c) return -1;
			else if(this.c<o.c) return 1;
			return 0;
		}
	}
	static int[] parent;
	public static int find(int n) {
		if(parent[n]==n) return n;
		return find(parent[n]);
	}
	public static void union(int a,int b) {
		a=find(a);
		b=find(b);
		parent[b]=a;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		parent=new int[n+1];
		for(int i=1;i<=n;i++) parent[i]=i;
		int[][] arr=new int[n+1][n+1];
		boolean[][] chk=new boolean[n+1][n+1];
		for(int i=0;i<m;i++) {
			str=br.readLine().trim();
			st=new StringTokenizer(str);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			arr[a][b]=arr[a][b]>c?arr[a][b]:c;
			arr[b][a]=arr[b][a]>c?arr[b][a]:c;
		}
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i][j]==0||chk[i][j]) continue;
				Node temp=new Node(i,j,arr[i][j]);
				q.offer(temp);
				chk[i][j]=true;
				chk[j][i]=true;
			}
		}
		int sum=0;
		int cnt=0;
		while(!q.isEmpty()) {
			Node node=q.poll();
			int a=node.a;
			int b=node.b;
			int c=node.c;
			if(find(a)==find(b)) continue;
			union(a,b);
			sum+=c;
			cnt++;
			if(cnt==n-1) break;
		}
		System.out.println(sum);
	}
}
