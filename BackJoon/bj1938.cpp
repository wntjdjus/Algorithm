// bj1938 통나무 옮기기
/*
U,D,L,R,T
통나무[머리,몸통,꼬리] 머리는 위 or 왼쪽, 꼬리는 아래 or 오른쪽
나무1,빈칸0,내꺼2,도착점3
*/
#include<iostream>
#include<string>
#include<queue>
using namespace std;

int dy[8] = { -1,0,1,0,-1,-1,1,1 };
int dx[8] = { 0,1,0,-1,-1,1,1,-1 };

typedef struct Namu {
	int hy;
	int hx;
	int gase;
	int time;
}Namu;

int main() {
	queue<Namu> q;
	int n;
	int na[3][2];
	int index = 0;
	scanf("%d", &n);
	int** arr = new int*[n];
	bool*** chk = new bool**[n];
	for (int i = 0; i < n; i++) {
		arr[i] = new int[n];
		chk[i] = new bool*[n];
		for (int j = 0; j < n; j++) {
			chk[i][j] = new bool[2];
		}
	}
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < n; j++) {
			char c=str[j];
			if (c == 'B') {
				na[index][0] = i;
				na[index][1] = j;
				index++;
				arr[i][j] = 0;
			}
			else if (c == 'E') arr[i][j] = 3;
			else if (c == '0') arr[i][j] = 0;
			else if (c == '1') arr[i][j] = 1;
			chk[i][j][0] = false;
			chk[i][j][1] = false;
		}
	}
	int flag = 0;	// 세로
	if (na[0][1] != na[1][1]) flag = 1;	// 가로
	Namu namu = { na[0][0],na[0][1],flag,0 };
	q.push(namu);
	chk[namu.hy][namu.hx][flag] = true;
	while (!q.empty()) {
		Namu mu = q.front();
		q.pop();
		//printf("%d %d %d %d\n", mu.hy, mu.hx, mu.gase,mu.time);
		if (mu.gase == 0) {	// 세로
			if (arr[mu.hy][mu.hx] == 3 && arr[mu.hy + 1][mu.hx] == 3 && arr[mu.hy + 2][mu.hx] == 3) {
				printf("%d\n", mu.time);
				return 0;
			}
			for (int d = 0; d < 4; d++) {
				int thy = mu.hy + dy[d];
				int thx = mu.hx + dx[d];
				int tty = mu.hy + dy[d] + 2;
				int ttx = mu.hx + dx[d];
				if (thy < 0 || tty >= n || thx < 0 || ttx >= n) continue;
				if (arr[thy][thx] == 1 || arr[thy + 1][thx] == 1 || arr[thy + 2][thx] == 1)continue;
				if (chk[thy][thx][mu.gase]) continue;
				chk[thy][thx][mu.gase] = true;
				Namu next = { thy,thx,mu.gase,mu.time + 1 };
				q.push(next);
			}
			int midy = mu.hy + 1;
			int midx = mu.hx;
			bool flag = true;
			for (int d = 0; d < 8; d++) {
				if (midy + dy[d] < 0 || midy + dy[d] >= n || midx + dx[d] < 0 || midx + dx[d] >= n) {
					flag = false;
					break;
				}
				if (arr[midy + dy[d]][midx + dx[d]] == 1) {
					flag = false;
					break;
				}
			}
			if (!flag) continue;
			if (chk[midy][midx - 1][1 - mu.gase])continue;
			chk[midy][midx - 1][1 - mu.gase] = true;
			Namu next = { midy,midx - 1,1 - mu.gase,mu.time + 1 };
			q.push(next);
		}
		else if (mu.gase == 1) {	// 가로
			if (arr[mu.hy][mu.hx] == 3 && arr[mu.hy][mu.hx + 1] == 3 && arr[mu.hy][mu.hx + 2] == 3) {
				printf("%d\n", mu.time);
				return 0;
			}
			for (int d = 0; d < 4; d++) {
				int thy = mu.hy + dy[d];
				int thx = mu.hx + dx[d];
				int tty = mu.hy + dy[d];
				int ttx = mu.hx + dx[d] + 2;
				if (thy < 0 || tty >= n || thx < 0 || ttx >= n) continue;
				if (arr[thy][thx] == 1 || arr[thy][thx + 1] == 1 || arr[thy][thx + 2] == 1)continue;
				if (chk[thy][thx][mu.gase]) continue;
				chk[thy][thx][mu.gase] = true;
				Namu next = { thy,thx,mu.gase,mu.time + 1 };
				q.push(next);
			}
			int midy = mu.hy;
			int midx = mu.hx + 1;
			bool flag = true;
			for (int d = 0; d < 8; d++) {
				if (midy + dy[d] < 0 || midy + dy[d] >= n || midx + dx[d] < 0 || midx + dx[d] >= n) {
					flag = false;
					break;
				}
				if (arr[midy + dy[d]][midx + dx[d]] == 1) {
					flag = false;
					break;
				}
			}
			if (!flag) continue;
			if (chk[midy - 1][midx][1 - mu.gase])continue;
			chk[midy - 1][midx][1 - mu.gase] = true;
			Namu next = { midy - 1,midx,1 - mu.gase,mu.time + 1 };
			q.push(next);
		}
	}
	printf("%d\n", 0);
	//for (int i = 0; i < n; i++) {
	//	for (int j = 0; j < n; j++) {
	//		printf("%d ", arr[i][j]);
	//	}
	//	printf("\n");
	//}

	return 0;
}