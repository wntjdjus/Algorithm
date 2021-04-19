import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String str;
    static StringTokenizer st;
    static int n;
    static int m;
    static int[][] arr;
    public static class Node{
        int isHome;
        int y;
        int x;
        int dist;
        public Node(int isHome, int y, int x, int dist) {
            this.isHome = isHome;
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    static ArrayList<Node> homeList;
    static ArrayList<Node> marketList;
    static int[][][][] distList;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        homeList = new ArrayList<>();
        marketList = new ArrayList<>();
        str = br.readLine();
        st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());
        arr=new int[n][n];
        distList=new int[n][n][n][n];

        for(int i=0;i<n;i++){
            str=br.readLine();
            st=new StringTokenizer(str);
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    homeList.add(new Node(1,i,j,0));
                }else if(arr[i][j]==2){
                    marketList.add(new Node(2,i,j,0));
                }
            }
        }

        int homeListSize = homeList.size();
        for(int i=0;i<homeListSize;i++){
            Node home = homeList.get(i);
            bfs(home);
        }

        int marketListSize = marketList.size();
        boolean[] chkMarket = new boolean[marketListSize];
        int result = selectMarket(chkMarket, 0, 0,marketListSize);
        System.out.println(result);
    }
    public static int cal(boolean[] chk){
        int sum = 0;
        int homeListSize = homeList.size();
        int marketListSize = marketList.size();

        for(int i=0;i<homeListSize;i++){
            int min = Integer.MAX_VALUE;
            Node home = homeList.get(i);
            for(int j=0;j<marketListSize;j++){
                Node market = marketList.get(j);
                if(chk[j]){
                    min = StrictMath.min(min, distList[home.y][home.x][market.y][market.x]);
                }
            }
            sum += min;
        }

        return sum;
    }
    public static int selectMarket(boolean[] chk, int idx, int cnt, int maxSize){
        if(cnt == m){
            return cal(chk);
        }
        if(idx >= maxSize){
            return Integer.MAX_VALUE;
        }

        int result = Integer.MAX_VALUE;

        int tmp = selectMarket(chk, idx+1, cnt, maxSize);
        result = StrictMath.min(result, tmp);

        chk[idx] = true;
        tmp = selectMarket(chk, idx+1, cnt+1, maxSize);
        result = StrictMath.min(result, tmp);
        chk[idx] = false;

        return result;
    }
    public static void bfs(Node start){
        int[] dy={-1,0,1,0};
        int[] dx={0,1,0,-1};
        Queue<Node> q = new LinkedList<>();
        boolean[][] chk = new boolean[n][n];

        chk[start.y][start.x] = true;
        q.add(start);

        while(!q.isEmpty()){
            Node node = q.remove();

            if(node.isHome==2){
                distList[start.y][start.x][node.y][node.x] = node.dist;
            }

            for(int d=0;d<4;d++){
                int ty=node.y+dy[d];
                int tx=node.x+dx[d];
                if(ty<0 || ty>=n || tx<0 || tx>=n){
                    continue;
                }
                if(chk[ty][tx]){
                    continue;
                }
                chk[ty][tx] = true;
                q.add(new Node(arr[ty][tx],ty,tx,node.dist+1));
            }
        }

    }
}