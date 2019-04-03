/*
백준1786 찾기
- 라빈카프 알고리즘 
*/
#include<iostream>
#include<string>
#include<math.h>
#include<queue>
#include<cstdio>
#include<cstring>
using namespace std;

long long MOD = 100000000007;

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
long long mod(long long x) {
	if (x >= 0) return x % MOD;
	return ((-x / MOD + 1)*MOD + x) % MOD;
}

int main() {
	int sosu = 7;
	string t, p;
	getline(cin, t);
	getline(cin, p);
	int tLength = t.size(), pLength = p.size();
	if (tLength < pLength) {
		printf("0\n");
		return 0;
	}
	long long* arr = new long long[tLength + 1];
	//long pattern = 0L;
	long long P = 0;
	arr[0] = 0;
	long long mul = 1;
	for (int i = pLength - 1; i >= 0; i--) {
		P = mod(P+mod((p[i]-31)*mul));
		arr[0] = mod(arr[0]+mod((t[i]-31)*mul));
		mul = mod(mul * sosu);
	}
	queue<int> q;
	int count = 0;
	long long mmul = Mul(sosu, pLength - 1);
	for (int i = 0; i <= tLength - pLength; i++) {
		if (i != 0) {
			long long temp = mod(arr[i - 1] - ((t[i - 1]-31) * mmul));
			//printf("%lld\n", temp);
			//temp = temp < 0 ? (-1)*temp : temp;
			arr[i] = mod(temp*sosu + (t[i + pLength - 1]-31));
			//if (arr[i] < 0) arr[i] *= (-1);
		}
		if (arr[i] == P) {
			count++;
			q.push(i+1);
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