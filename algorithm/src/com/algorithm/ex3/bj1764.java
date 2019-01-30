package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s = br.readLine();
		st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String[] dperson = new String[n];
		String[] dbperson = new String[n];
		int dbindex = 0;
		for(int i = 0; i < n; i++) {
			dperson[i] = br.readLine();
		}
		Arrays.sort(dperson, String.CASE_INSENSITIVE_ORDER);
		for(int i = 0; i < m; i++) {
			s = br.readLine();
			int left = 0;
			int right = n-1;
			while(left <= right) {
				int mid = (left+right)>>1;
				if(s.compareTo(dperson[mid]) == 0) {
					dbperson[dbindex++] = s;
					break;
				}
				else if(s.compareTo(dperson[mid]) > 0) {
					left = mid+1;
				}
				else {
					right = mid-1;
				}
			}
		}
		Arrays.sort(dbperson, 0,dbindex);
		bw.write(""+dbindex+"\n");
		for(int i = 0; i < dbindex; i++) {
			bw.write(dbperson[i]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
