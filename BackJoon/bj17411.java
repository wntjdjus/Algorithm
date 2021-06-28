import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int n;
        int cnt;
        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] subArr = new int[n+1];
        ArrayList<Node>[] subArrCnt=new ArrayList[n+1];
        for(int i =0;i<=n;i++){
            subArrCnt[i]=new ArrayList<>();
            if(i==0){
                subArrCnt[i].add(new Node(Integer.MIN_VALUE,1));
            }
        }
        int subIdx = 0;
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0;i<n;i++){
            int l = 1;
            int r = subIdx;
            while (l <= r) {
                int mid = (l+r)>>1;
                if(subArr[mid]>arr[i]){
                    r = mid-1;
                }else if(subArr[mid]==arr[i]){
                    l = mid;
                    break;
                }else{
                    l = mid+1;
                }
            }

            subArr[l] = arr[i];
            Node node = new Node(arr[i],0);
            int size = subArrCnt[l-1].size();
            for(int j=0;j<size;j++){
                Node pre = subArrCnt[l-1].get(j);
                if(pre.n<node.n){
                    node.cnt=(node.cnt+pre.cnt)%1000000007;
                }
            }
            subArrCnt[l].add(node);
            if(l>subIdx){
                subIdx=l;
            }
        }

        int answerSize = subArrCnt[subIdx].size();
        int answer = 0;
        for(int i =0;i<answerSize;i++){
            answer = (answer+subArrCnt[subIdx].get(i).cnt)%1000000007;
        }

        bw.write(subIdx+" "+answer);
        bw.flush();
        bw.close();
        br.close();
    }
}