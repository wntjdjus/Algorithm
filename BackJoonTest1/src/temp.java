import java.util.Scanner;

public class temp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[][] arr=new int[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		print(arr);
		arr=rotate(arr);
		print(arr);
		arr=rotate(arr);
		print(arr);
	}
	public static void print(int[][] arr) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static int[][] rotate(int[][] arr) {
		int[][] tarr=new int[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				tarr[j][4-i]=arr[i][j];
			}
		}
		return tarr;
	}
}
