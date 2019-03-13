import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {	// 정올 1053 피보나치
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int n=Integer.parseInt(br.readLine());
			if(n==-1) break;
			long[][] arrA= {{1,0},{0,1}};
			long[][] arrB= {{1,1},{1,0}};
			while(n>0) {
				if(n%2==1) {
					mul(arrA,arrB);
				}
				mul(arrB,arrB);
				n=n>>1;
			}
			System.out.println(arrA[0][1]);
		}
	}
	public static void mul(long[][] A,long[][] B) {
		long a1=(A[0][0]*B[0][0]+A[0][1]*B[1][0])%10000;
		long a2=(A[0][0]*B[0][1]+A[0][1]*B[1][1])%10000;
		long a3=(A[1][0]*B[0][0]+A[1][1]*B[1][0])%10000;
		long a4=(A[1][0]*B[0][1]+A[1][1]*B[1][1])%10000;
		A[0][0]=a1;
		A[0][1]=a2;
		A[1][0]=a3;
		A[1][1]=a4;
	}
}
