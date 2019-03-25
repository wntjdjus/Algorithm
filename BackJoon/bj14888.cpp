// 백준 14888번 연산자 끼워넣기

#include<iostream>
using namespace std;

int* go(int* arr, int* op, int n, int sum, int index) {
	if (index == n - 1) {
		int* r = new int[2];
		r[0] = sum;
		r[1] = sum;
		return r;
	}
	int min = 1000000000;
	int max = -1000000000;
	for (int i = 0; i < 4; i++) {
		if (op[i] == 0) continue;
		op[i]--;
		int* temp = new int[2];
		if (i == 0) temp = go(arr, op, n, sum + arr[index + 1], index + 1);
		else if (i == 1) temp = go(arr, op, n, sum - arr[index + 1], index + 1);
		else if (i == 2) temp = go(arr, op, n, sum*arr[index + 1], index + 1);
		else {
			if (sum > 0) {
				temp = go(arr, op, n, sum / arr[index + 1], index + 1);
			}
			else if (sum == 0) {
				temp = go(arr, op, n, sum, index + 1);
			}
			else {
				int tsum = (-1)*sum;
				tsum /= arr[index + 1];
				tsum = (-1)*tsum;
				temp = go(arr, op, n, tsum, index + 1);
			}
		}
		min = min < temp[0] ? min : temp[0];
		max = max > temp[1] ? max : temp[1];
		op[i]++;
	}
	int* result = new int[2];
	result[0] = min;
	result[1] = max;
	return result;
}

int main() {
	int n;
	scanf("%d", &n);
	int* arr = new int[n];
	int op[4] = { 0,0,0,0 };
	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);
	for (int i = 0; i < 4; i++) scanf("%d", &op[i]);
	int *result = new int[2];
	result = go(arr, op, n, arr[0], 0);
	printf("%d\n%d", result[1], result[0]);

	return 0;
}