package com.algorithm.ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj3184 {	// ¾ç
	static class node{
		int x;
		int y;
		public node(int y, int x){
			this.x = x;
			this.y = y;
		}
	}
	// {. , # , V , O } = { 0 , -1 , 1 , 2 }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String s = br.readLine();
		st = new StringTokenizer(s);
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[][] arr = new int[r][c];
		int[][] check = new int[r][c];
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		node[] q = new node[r*c+1];
		int front = -1;
		int rear = -1;
		for(int i = 0; i < r; i++) {
			s = br.readLine();
			for(int j = 0; j < c; j++) {
				char cc = s.charAt(j);
				switch(cc) {
				case '.':
					arr[i][j] = 0;
					break;
				case '#':
					arr[i][j] = -1;
					break;
				case 'v':
					arr[i][j] = 1;
					break;
				case 'o':
					arr[i][j] = 2;
					break;
				}
			}
		}
		int osum = 0;
		int vsum = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(arr[i][j] == -1 || check[i][j] == 1) continue;
				check[i][j] = 1;
				int o = 0;
				int v = 0;
				q[++rear] = new node(i,j);
				while(front!=rear) {
					node tn = q[++front];
					if(arr[tn.y][tn.x]==1) v++;
					else if(arr[tn.y][tn.x]==2) o++;
					for(int k=0;k<4;k++) {
						int tx=tn.x+dx[k];
						int ty=tn.y+dy[k];
						if(tx>=0&&tx<c&&ty>=0&&ty<r) {
							if(arr[ty][tx]==-1||check[ty][tx]==1) continue;
							 check[ty][tx]=1;
							 q[++rear]=new node(ty,tx);
						}
					}
				}
				if(v>=o)o=0;
				else v=0;
				osum+=o;
				vsum+=v;
			}
		}
		bw.write(""+osum+" "+vsum);
		bw.flush();
		bw.close();
	}

}
