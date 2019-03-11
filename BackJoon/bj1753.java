package notSolve;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class bj1753 {
	static class Connect{
		HashMap<Integer,Integer> map;
		public Connect() {
			map=new HashMap<>();
		}
	}
	static class Node{
		int v;
		int dis;
		public Node(int v,int dis) {
			this.v=v;
			this.dis=dis;
		}
	}
	static class Queue{
		static Node[] q;
		int top;
		int rear;
		public Queue(int n) {
			q=new Node[n+1];
			top=1;
			rear=0;
		}
		public void add(Node node) {
			q[++rear]=node;
			int pointer=rear;
			while(pointer>top) {
				if(q[pointer>>1].dis<q[pointer].dis)break;
				Node temp=q[pointer>>1];
				q[pointer>>1]=q[pointer];
				q[pointer]=temp;
				pointer=pointer>>1;
			}
		}
		public Node delete() {
			Node result=q[top];
			q[top]=q[rear--];
			int pointer=top;
			while(pointer*2<=rear) {
				int next=pointer;
				if(pointer*2<=rear&&q[pointer*2].dis<q[pointer].dis) {
					next=pointer*2;
				}
				if(pointer*2+1<=rear&&q[pointer*2+1].dis<q[next].dis) {
					next=pointer*2+1;
				}
				if(next==pointer) break;
				Node temp=q[next];
				q[next]=q[pointer];
				q[pointer]=temp;
				pointer=next;	
			}
			return result;
		}
		public boolean isEmpty() {
			if(rear==0) return true;
			return false;
		}
	}
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] route;
	static Connect[] connect;
	static boolean[] visit;
	static int v;
	static int e;
	static final int max=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		String str=br.readLine();
		st=new StringTokenizer(str);
		v=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		route=new int[v+1];
		connect=new Connect[v+1];
		for(int i=1;i<=v;i++) {
			connect[i]=new Connect();
		}
		visit=new boolean[v+1];
		Queue q=new Queue(v+1);
		int start=Integer.parseInt(br.readLine());
		for(int i=1;i<=v;i++) {
			route[i]=max;
		}
		for(int i=0;i<e;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			int u=Integer.parseInt(st.nextToken());
			int vv=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			if(!connect[u].map.containsKey(vv)) {
				connect[u].map.put(vv, w);
			}
			else {
				int temp=connect[u].map.get(vv);
				if(temp>w) {
					connect[u].map.remove(vv);
					connect[u].map.put(vv, w);
				}
			}
		}
		route[start]=0;
		q.add(new Node(start,0));
		while(!q.isEmpty()) {
//			for(int i=1;i<=v;i++) {
//				System.out.print(route[i]+" ");
//			}
//			System.out.println();
			Node node=q.delete();
			if(visit[node.v]) continue;
			visit[node.v]=true;
			Iterator<Integer> iterator=connect[node.v].map.keySet().iterator();
			while(iterator.hasNext()) {
				Integer key=iterator.next();
				if(visit[key])continue;
				if(node.dis+connect[node.v].map.get(key)<route[key]) {
					route[key]=node.dis+connect[node.v].map.get(key);
					q.add(new Node(key,route[key]));
				}
			}
		}
		for(int i=1;i<=v;i++) {
			if(route[i]==max) bw.write("INF"+"\n");
			else bw.write(""+route[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
