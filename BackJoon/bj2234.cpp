/*
백준2234 성곽
0000  --> 남동북서 (비트)
남3 동2 북1 서0 만큼 << 밀기	왼위오아
*/
#include<iostream>
#include<queue>
using namespace std;

typedef struct Node {
	int y;
	int x;
}Node;

int dy[4] = { 0,-1,0,1 };
int dx[4] = { -1,0,1,0 };

int* bfs(int** arr, bool** chk, int n, int m, int sy, int sx) {
	int* temp = new int[2];
	temp[0] = 1, temp[1] = 0;
	queue<Node> q;
	Node start = { sy,sx };
	q.push(start);
	chk[sy][sx] = true;
	while (!q.empty()) {
		Node node = q.front();
		q.pop();
		temp[1] += 1;
		int y = node.y, x = node.x;
		for (int i = 0; i < 4; i++) {
			//printf("%d %d\n",i,(arr[y][x]&(1<<i)));
			int ty = y + dy[i], tx = x + dx[i];
			if (ty < 0 || ty >= n || tx < 0 || tx >= m) continue;
			if ((arr[y][x] & (1 << i)) != 0) continue;
			if (chk[ty][tx]) continue;
			Node next = { ty,tx };
			q.push(next);
			chk[ty][tx] = true;
		}
	}
	return temp;
}
int bfs2(int** arr, int n, int m, int sy, int sx) {
	bool** chk = new bool*[n];
	for (int i = 0; i < n; i++) {
		chk[i] = new bool[m];
		for (int j = 0; j < m; j++) chk[i][j] = false;
	}
	int cnt = 0;
	queue<Node> q;
	Node start = { sy,sx };
	q.push(start);
	chk[sy][sx] = true;
	while (!q.empty()) {
		Node node = q.front();
		q.pop();
		cnt += 1;
		int y = node.y, x = node.x;
		for (int i = 0; i < 4; i++) {
			//printf("%d %d\n",i,(arr[y][x]&(1<<i)));
			int ty = y + dy[i], tx = x + dx[i];
			if (ty < 0 || ty >= n || tx < 0 || tx >= m) continue;
			if ((arr[y][x] & (1 << i)) != 0) continue;
			if (chk[ty][tx]) continue;
			Node next = { ty,tx };
			q.push(next);
			chk[ty][tx] = true;
		}
	}
	return cnt;
}

int main() {
	int m, n;
	scanf("%d %d", &m, &n);
	int** arr = new int*[n];
	bool** chk = new bool*[n];
	for (int i = 0; i < n; i++) {
		arr[i] = new int[m];
		chk[i] = new bool[m];
		for (int j = 0; j < m; j++) {
			scanf("%d", &arr[i][j]);
			chk[i][j] = false;
		}
	}
	int room = 0, max = 0, max2 = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {

			for (int k = 0; k < 4; k++) {
				if ((arr[i][j] & (1 << k)) == 0) continue;
				arr[i][j] &= (~(1 << k));
				int tcnt = bfs2(arr, n, m, i, j);
				max2 = max2 > tcnt ? max2 : tcnt;
				arr[i][j] |= (1 << k);
			}
			if (chk[i][j]) continue;
			int* temp=bfs(arr, chk, n, m, i, j);
			room += temp[0];
			max = max > temp[1] ? max : temp[1];
		}
	}
	printf("%d\n%d\n%d", room, max, max2);

	return 0;
}