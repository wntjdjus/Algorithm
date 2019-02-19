package com.algorithm.day0219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj2864 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		String str=br.readLine();
		StringTokenizer st=new StringTokenizer(str);
		String s1=st.nextToken();
		String s2=st.nextToken();
		String sub1="";
		String sub2="";
		int index=0;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)=='6') {
				sub1+=s1.substring(index, i);
				sub1+="5";
				index=i+1;
			}
		}
		sub1+=s1.substring(index,s1.length());
		index=0;
		for(int i=0;i<s2.length();i++) {
			if(s2.charAt(i)=='6') {
				sub2+=s2.substring(index, i);
				sub2+="5";
				index=i+1;
			}
		}
		sub2+=s2.substring(index,s2.length());
		int a=Integer.parseInt(sub1);
		int b=Integer.parseInt(sub2);
		bw.write((a+b)+" ");
		sub1="";
		sub2="";
		index=0;
		for(int i=0;i<s1.length();i++) {
			if(s1.charAt(i)=='5') {
				sub1+=s1.substring(index, i);
				sub1+="6";
				index=i+1;
			}
		}
		sub1+=s1.substring(index,s1.length());
		index=0;
		for(int i=0;i<s2.length();i++) {
			if(s2.charAt(i)=='5') {
				sub2+=s2.substring(index, i);
				sub2+="6";
				index=i+1;
			}
		}
		sub2+=s2.substring(index,s2.length());
		a=Integer.parseInt(sub1);
		b=Integer.parseInt(sub2);
		bw.write((a+b)+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
