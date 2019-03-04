import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class bj15664 {	// bj15664 N°ú M(10)
	static int n;
	static int m;
	static HashMap<String, String> map;
//	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
//		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		n=sc.nextInt();
		m=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		boolean[] check=new boolean[n];
		int[] result=new int[m];
		map=new HashMap<>();
		go(arr,0,check,0,result);
//		bw.flush();
//		bw.close();
	}
	public static void go(int[] arr, int count,boolean[] check, int index,int[] result) throws IOException {
		if(count==m) {
			String str="";
			for(int i=0;i<count;i++) {
				str+=result[i]+" ";
			}
//			bw.write("\n");
			if(map.containsKey(str)) return;
			map.put(str, str);
			System.out.println(str);
			return;
		}
		for(int i=index;i<n;i++) {
			if(check[i]) continue;
			check[i]=true;
//			bw.write(arr[i]+" ");
			result[count]=arr[i];
			go(arr,count+1,check,i,result);
			check[i]=false;
		}
	}
}
