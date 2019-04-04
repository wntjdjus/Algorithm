/*
백준1786 찾기
- 라빈카프 알고리즘 
*/
#include<iostream>
#include<string>
#include<vector>
using namespace std;

#define sosu 1000000009L
#define X 13

long long mod(long long x) {
	if (x < 0) return ((-x / sosu + 1)*sosu + x) % sosu;
	return x % sosu;
}

int main() {
	string t, p;
	vector<int> v;
	getline(cin, t);
	getline(cin, p);
	int tlength = t.length(), plength = p.length();
	long long T = 0, P = 0;
	long long mul = 1;
	for (int i = 0; i <= tlength - plength; i++) {
		if (i == 0) {
			for (int j = plength - 1; j >= 0; --j) {
				T = mod(T + mod(t[j] * mul));
				P = mod(P + mod(p[j] * mul));
				if(j>0) mul = mod(mul*X);
			}
		}
		else {
			T = mod(mod(X*(T - mod(t[i - 1] * mul))) + t[i + plength - 1]);
		}
		if (T == P) {
			v.push_back(i + 1);
		}
		//printf("%lld %lld %lld\n", mul, T, P);
	}
	int size = v.size();
	printf("%d\n", size);
	for (int i = 0; i < size; i++) {
		printf("%d ", v[i]);
	}

	return 0;
}