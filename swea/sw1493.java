import java.util.Scanner;

public class sw1493 {	//sw1493 수의 새로운 연산
	/*
	 * #(x,y)=a
	 * &a=(x,y)
	 * p*q=#(&(p)+&(q))
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		int n=20001;
		int[] arr=new int[n+1];
		arr[1]=1;
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+(i-1);
		}
		for(int t=1;t<=test;t++) {
			int p=sc.nextInt();
			int q=sc.nextInt();
			int pindex=search(arr,p,n);
			int qindex=search(arr,q,n);
			int x=1+(p-arr[pindex]);
			int y=pindex-(p-arr[pindex]);
			int z=1+(q-arr[qindex]);
			int w=qindex-(q-arr[qindex]);
			int resultX=x+z;
			int resultY=y+w;
			int result=find(arr,resultX,resultY);
			System.out.println("#"+t+" "+result);
		}
	}
	public static int search(int[] arr,int a,int n) {
		int start=1;
		int end=n;
		while(start<=end) {
			int mid=(start+end)>>1;
			if(arr[mid]>a) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		return start-1;
	}
	public static int find(int[] arr,int x,int y) {
		int sum=x+y;
		int start=arr[sum-1];
		int gap=x-1;
		return start+gap;
	}
}
