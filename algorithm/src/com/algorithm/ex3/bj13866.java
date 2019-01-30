package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj13866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s = br.readLine();
		st = new StringTokenizer(s);
		int[] arr=new int[4];
		int answer=0;
		int[] check=new int[4];
		for(int i =0;i<4;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			answer+=arr[i];
		}
		answer=dfs(arr,check,0,answer,0);
		bw.write(""+answer);
		bw.flush();
		bw.close();
		br.close();
	}
	public static int dfs(int[] arr, int[] check, int count,int answer, int sum) {
		if(count==4) {
			sum = Math.abs(sum);
			return sum;
		}
		for(int i=0;i<4;i++) {
			int[] tcheck = new int[4];
			for(int t = 0; t < 4; t++) {
				tcheck[t]=check[t];
			}
			if(tcheck[i]==1)continue;
			tcheck[i]=1;
			int tsum;
			if(count==0||count==1)tsum=sum+arr[i];
			else tsum=sum-arr[i];
			answer=Math.min(answer, dfs(arr,tcheck,count+1,answer,tsum));
		}
		return answer;
	}
}
