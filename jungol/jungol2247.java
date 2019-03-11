import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {	// 정올 2247 도서관
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long[][] arr=new long[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0]=sc.nextLong();
			arr[i][1]=sc.nextLong();
		}
		Arrays.sort(arr, new Comparator<long[]>() {
			public int compare(long[] o1, long[] o2) {
				if(o1[0]<o2[0])	return -1;
				else if(o1[0]==o2[0]) {
					if(o1[1]<o2[1]) return -1;
					else if(o1[1]==o2[1]) return 0;
					else return 1;
				}
				else return 1;
			}
		});
		long[] answer1=new long[2];
		long[] answer2=new long[2];
		answer1[0]=arr[0][0];
		answer1[1]=arr[0][1];
		long max1=answer1[1]-answer1[0];
		long max2=0;
		for(int i=1;i<n;i++) {
			if(arr[i][0]<=answer1[1]) {
				if(arr[i][1]>answer1[1]) answer1[1]=arr[i][1];
			}
			else {
				answer2[0]=answer1[1];
				answer2[1]=arr[i][0];
				answer1[0]=arr[i][0];
				answer1[1]=arr[i][1];
			}
			max1=max1>answer1[1]-answer1[0]?max1:answer1[1]-answer1[0];
			max2=max2>answer2[1]-answer2[0]?max2:answer2[1]-answer2[0];
		}
		System.out.println(max1+" "+max2);
//		for(int i=0;i<n;i++) {
//			System.out.println(arr[i][0]+" "+arr[i][1]);
//		}
	}
}
