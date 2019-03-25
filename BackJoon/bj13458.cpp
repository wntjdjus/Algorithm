#include<iostream>
using namespace std;

int main() {
	long long n,b,c,result=0;
	scanf("%lld", &n);
	long long* arr = new long long[n];
	long long* count = new long long[n];
	for (int i = 0; i < n; i++) {
		scanf("%lld", &arr[i]);
		count[i] = 0;
	}
	scanf("%lld %lld", &b, &c);
	for (int i = 0; i < n; i++) {
		count[i]++;
		arr[i] -= b;
		if (arr[i] <= 0) {
			result += count[i];
			continue;
		}
		count[i] += (arr[i] / c);
		if (arr[i] % c != 0) count[i]++;
		result += count[i];
	}
	printf("%lld", result);

	return 0;
}