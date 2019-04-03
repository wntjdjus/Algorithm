import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {	// 백준7785 회사에 있는 사람
	static int MAX_SIZE=301;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine().trim());
		Queue<String>[] table = null;
		for(int i=0;i<MAX_SIZE;i++) table[i]=new LinkedList<>();
		for(int i=0;i<n;i++) {
			String str=br.readLine().trim();
			StringTokenizer st=new StringTokenizer(str);
			String name=st.nextToken();
			String command=st.nextToken();
			if(command.equals("enter")) enter(table,name);
			else leave(table,name);
			
		}
	}
	public static void enter(Queue<String>[] table, String name) {
		int index=H(name);
		table[index].add(name);
	}
	public static void leave(Queue<String>[] table, String name) {
		int index=H(name);
		table[index].remove();
	}
}
