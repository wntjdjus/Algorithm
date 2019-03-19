

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol1239 {	// jungol 1239 비밀편지
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int[] alpha=new int[8];
		alpha[0]=Integer.parseInt("000000",2);
		alpha[1]=Integer.parseInt("001111", 2);
		alpha[2]=Integer.parseInt("010011",2);
		alpha[3]=Integer.parseInt("011100",2);
		alpha[4]=Integer.parseInt("100110",2);
		alpha[5]=Integer.parseInt("101001",2);
		alpha[6]=Integer.parseInt("110101",2);
		alpha[7]=Integer.parseInt("111010",2);
		int ans=Integer.parseInt("111111",2);
		int n=Integer.parseInt(br.readLine());
		String str=br.readLine();
		for(int i=1;i<=n;i++) {
			String sub=str.substring(6*(i-1), 6*(i-1)+6);
			int num=Integer.parseInt(sub,2);
			int chk=check(alpha,num);
			if(chk==-1) {
				System.out.println(i);
				return;
			}
			sb.append((char)('A'+chk));
		}
		System.out.println(sb.toString());
	}
	public static int check(int[] alpha,int num) {
		for(int a=0;a<8;a++) {
			int flag=alpha[a]^num;
			if(flag==0||flag==1||flag==2||flag==4||flag==8||flag==16||flag==32) return a;
		}
		return -1;
	}
}
