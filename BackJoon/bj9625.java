import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());
        int a = 1;
        int b = 0;
        for(int i = 0; i < k; i++){
            int tb = a + b;
            int ta = b;

            a = ta;
            b = tb;
        }
        bw.write(a+" "+b);
        bw.flush();
        bw.close();
        br.close();
    }
}