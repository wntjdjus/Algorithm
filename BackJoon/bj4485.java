package com.algorithm.day0213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj4485 {	// ³ì»ö ¿ÊÀ» ÀÔÀº ¾Ö°¡ Á©´ÙÁö?
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static class Node{
		int y;
		int x;
		int sum;
		Node next;
		Node prev;
		public Node() {
			this.next=null;
			this.prev=null;
		}
		public Node(int y, int x, int sum) {
			this.y=y;
			this.x=x;
			this.sum=sum;
			this.next=null;
			this.prev=null;
		}
	}
	static class Queue{
		public Node head;
		public Queue() {
			head=new Node();
		}
		public boolean isEmpty() {
			if(head.next==null) return true;
			return false;
		}
		public void add(Node node) {
			if(isEmpty()) {
				head.next=node;
				node.prev=head;
				return;
			}
			node.next=head.next;
			node.prev=head;
			while(true) {
				if(node.next.sum>node.sum) {
					node.next.prev=node;
					node.prev.next=node;
					break;
				}
				node.prev=node.next;
				node.next=node.next.next;
				if(node.next==null) {
					node.prev.next=node;
					break;
				}
			}
		}
		public Node remove() {
			Node node=head.next;
			head.next=node.next;
			node.next=null;
			node.prev=null;
			return node;
		}
		public void print() {
			Node t=new Node();
			t.next=head.next;
			while(t.next!=null) {
				Node temp=t.next;
				System.out.print("("+temp.y+","+temp.x+","+temp.sum+")");
				t.next=t.next.next;
			}
			System.out.println();
		}
	}
	static int[][] arr;
	static int[][] dp;
	static boolean[][] visit;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {-1,1,0,0};
	static int n;
	static Queue q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t=0;
		while(true) {
			t++;
			q=new Queue();
			StringTokenizer st;
			n=Integer.parseInt(br.readLine());
			if(n==0)break;
			arr=new int[n][n];
			dp=new int[n][n];
			visit=new boolean[n][n];
			for(int i=0;i<n;i++) {
				String str=br.readLine();
				st=new StringTokenizer(str);
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			bw.write("Problem "+t+": "+dp[n-1][n-1]+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void bfs() {
		visit[0][0]=true;
		dp[0][0]=arr[0][0];
		Node start=new Node(0,0,dp[0][0]);
		q.add(start);
		while(!q.isEmpty()) {
//			q.print();
			Node node=q.remove();
			int x=node.x;
			int y=node.y;
			if(x==n-1&&y==n-1)break;
			for(int d=0;d<4;d++) {
				int tx=x+dx[d];
				int ty=y+dy[d];
				if(tx<0||tx>=n||ty<0||ty>=n) continue;
				if(visit[ty][tx]) continue;
				visit[ty][tx]=true;
				dp[ty][tx]=dp[y][x]+arr[ty][tx];
				Node tnode=new Node(ty,tx,dp[ty][tx]);
				q.add(tnode);
			}
		}
	}
}
