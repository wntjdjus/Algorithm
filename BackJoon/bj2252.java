import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2252 {
	static class Vector{
		int[] arr;
		int maxSize;
		int idx;
		public Vector() {
			this.maxSize=2;
			arr=new int[this.maxSize];
			idx=0;
		}
		public void add(int a) {
			arr[idx]=a;
			idx+=1;
			if(idx==maxSize) {
				int[] tarr=new int[maxSize*2];
				for(int i=0;i<maxSize;i++) {
					tarr[i]=arr[i];
				}
				arr=tarr;
				maxSize=maxSize*2;
			}
		}
		public int size() {
			return idx;
		}
		public int get(int index) {
			if(index>=idx) return -1;
			return arr[index];
		}
		public boolean isEmpty() {
			if(idx==0) return true;
			else return false;
		}
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[] cnt=new int[n+1];
		Vector[] next=new Vector[n+1];
		for(int i=1;i<=n;i++) next[i]=new Vector();
//		int[] idx=new int[n+1];
		for(int i=0;i<m;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			next[a].add(b);
//			idx[a]+=1;
			cnt[b]+=1;
		}
		PriorityQueue<Integer> q=new PriorityQueue<>();
		for(int i=1;i<=n;i++) {
			if(cnt[i]==0) q.add(i);
		}
		for(int i=0;i<n;i++) {
			if(q.isEmpty()) {
				System.out.println("뭔가이상하다");
				return;
			}
			int a=q.remove();
			bw.append(a+" ");
			int size=next[a].size();
			for(int j=0;j<size;j++) {
				int tmp=next[a].get(j);
				cnt[tmp]-=1;
				if(cnt[tmp]==0) q.add(tmp);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
