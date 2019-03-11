package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj5427 {		// 불
	// 빈공간 . : 0
	// 벽 # : 1
	// 시작위치 @ : 2
	// 불 * : 3
	
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static class node{
		int x;
		int y;
		int c;
		int count;
		public node(int y,int x,int c,int count) {
			this.x=x;
			this.y=y;
			this.c=c;
			this.count=count;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s;
		int test=Integer.parseInt(br.readLine());
		for(int t=0;t<test;t++) {
			s=br.readLine();
			st=new StringTokenizer(s);
			int w=Integer.parseInt(st.nextToken());
			int h=Integer.parseInt(st.nextToken());
			int[][] arr=new int[h][w];
			node[] q=new node[2000000];
			int front=-1;
			int rear=-1;
			node start=new node(0,0,0,0);
			for(int i=0;i<h;i++) {
				s=br.readLine();
				for(int j=0;j<w;j++) {
					char c=s.charAt(j);
					if(c=='.') arr[i][j]=0;
					else if(c=='#') arr[i][j]=1;
					else if(c=='@') {
						arr[i][j]=2;
						start=new node(i,j,2,0);
					}
					else if(c=='*') {
						arr[i][j]=3;
						node no=new node(i,j,3,0);
						q[++rear]=no;
					}
				}
			}
			q[++rear]=start;
			int exit=0;
			while(front!=rear) {
				node temp=q[++front];
				for(int d=0;d<4;d++) {
					int tx=temp.x+dx[d];
					int ty=temp.y+dy[d];
					if(temp.c==2) {
						if(tx<0||tx>=w||ty<0||ty>=h) {
							System.out.println(temp.count+1);
							exit=1;
							break;
						}
						if(arr[ty][tx]==0) {
							arr[ty][tx]=2;
							node tt=new node(ty,tx,2,temp.count+1);
							q[++rear]=tt;
						}
					}
					else {
						if(tx<0||tx>=w||ty<0||ty>=h)continue;
						if(arr[ty][tx]==0||arr[ty][tx]==2) {
							arr[ty][tx]=3;
							node tt=new node(ty,tx,3,temp.count+1);
							q[++rear]=tt;
						}						
					}
				}
				if(exit==1)break;
			}
			if(exit==0) System.out.println("IMPOSSIBLE");
		}
	}

}
