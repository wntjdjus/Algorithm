import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697 {
	// 백준 1697 : 숨바꼭질
	public static class Node{
		int x;
		int t;
		public Node(int x, int t) {
			super();
			this.x = x;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int[] arr=new int[100001];
		Queue<Node> q=new LinkedList<>();
		for(int i=0;i<100001;i++) {
			arr[i]=-1;
		}
		arr[n]=0;
		q.add(new Node(n, 0));
		while(!q.isEmpty()) {
			Node node=q.remove();
			int x=node.x;
			int t=node.t;
			if(x>0&&arr[x-1]==-1) {
				arr[x-1]=t+1;
				q.add(new Node(x-1,t+1));
			}
			if(x<100000&&arr[x+1]==-1) {
				arr[x+1]=t+1;
				q.add(new Node(x+1,t+1));
			}
			if(x<=50000&&arr[x*2]==-1) {
				arr[x*2]=t+1;
				q.add(new Node(x*2,t+1));
			}
		}
		bw.append(""+arr[k]);
		bw.flush();
		bw.close();
		br.close();
	}
}
