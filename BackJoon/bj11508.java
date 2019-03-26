import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class bj11508 {	// 백준 11508 2+1 세일
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim());
		Integer[] arr=new Integer[n];
		int sum=0;
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
		}
		Arrays.sort(arr,Collections.reverseOrder());
		for(int i=0;i<n;i++) {
			if((i+1)%3==0) {
				sum-=arr[i];
			}
		}
		System.out.println(sum);
	}
}
