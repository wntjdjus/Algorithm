// 백준 14499 주사위 굴리기
#include<iostream>
using namespace std;

int dy[5] = { 0,0,0,-1,1 };
int dx[5] = { 0,1,-1,0,0 };

int main() {
	int n, m, y, x, k;
	scanf("%d %d %d %d %d", &n, &m, &y, &x, &k);
	int** arr = new int*[n];
	int* karr = new int[k];
	// 0,탑,위,오,왼,아,바텀
	int cube[7] = { 0,0,0,0,0,0,0 };
	for (int i = 0; i < n; i++) arr[i] = new int[m];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &arr[i][j]);
		}
	}
	for (int i = 0; i < k; i++) scanf("%d", &karr[i]);
	for (int kk = 0; kk < k; kk++) {
		int d = karr[kk];	// 이동방향
		int ty = y + dy[d];
		int tx = x + dx[d];
		if (ty < 0 || ty >= n || tx < 0 || tx >= m) continue;
		// 1오 2왼 3위 4아
		if (d == 1) {
			int temp = cube[4];
			cube[4] = cube[6];
			cube[6] = cube[3];
			cube[3] = cube[1];
			cube[1] = temp;
		}
		else if (d == 2) {
			int temp = cube[3];
			cube[3] = cube[6];
			cube[6] = cube[4];
			cube[4] = cube[1];
			cube[1] = temp;
		}
		else if (d == 3) {
			int temp = cube[5];
			cube[5] = cube[6];
			cube[6] = cube[2];
			cube[2] = cube[1];
			cube[1] = temp;
		}
		else {
			int temp = cube[2];
			cube[2] = cube[6];
			cube[6] = cube[5];
			cube[5] = cube[1];
			cube[1] = temp;
		}
		if (arr[ty][tx] == 0) {
			arr[ty][tx] = cube[6];
		}
		else {
			cube[6] = arr[ty][tx];
			arr[ty][tx] = 0;
		}
		printf("%d\n", cube[1]);
		y = ty;
		x = tx;
	}

	return 0;
}