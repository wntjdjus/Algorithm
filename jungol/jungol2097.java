import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class jungol2097 {	//jungol 2097 ¡ˆ«œ√∂
	static class Node implements Comparable<Node>{
		int x;
		int time;
		int[] arr;
		int index;
		public Node() {
			arr=new int[100];
		}
		@Override
		public int compareTo(Node o) {
			if(this.time>o.time) return 1;
			else if(this.time<o.time) return -1;
			return 0;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str=br.readLine().trim();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[][] arr=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			str=br.readLine().trim();
			st=new StringTokenizer(str);
			for(int j=1;j<=n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<Node> q=new PriorityQueue<>();
		Node node=new Node();
		node.x=1;
		node.time=0;
		node.arr[0]=1;
		node.index=1;
		q.add(node);
		while(!q.isEmpty()) {
			Node no=q.poll();
			int metro=no.x;
			int time=no.time;
			int index=no.index;
			if(metro==m) {
				System.out.println(time);
				for(int i=0;i<index;i++) {
					System.out.print(no.arr[i]+" ");
				}
				System.out.println();
				break;
			}
			for(int i=1;i<=n;i++) {
				if(i==metro) continue;
				Node next=new Node();
				clone(no.arr,next.arr,index);
				next.arr[index]=i;
				next.x=i;
				next.time=time+arr[metro][i];
				next.index=index+1;
				q.offer(next);
			}
		}
	}
	public static void clone(int[] arr,int[] tarr,int index) {
		for(int i=0;i<index;i++) {
			tarr[i]=arr[i];
		}
	}
}
