import java.util.Scanner;

public class bj16953 {	//bj16953 A->B
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long a=sc.nextLong();
		long b=sc.nextLong();
		long min=go(a,b,0);
		if(min==Long.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		
	}
	public static long go(long a,long b,long num) {
		if(num>=10) {
			return Long.MAX_VALUE;
		}
		else if(a>b) {
			return Long.MAX_VALUE;
		}
		else if(a==b) {
			return 1;
		}
		long min=Long.MAX_VALUE;
		long t1=go(a*2,b,num);
		if(t1!=Long.MAX_VALUE) min=min<t1+1?min:t1+1;
		long t2=go(a*10+1,b,num+1);
		if(t2!=Long.MAX_VALUE) min=min<t2+1?min:t2+1;
		return min;
	}
}
