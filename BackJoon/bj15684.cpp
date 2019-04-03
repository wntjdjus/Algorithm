/*
백준 15684 사다리 조작
*/
#include<iostream>
using namespace std;

bool sadari(bool** arr, int n, int h) {
	for (int i = 1; i <= n; i++) {
		int startX = i, startY = 1;
		while (startY<=h) {
			if (arr[startY][startX]) startX++;
			else if (arr[startY][startX - 1]) startX--;
			startY++;
		}
		if (startX != i) return false;
	}
	return true;
}

int go(bool** arr, int n, int h, int y, int x, int count) {
	if (sadari(arr,n,h)) return count;
	else if (count == 3) return 9999;
	int min = 9999;
	for (int i = 1; i <= h; i++) {
		for (int j = 1; j < n; j++) {
			if ((10 * i + j) <= (10 * y + x)) continue;
			if (!arr[i][j - 1] && !arr[i][j] && !arr[i][j + 1]) {
				arr[i][j] = true;
				int temp = go(arr, n, h, i, j, count + 1);
				min = min < temp ? min : temp;
				arr[i][j] = false;
				if (min == 1) return 1;
			}
		}
	}
	return min;
}

int main() {
	int n, m, h;
	scanf("%d %d %d", &n, &m, &h);
	bool** arr = new bool*[h + 1];
	for (int i = 0; i <= h; i++) {
		arr[i] = new bool[n + 1];
		for (int j = 0; j <= n; j++) arr[i][j] = false;
	}
	for (int mm = 0; mm < m; mm++) {
		int a, b;
		scanf("%d %d", &a, &b);
		arr[a][b] = true;
	}
	int min=go(arr, n, h, 0, 0, 0);
	if (min == 9999) min = -1;
	printf("%d\n", min);

	return 0;
}