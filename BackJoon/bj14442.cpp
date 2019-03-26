// 백준 14442 벽 부수고 이동하기 2
#include<iostream>
#include<string>
#include<queue>
using namespace std;

typedef struct Node {
	int y;
	int x;
	int wall;
	int time;
}Node;

int dx[4] = { 0,1,0,-1 };
int dy[4] = { -1,0,1,0 };

int main() {
	int n, m, k;
	scanf("%d %d %d", &n, &m, &k);
	int** arr = new int*[n + 1];
	bool*** chk = new bool**[n + 1];
	for (int i = 0; i <= n; i++) {
		arr[i] = new int[m + 1];
		chk[i] = new bool*[m + 1];
		for (int j = 0; j <= m; j++) {
			chk[i][j] = new bool[k + 1];
		}
	}
	for (int i = 1; i <= n; i++) {
		string str;
		cin >> str;
		for (int j = 1; j <= m; j++) {
			int c = str[j-1]-'0';
			arr[i][j] = c;
			for (int u = 0; u <= k; u++) {
				chk[i][j][u] = false;
			}
		}
	}
	queue<Node> q;
	Node start = { 1,1,k,1 };
	q.push(start);
	chk[1][1][k] = true;
	int dis = -1;
	while (!q.empty()) {
		Node node = q.front();
		q.pop();
		int y = node.y;
		int x = node.x;
		int wall = node.wall;
		int time = node.time;
		if (y == n && x == m) {
			dis = time;
			break;
		}
		for (int d = 0; d < 4; d++) {
			int ty = y + dy[d];
			int tx = x + dx[d];
			if (ty <= 0 || ty > n || tx <= 0 || tx > m) continue;
			if (chk[ty][tx][wall]) continue;
			if (arr[ty][tx] == 1) {
				if (wall == 0)continue;
				chk[ty][tx][wall] = true;
				Node next = { ty,tx,wall - 1,time + 1 };
				q.push(next);
			}
			else {
				chk[ty][tx][wall] = true;
				Node next = { ty,tx,wall,time + 1 };
				q.push(next);
			}
		}
	}
	printf("%d\n", dis);
	/*for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			printf("%d", arr[i][j]);
		}
		printf("\n");
	}*/

	return 0;
}