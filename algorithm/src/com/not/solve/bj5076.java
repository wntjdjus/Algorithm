package com.not.solve;

import java.util.Scanner;

public class bj5076 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String s = sc.nextLine();
			//s = s.replaceAll(" ", "");
			if(s.equals("")) continue;
			if(s.charAt(0) == '#') return;
			String[] sarr = new String[256];
			int top = -1;
			int start = 0;
			int end = 0;
			int flag = 1;
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '<') {
					start = i;
					flag = 0;
				}
				else if(s.charAt(i) == '>') {
					end = i;
					flag = 1;
					if(s.charAt(start) != '<') {
						flag = 0;
						break;
					}
					String sub = s.substring(start+1, end);
					if(sub.equals("")) {
						flag = 0;
						break;
					}
					if(sub.charAt(0) != '/') {
						if(sub.charAt(sub.length()-1) == '/') {
							continue;
						}
						String temp = sub.split(" ")[0];
						sarr[++top] = temp;
					}
					else {
						String sub2 = sub.substring(1, sub.length());
						if(top == -1) {
							flag = 0;
							break;
						}
						if(sarr[top].equals(sub2)) {
							sarr[top--] = null;
						}
						else {
							flag = 0;
							break;
						}
					}
					
				}
			}
			if(top != -1) flag = 0;
//			for(int i =0; i <= top; i++) {
//				System.out.print(sarr[i]+" ");
//			}
			System.out.println(flag == 1 ? "legal":"illegal");
		}
	}

}
