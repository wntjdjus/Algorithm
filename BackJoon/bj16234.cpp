#include<iostream>
#include<queue>
#include<math.h>
using namespace std;

int dx[4] = { 0,1,0,-1 };
int dy[4] = { -1,0,1,0 };

typedef struct Node {
	int y;
	int x;
}Node;

int main() {
	int n, l, r, move = 0;
	scanf("%d %d %d", &n, &l, &r);
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
	while (true) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chk[i][j] = false;
			}
		}
		bool flag = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				//printf("-------\n");
				if (chk[i][j]) continue;
				queue<Node> q;
				queue<Node> nation;
				int sum = 0, num = 0;
				chk[i][j] = true;
				q.push({ i,j });
				while (!q.empty()) {
					Node node = q.front();
					q.pop();
					nation.push(node);
					num++;
					sum += arr[node.y][node.x];
					for (int d = 0; d < 4; d++) {
						int ty = node.y + dy[d];
						int tx = node.x + dx[d];
						if (ty < 0 || ty >= n || tx < 0 || tx >= n) continue;
						if (chk[ty][tx]) continue;
						int ingu = abs(arr[node.y][node.x] - arr[ty][tx]);
						if (ingu<l || ingu>r) continue;
						//printf("%d %d %d\n", arr[node.y][node.x], arr[ty][tx], ingu);
						chk[ty][tx] = true;
						q.push({ ty,tx });
					}
				}
				if (num > 1) flag = true;
				sum /= num;
				while (!nation.empty()) {
					Node node = nation.front();
					//printf("%d %d\n", node.y, node.x);	
					nation.pop();
					arr[node.y][node.x] = sum;
				}
			}
		}
		/*for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				printf("%d ", arr[i][j]);
			}
			printf("\n");
		}
		printf("\n");*/
		if (flag) move++;
		else break;
	}
	printf("%d\n", move);

	return 0;
}