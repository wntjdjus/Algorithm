package com.algorithm.code;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookTest1 {

	public static void main(String[] args) throws FileNotFoundException{
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		
		int t, n;
		
		//System.setIn(new FileInputStream("Solution11.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int temp = 1; temp <= t; temp++) {
			int count = 0;
			n = sc.nextInt();
			char[][] arr = new char[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] == 'S' || arr[i][j] == 'W') {
						continue;
					}
					int x = j, y = i;
					switch(arr[i][j]) {
					case 'A':
						while(true) {
							x += dx[3];
							y += dy[3];
							
							if(x < n && arr[y][x] == 'S') {
								count++;
							}
							else {
								break;
							}
						}
						break;
					case 'B':
						for(int k = 2; k < 4; k++) {
							int tx = x, ty = y;
							while(true) {
								tx += dx[k];
								
								if(tx >= 0 && tx < n && arr[ty][tx] == 'S') {
									count++;
								}
								else {
									break;
								}
							}
						}
						break;
					case 'C':
						for(int k = 0; k < 4; k++) {
							int tx = x, ty = y;
							while(true) {
								tx += dx[k];
								ty += dy[k];
								if(tx >= 0 && ty >= 0 && tx < n && ty < n && arr[ty][tx] == 'S') {
									count++;
								}
								else {
									break;
								}
							}
						}
						break;
						default:
							break;
					}
				}
			}
			System.out.println("#"+temp+" "+count);
		}
	}

}
