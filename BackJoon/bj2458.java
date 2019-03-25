import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2458 {	// bj2458 Å° ¼ø¼­
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int[][] arr=new int[n+1][n+1];
		int[][] student=new int[n+1][2];
		for(int i=0;i<m;i++) {
			str=br.readLine();
			st=new StringTokenizer(str);
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[a][b]=1;
		}
		for(int i=1;i<=n;i++) {
			boolean[] chk=new boolean[n+1];
			go(arr,i,student,n,chk);
			int c=0;
			for(int j=1;j<=n;j++) {
				if(chk[j]) c++; 
			}
			student[i][0]=c-1;
		}
		for(int i=1;i<=n;i++) {
			boolean[] chk=new boolean[n+1];
			go2(arr,i,student,n,chk);
			int c=0;
			for(int j=1;j<=n;j++) {
				if(chk[j]) c++; 
			}
			student[i][1]=c-1;
		}
		int count=0;
		for(int i=1;i<=n;i++) {
			if(student[i][0]+student[i][1]==n-1) count++;
		}
//		for(int i=1;i<=n;i++) {
//			System.out.println(student[i][0]+" "+student[i][1]);
//		}
		System.out.println(count);
	}
	public static void go(int[][] arr,int i,int[][] student,int n,boolean[] chk) {
		chk[i]=true;
		for(int j=1;j<=n;j++) {
			if(arr[j][i]==1) {
				if(!chk[j]) {
					go(arr,j,student,n,chk);
				}
			}
		}
	}
	public static void go2(int[][] arr,int i,int[][] student,int n,boolean[] chk) {
		chk[i]=true;
		for(int j=1;j<=n;j++) {
			if(arr[i][j]==1) {
				if(!chk[j]) {
					go2(arr,j,student,n,chk);
				}
			}
		}
	}
}
