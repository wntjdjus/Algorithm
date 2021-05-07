import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11226{
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        String str=br.readLine();
        StringTokenizer st=new StringTokenizer(str);
        int v=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] list=new ArrayList[v+1];
        for(int i=1;i<=v;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            str=br.readLine();
            st=new StringTokenizer(str);
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        boolean[] chk=new boolean[v+1];
        int[] dstNum=new int[v+1];
        boolean[] isCut=new boolean[v+1];
        for(int i=1;i<=v;i++){
            if(!chk[i]){
                n=1;
                int tmp = dfs(list,chk,dstNum,isCut,i);
            }
        }
        int cnt=0;
        for(int i=1;i<=v;i++){
//            System.out.print(dstNum[i]+"("+isCut[i]+") ");
            if(isCut[i]){
                cnt+=1;
            }
        }
//        System.out.println();
        bw.write(cnt+"\n");
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=v;i++){
            if(isCut[i]){
                sb.append(i);
                if(i!=v){
                    sb.append(' ');
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(ArrayList<Integer>[] list,boolean[] chk, int[] dstNum, boolean[] isCut, int node){
        chk[node]=true;
        dstNum[node]=n++;
        int min=dstNum[node];
        int ll=list[node].size();
        int cnt=0;
        for(int i=0;i<ll;i++){
            int tmp=list[node].get(i);
            if(!chk[tmp]){
                cnt+=1;
                int prev = dfs(list,chk,dstNum,isCut,tmp);
                if(dstNum[node]!=1 && prev>=dstNum[node]){
                    isCut[node]=true;
                }
                min=Math.min(min,prev);
            }else{
                min=Math.min(min,dstNum[tmp]);
            }
        }
        if(dstNum[node]==1 && cnt>=2){
            isCut[node]=true;
        }
        return min;
    }
}