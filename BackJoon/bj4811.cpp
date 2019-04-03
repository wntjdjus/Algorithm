 /*
백준 4811 알약
*/
#include<iostream>
using namespace std;

int main() {
	while (true) {
		int n;
		scanf("%d", &n);
		if (n == 0) break;
		long long** dp = new long long*[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = new long long[n + 1];
			for (int j = 0; j <= n; j++) dp[i][j] = 0;
		}
		dp[n][0] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - i; j >= 0; j--) {
				if (j != 0) dp[i][j] += dp[i + 1][j - 1];
				if (i + j + 1 <= n) dp[i][j] += dp[i][j + 1];
			}
		}
		printf("%lld\n", dp[0][1]);
	}

	return 0;
}