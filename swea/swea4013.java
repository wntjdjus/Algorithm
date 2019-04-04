import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석_박주성 {	// swea4013 특이한 자석
	/*
	 * N극0 S극1
	 * 방향 상0,상우1,우2,우하3,하4,하좌5,좌6,좌상7
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int test=Integer.parseInt(br.readLine().trim());
		for(int t=1;t<=test;t++) {
			int k=Integer.parseInt(br.readLine().trim());
			int[][] topni=new int[5][8];
			for(int i=1;i<=4;i++) {
				String str=br.readLine().trim();
				StringTokenizer st=new StringTokenizer(str);
				for(int j=0;j<8;j++) topni[i][j]=Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<k;i++) {
				String str=br.readLine().trim();
				StringTokenizer st=new StringTokenizer(str);
				int num=Integer.parseInt(st.nextToken());
				int dir=Integer.parseInt(st.nextToken());
				Queue<int[]> q=new LinkedList<>();
				int[] me= {num,dir};
				q.add(me);
				int[][] func= {{6,-1},{2,1}};
				for(int w=0;w<2;w++) {
					int index=num;
					int d=dir;
					while((w==0&&index>1)||(w==1&&index<4)) {
						if(topni[index][func[w][0]]==topni[index+func[w][1]][8-func[w][0]]) break;
						d*=(-1);
						int[] temp= {index+func[w][1],d};
						q.add(temp);
						index=index+func[w][1];
					}
				}
				while(!q.isEmpty()) {
					int[] node=q.remove();
					rotate(topni,node[0],node[1]);
				}
			}
			int sum=0;
			for(int i=1;i<=4;i++) sum+=(topni[i][0]*((int)Math.pow(2, i-1))); 
			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.println(sb.toString());
	}
	public static void rotate(int[][] topni,int num,int d) {
		if(d==1) {
			int temp=topni[num][7];
			for(int i=7;i>=1;i--) topni[num][i]=topni[num][i-1];
			topni[num][0]=temp;
		}
		else {
			int temp=topni[num][0];
			for(int i=0;i<7;i++) topni[num][i]=topni[num][i+1];
			topni[num][7]=temp;
		}
	}
}
