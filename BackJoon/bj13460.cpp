/*
백준 13460번 구슬 탈출2
.빈공간0
#벽1
O탈출구2
R레드볼,B블루볼
*/

#include<iostream>
#include<string>
#include<queue>
using namespace std;

typedef struct Node {
	int ry;
	int rx;
	int by;
	int bx;
	int time;
}Node;

int dy[4] = { -1,0,1,0 };
int dx[4] = { 0,1,0,-1 };

int* move(int** arr, int n, int m, int y, int x, int d) {	
	while (true) {
		int ty = y + dy[d];
		int tx = x + dx[d];
		if (ty < 0 || ty >= n || tx < 0 || tx >= m) break;
		if (arr[ty][tx] == 1) break;
		if (arr[ty][tx] == 2) {
			int* temp = new int[2];
			temp[0] = ty;
			temp[1] = tx;
			return temp;
		}
		y = ty;
		x = tx;
	}
	int* end = new int[2];
	end[0] = y;
	end[1] = x;
	return end;
}

int main() {
	int n, m;
	scanf("%d %d", &n, &m);
	bool chk[11][11][11][11];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < n; k++) {
				for (int l = 0; l < m; l++) {
					chk[i][j][k][l] = false;
				}
			}
		}
	}
	int** arr = new int*[n];
	for (int i = 0; i < n; i++) arr[i] = new int[m];
	int ry, rx, by, bx;
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			char c = str[j];
			if (c == '.') arr[i][j] = 0;
			else if (c == '#') arr[i][j] = 1;
			else if (c == 'O') arr[i][j] = 2;
			else if (c == 'R') {
				ry = i;
				rx = j;
				arr[i][j] = 0;
			}
			else if (c == 'B') {
				by = i;
				bx = j;
				arr[i][j] = 0;
			}
		}
	}
	chk[ry][rx][by][bx] = true;
	Node start = { ry,rx,by,bx,0 };
	queue<Node> q;
	q.push(start);
	int result = 99;
	while (!q.empty()) {
		Node node = q.front();
		q.pop();
		int redX = node.rx, redY = node.ry, blueX = node.bx, blueY = node.by;
		int time = node.time;
		if (arr[blueY][blueX] == 2) {
			continue;
		}
		else if (arr[redY][redX] == 2) {
			result = result < time ? result : time;
			//break;
		}
		// 위
		if (redY < blueY) {
			int* nextRed = move(arr, n, m, redY, redX, 0);
			int* nextBlue = move(arr, n, m, blueY, blueX, 0);
			if (arr[nextRed[0]][nextRed[1]]!=2&&nextBlue[0]==nextRed[0]&&nextBlue[1]==nextRed[1]) nextBlue[0]++;
			if (!chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
				chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
				Node next = { nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],time + 1 };
				q.push(next);
			}
		}
		else {
			int* nextBlue = move(arr, n, m, blueY, blueX, 0);
			int* nextRed = move(arr, n, m, redY, redX, 0);
			if (arr[nextRed[0]][nextRed[1]] != 2 && nextBlue[0] == nextRed[0] && nextBlue[1] == nextRed[1]) nextRed[0]++;
			if (!chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
				chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
				Node next = { nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],time + 1 };
				q.push(next);
			}
		}
		// 아래
		if (redY > blueY) {
			int* nextRed = move(arr, n, m, redY, redX, 2);
			int* nextBlue = move(arr, n, m, blueY, blueX, 2);
			if (arr[nextRed[0]][nextRed[1]] != 2 && nextBlue[0] == nextRed[0] && nextBlue[1] == nextRed[1]) nextBlue[0]--;
			if (!chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
				chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
				Node next = { nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],time + 1 };
				q.push(next);
			}
		}
		else {
			int* nextBlue = move(arr, n, m, blueY, blueX, 2);
			int* nextRed = move(arr, n, m, redY, redX, 2);
			if (arr[nextRed[0]][nextRed[1]] != 2 && nextBlue[0] == nextRed[0] && nextBlue[1] == nextRed[1]) nextRed[0]--;
			if (!chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
				chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
				Node next = { nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],time + 1 };
				q.push(next);
			}
		}
		// 오른쪽
		if (redX > blueX) {
			int* nextRed = move(arr, n, m, redY, redX, 1);
			int* nextBlue = move(arr, n, m, blueY, blueX, 1);
			if (arr[nextRed[0]][nextRed[1]] != 2 && nextBlue[0] == nextRed[0] && nextBlue[1] == nextRed[1]) nextBlue[1]--;
			if (!chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
				chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
				Node next = { nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],time + 1 };
				q.push(next);
			}
		}
		else {
			int* nextBlue = move(arr, n, m, blueY, blueX, 1);
			int* nextRed = move(arr, n, m, redY, redX, 1);
			if (arr[nextRed[0]][nextRed[1]] != 2 && nextBlue[0] == nextRed[0] && nextBlue[1] == nextRed[1]) nextRed[1]--;
			if (!chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
				chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
				Node next = { nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],time + 1 };
				q.push(next);
			}
		}
		// 왼쪽
		if (redX < blueX) {
			int* nextRed = move(arr, n, m, redY, redX, 3);
			int* nextBlue = move(arr, n, m, blueY, blueX, 3);
			if (arr[nextRed[0]][nextRed[1]] != 2 && nextBlue[0] == nextRed[0] && nextBlue[1] == nextRed[1]) nextBlue[1]++;
			if (!chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
				chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
				Node next = { nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],time + 1 };
				q.push(next);
			}
		}
		else {
			int* nextBlue = move(arr, n, m, blueY, blueX, 3);
			int* nextRed = move(arr, n, m, redY, redX, 3);
			if (arr[nextRed[0]][nextRed[1]] != 2 && nextBlue[0] == nextRed[0] && nextBlue[1] == nextRed[1]) nextRed[1]++;
			if (!chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
				chk[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
				Node next = { nextRed[0],nextRed[1],nextBlue[0],nextBlue[1],time + 1 };
				q.push(next);
			}
		}
	}
	if (result == -1 || result > 10) printf("-1\n");
	else printf("%d\n", result);
	//printf("%d\n", result);

	return 0;
}