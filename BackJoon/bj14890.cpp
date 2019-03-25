#include<iostream>
using namespace std;

int dy[2] = { 0,1 };
int dx[2] = { 1,0 };

bool isRoad(int start, int d, int n, int** arr, int k, bool** chk) {
	int sy = 0;
	int sx = 0;
	if (d == 0)sy = start;
	else sx = start;
	for (int i = 0; i < n; i++) {
		if (d == 0) chk[sy][i] = false;
		else chk[i][sx] = false;
	}
	while (true) {
		int ty = sy + dy[d];
		int tx = sx + dx[d];
		if (ty >= n || tx >= n) break;
		if (arr[ty][tx] == arr[sy][sx]) {
			sy = ty;
			sx = tx;
			continue;
		}
		else if(arr[ty][tx]==arr[sy][sx]-1){
			for (int i = 1; i <= k; i++) {
				int ny = sy + dy[d] * i;
				int nx = sx + dx[d] * i;
				if (ny >= n || nx >= n) return false;
				if (arr[ny][nx] != arr[sy][sx] - 1) return false;
				chk[ny][nx] = true;
			}
			sy += dy[d] * k;
			sx += dx[d] * k;
		}
		else if (arr[ty][tx] == arr[sy][sx] + 1) {
			for (int i = 1; i <= k; i++) {
				int ny = ty - dy[d] * i;
				int nx = tx - dx[d] * i;
				if (ny < 0 || nx < 0) return false;
				if (arr[ny][nx] != arr[ty][tx] - 1) return false;
				if (chk[ny][nx]) return false;
				chk[ny][nx] = true;
			}
			sy = ty;
			sx = tx;
		}
		else return false;
	}
	
	return true;
}

int main() {
	int n, l,count=0;
	scanf("%d %d", &n, &l);
	int** arr = new int*[n];
	bool** chk = new bool*[n];
	for (int i = 0; i < n; i++) {
		arr[i] = new int[n];
		chk[i] = new bool[n];
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	for (int i = 0; i < n; i++) if (isRoad(i, 0, n, arr, l, chk)) count++;
	for (int j = 0; j < n; j++) if (isRoad(j, 1, n, arr, l, chk)) count++;
	printf("%d\n", count);

	return 0;
}