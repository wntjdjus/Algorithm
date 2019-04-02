/*
백준1786 찾기
- 라빈카프 알고리즘 
*/
#include<iostream>
#include<string>
#include<math.h>
#include<queue>
using namespace std;

long long MOD = 10000000007;

long long Mul(long long x, int m) {
	if (m == 0) return 1;
	long long result = 1;
	while (m != 1) {
		if (m % 2 != 0) result = (result*x) % MOD;
		x = (x*x) % MOD;
		m /= 2;
	}
	result = (result*x) % MOD;
	return result;
}

int main() {
	string t, p;
	getline(cin, t);
	getline(cin, p);
	int tLength = t.length(), pLength = p.length();
	//char t[1000001] = {}, p[1000001] = {};
	//cin.getline(t, 1000001);
	//cin.getline(p, 1000001);
	//int tLength = strlen(t);
	//int pLength = strlen(p);
	long long* arr = new long long[tLength + 1];
	long long P = 0;
	arr[0] = 0;
	int mul = 1;
	for (int i = pLength - 1; i >= 0; i--) {
		P += ((p[i])*mul);
		arr[0] += ((t[i])*mul);
		mul = (mul * 2) % MOD;
	}
	queue<int> q;
	int count = 0;
	for (int i = 0; i <= tLength - pLength; i++) {
		if (i != 0) {
			arr[i] = (2 * (arr[i - 1] - (t[i - 1] * Mul(2, pLength - 1))% MOD))% MOD + (t[i + pLength - 1]);
		}
		if (arr[i] == P) {
			bool flag = true;
			for (int j = 0; j < pLength; j++) {
				if (p[j] != t[i + j]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				count++;
				q.push(i+1);
			}
		}
	}
	/*printf("P:%lld\n", P);
	for (int i = 0; i <= tLength - pLength; i++) {
		printf("%lld ", arr[i]);
	}*/
	printf("%d\n", count);
	while (!q.empty()) {
		printf("%d ", q.front());
		q.pop();
	}

	return 0;
}