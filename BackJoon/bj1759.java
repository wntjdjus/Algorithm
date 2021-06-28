import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj1759 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		int l=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		boolean[] alpha=new boolean[26];
		boolean[] chk=new boolean[26];
		int[] zm=new int[26];
		str=br.readLine();
		st=new StringTokenizer(str);
		while(st.hasMoreTokens()) {
			char a=st.nextToken().charAt(0);
			alpha[a-'a']=true;
			if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u') zm[a-'a']=1;
		}
		for(int i=0;i<26;i++) {
			if(!alpha[i]) continue;
			int z=0;
			int m=0;
			if(zm[i]==1) m+=1;
			else z+=1;
			char cc=(char)('a'+i);
			go(alpha,chk,zm,i,1,l,""+cc,bw,z,m);
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void go(boolean[] alpha,boolean[] chk,int[] zm,int index,int length,int max,String s,BufferedWriter bw,int z,int m) throws IOException {
		if(length==max) {
//			System.out.println(s+"자"+z+"모"+m);
			if(z>=2&&m>=1) bw.write(s+"\n");
			return;
		}
		for(int i=index+1;i<26;i++) {
			if(!alpha[i]) continue;
			char c=(char)('a'+i);
			if(zm[i]==1) go(alpha,chk,zm,i,length+1,max,s+c,bw,z,m+1);
			else go(alpha,chk,zm,i,length+1,max,s+c,bw,z+1,m);
		}
	}
}
