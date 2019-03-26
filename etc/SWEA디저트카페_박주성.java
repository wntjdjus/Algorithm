import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA디저트카페_박주성 {	// sw2105 디저트 카페
	
	static int[] dy= {1,1,-1,-1};
	static int[] dx= {-1,1,1,-1};
	
	static class Node{
		int[] desert;
		int[] start;
		int y;
		int x;
		int length1;
		int length2;
		int dir;
		int count;
		public Node(int y,int x,int length1,int length2,int dir,int count) {
			this.y=y;
			this.x=x;
			this.length1=length1;
			this.length2=length2;
			this.dir=dir;
			this.count=count;
			desert=new int[101];
			start=new int[2];
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			int n=Integer.parseInt(br.readLine().trim());
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++) {
				String str=br.readLine().trim();
				StringTokenizer st=new StringTokenizer(str);
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int result=-1;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
//					System.out.println("BFS시작: "+i+" "+j);
					int temp=bfs(i,j,arr,n);
					result=result>temp?result:temp;
				}
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int bfs(int i, int j, int[][] arr,int n) {
		int max=-1;
		Queue<Node> q=new LinkedList<>();
		Node start=new Node(i,j,0,0,0,0);
		start.start[0]=i;
		start.start[1]=j;
		q.add(start);
		while(!q.isEmpty()) {
			Node node=q.remove();
			int y=node.y;
			int x=node.x;
			int length1=node.length1;
			int length2=node.length2;
			int d=node.dir;
			int count=node.count;
//			System.out.println(y+" "+x+" "+d);
			if(d==0) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty>=0&&ty<n&&tx>=0&&tx<n) {
					if(node.desert[arr[ty][tx]]==0) {
						Node next=new Node(ty,tx,length1+1,length2,d,count+1);
						clone(node.desert,next.desert,101);
						clone(node.start,next.start,2);
						next.desert[arr[ty][tx]]=1;
						q.add(next);
					}
				}
				ty=y+dy[d+1];
				tx=x+dx[d+1];
				if(ty>=0&&ty<n&&tx>=0&&tx<n) {
					if(node.desert[arr[ty][tx]]==0) {
						Node next=new Node(ty,tx,length1,length2+1,d+1,count+1);
						clone(node.desert,next.desert,101);
						clone(node.start,next.start,2);
						next.desert[arr[ty][tx]]=1;
						q.add(next);
					}
				}
			}
			else if(d==1) {
				int ty=y+dy[d];
				int tx=x+dx[d];
				if(ty>=0&&ty<n&&tx>=0&&tx<n) {
					if(node.desert[arr[ty][tx]]==0) {
						Node next=new Node(ty,tx,length1,length2+1,d,count+1);
						clone(node.desert,next.desert,101);
						clone(node.start,next.start,2);
						next.desert[arr[ty][tx]]=1;
						q.add(next);
					}
				}
				ty=y+dy[d+1];
				tx=x+dx[d+1];
				if(ty>=0&&ty<n&&tx>=0&&tx<n) {
					if(node.desert[arr[ty][tx]]==0) {
						Node next=new Node(ty,tx,length1-1,length2,d+1,count+1);
						clone(node.desert,next.desert,101);
						clone(node.start,next.start,2);
						next.desert[arr[ty][tx]]=1;
						q.add(next);
					}
				}
			}
			else if(d==2) {
				if(length1<0) continue;
				if(length1==0) {
					int ty=y+dy[d+1];
					int tx=x+dx[d+1];
					if(ty>=0&&ty<n&&tx>=0&&tx<n) {
						if(node.desert[arr[ty][tx]]==0) {
							Node next=new Node(ty,tx,length1,length2-1,d+1,count+1);
							clone(node.desert,next.desert,101);
							clone(node.start,next.start,2);
							next.desert[arr[ty][tx]]=1;
							q.add(next);
						}
					}
				}
				else {
					int ty=y+dy[d];
					int tx=x+dx[d];
					if(ty>=0&&ty<n&&tx>=0&&tx<n) {
						if(node.desert[arr[ty][tx]]==0) {
							Node next=new Node(ty,tx,length1-1,length2,d,count+1);
							clone(node.desert,next.desert,101);
							clone(node.start,next.start,2);
							next.desert[arr[ty][tx]]=1;
							q.add(next);
						}
					}
				}
			}
			else if(d==3) {
				if(length2<0) continue;
				if(length2==0) {
//					System.out.println(node.start[0]+" "+node.start[1]);
					if(y==node.start[0]&&x==node.start[1]) {
						max=max>count?max:count;
					}
				}
				else {
					int ty=y+dy[d];
					int tx=x+dx[d];
					if(ty>=0&&ty<n&&tx>=0&&tx<n) {
						if(node.desert[arr[ty][tx]]==0) {
							Node next=new Node(ty,tx,length1,length2-1,d,count+1);
							clone(node.desert,next.desert,101);
							clone(node.start,next.start,2);
							next.desert[arr[ty][tx]]=1;
							q.add(next);
						}
					}
				}
			}
		}
		return max;
	}
	public static void clone(int[] arr,int[] arr2,int n) {
		for(int i=0;i<n;i++) {
			arr2[i]=arr[i];
		}
	}
}
























