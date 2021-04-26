import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj17144 {
    // 미세먼지 클래스, 위치와 먼지양을 가짐.
    public static class Dust{
        int y;
        int x;
        int n;

        public Dust(int y, int x, int n) {
            this.y = y;
            this.x = x;
            this.n = n;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dy={-1,0,1,0};
        int[] dx={0,1,0,-1};
        String str = br.readLine();
        StringTokenizer st=new StringTokenizer(str);
        int r = Integer.parseInt(st.nextToken());   // 행
        int c = Integer.parseInt(st.nextToken());   // 열
        int time = Integer.parseInt(st.nextToken());   // 시간
        int[][] arr = new int[r][c];    // 미세먼지 배열
        int[] air = new int[2];     // 공기청정기 위치
        int airIdx = 0; // 처음 위치 값 받기 위한 임시 인덱스 변수
        Queue<Dust> q = new LinkedList<>(); // 미세먼지 큐, 각 시간마다 존재하는 미세먼지들을 모두 넣어놓는다.
        int sum = 0;    // 정답 미세먼지 양

        // 배열 초기화
        for(int i=0;i<r;i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0;j<c;j++){
                int tmp = Integer.parseInt(st.nextToken());
                // 미세먼지면 큐에 넣고, 공기청정기면 공기청정기 변수 저장
                if(tmp > 0){
                    q.add(new Dust(i,j,tmp));
                }else if(tmp == -1){
                    arr[i][j] = -1;
                    air[airIdx] = i;
                    airIdx+=1;
                }
            }
        }
        // time초 동안 일이 발생
        for(int t = 1; t <= time; t++){
            // 1. 미세먼지 확산
            while(!q.isEmpty()){
                Dust dust = q.remove();
                int remain = dust.n;    // 남는 먼지 양
                int toss = dust.n / 5;  // 주변에 확산할 먼지 양
                // 주변 4방향 확인하여 확산 가능하면 먼지 확산
                for(int d=0;d<4;d++){
                    int ty=dust.y+dy[d];
                    int tx=dust.x+dx[d];
                    // 확산 불가능 조건 체크
                    if(ty<0 || ty>=r || tx<0 || tx>=c){
                        continue;
                    }
                    if(arr[ty][tx] == -1){
                        continue;
                    }
                    // 확산
                    arr[ty][tx]+=toss;  // 기존 위치에 있는 먼지 값에 +해준다.
                    remain-=toss;
                }
                arr[dust.y][dust.x] += remain;   // 남는 먼지양 +해준다.
            }

            // 2. 공기청정기 작동
            // 위쪽 공기청정기
            for(int k=air[0]-1;k>0;k--){
                arr[k][0] = arr[k-1][0];
            }
            for(int k=0;k<c-1;k++){
                arr[0][k] = arr[0][k+1];
            }
            for(int k=0;k<air[0];k++){
                arr[k][c-1] = arr[k+1][c-1];
            }
            for(int k=c-1;k>0;k--){
                arr[air[0]][k] = arr[air[0]][k-1];
                if(k==1){
                    arr[air[0]][k]=0;
                }
            }
            // 아래쪽 공기청정기
            for(int k=air[1]+1;k<r-1;k++){
                arr[k][0] = arr[k+1][0];
            }
            for(int k=0;k<c-1;k++){
                arr[r-1][k] = arr[r-1][k+1];
            }
            for(int k=r-1;k>air[1];k--){
                arr[k][c-1] = arr[k-1][c-1];
            }
            for(int k=c-1;k>0;k--){
                arr[air[1]][k] = arr[air[1]][k-1];
                if(k==1){
                    arr[air[1]][k]=0;
                }
            }

            // 3. 미세먼지들 다시 큐에 넣고, 배열 값은 0으로 만들기 (다음 시간 동작들을 위해)
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(arr[i][j]>0){
                        // 마지막 타임이면 정답 구하고, 아니면 큐에 넣는다.
                        if(t==time) {
                            sum += arr[i][j];
                        }else{
                            q.add(new Dust(i,j,arr[i][j]));
                            arr[i][j] = 0;
                        }
                    }
                }
            }
        }
        bw.write(""+sum);

        bw.flush();
        bw.close();
        br.close();
    }
}