import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj11438 {
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
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String str=br.readLine();
		StringTokenizer st;
		int n=Integer.parseInt(str);
		Vector[] v=new Vector[n+1];
		for(int i=1;i<=n;i++) v[i]=new Vector();
		for(int i=0;i<n-1;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			v[a].add(b);
			v[b].add(a);
		}
		
		PriorityQueue<Integer> q=new PriorityQueue<>();
		int s=v[1].size();
		boolean[] chk=new boolean[n+1];
		int[][] parent=new int[n+1][20];
		int[] depth=new int[n+1];
		chk[1]=true;
		for(int i=0;i<s;i++) {
			int tmp=v[1].get(i);
			chk[tmp]=true;
			parent[tmp][0]=1;
			depth[tmp]=1;
			q.add(tmp);
		}
		while(!q.isEmpty()) {
			int node=q.remove();
			int ns=v[node].size();
			for(int i=0;i<ns;i++) {
				int tmp=v[node].get(i);
				if(chk[tmp]) continue;
				chk[tmp]=true;
				depth[tmp]=depth[node]+1;
				parent[tmp][0]=node;
				for(int d=1;d<20;d++) {
					if((1<<(d-1))<depth[tmp]) {
						parent[tmp][d]=parent[parent[tmp][d-1]][d-1];
					}
				}
				q.add(tmp);
			}
		}
		
		int cnt=Integer.parseInt(br.readLine());
		for(int i=0;i<cnt;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int big;
			int small;
			if(depth[a]>depth[b]) {
				big=a;
				small=b;
			} else {
				big=b;
				small=a;
			}
//			System.out.println(big+" "+small);
//			System.out.println(depth[big]+" "+depth[small]);
			if(depth[big]!=depth[small]) {
				int cha=depth[big]-depth[small];
				int tmp=0;
				for(int k=20;k>=0;k--) {
					if((1<<k)<=cha) {
						tmp=k;
						break;
					}
				}
				for(int k=tmp;k>=0;k--) {
//					System.out.println(k);
					if(depth[big]==depth[small]) break;
					if((depth[big]-(1<<k)) >= depth[small]) {
//						System.out.println(parent[big][k]);
						big=parent[big][k];
					}
				}
			}
//			System.out.println(big+" "+small);
			if(big!=small) {
//				int tmp=0;
//				for(int k=20;k<=0;k++) {
//					if((1<<k)<=depth[big]) {
//						tmp=k;
//						break;
//					}
//				}
				for(int k=20;k>=0;k--) {
					if((depth[big]-(1<<k)) <= 0) continue;
//					System.out.println("!"+k+" "+parent[big][k]+" "+parent[small][k]);
					if(parent[big][k]!=parent[small][k]) {
						big=parent[big][k];
						small=parent[small][k];
					}
					if(big==small) break;
				}
				if(big!=small) big=parent[big][0];
			}
			bw.write(big+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
