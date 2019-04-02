/*
백준 17071번 숨바꼭질5
시간 최대 1000초?
*/
#include<iostream>
#include<queue>
using namespace std;

typedef struct Node {
	int x;
	int time;
}Node;

int main() {
	int n, k;
	scanf("%d %d", &n, &k);
	if (n == k) {
		printf("0\n");
		return 0;
	}
	int* dong = new int[500001];
	bool** subin = new bool*[500001];
	for (int i = 0; i <= 500000; i++) subin[i] = new bool[2];
	queue<Node> q;
	for (int i = 0; i <= 500000; i++) {
		dong[i] = -1;
		for (int j = 0; j < 2; j++) subin[i][j] = false;
	}
	for (int time = 0, dis = k; dis <= 500000; time += 1, dis += time) {
		//printf("%d %d\n", time, dis);
		dong[dis] = time;
	}
	/*for (int i = 0; i <= 500000; i++) {
		printf("%d\n", dong[i]);
	}*/
	Node start = { n,0 };
	q.push(start);
	subin[n][0] = true;
	//int min = 500000;
	//int cnt = 0;
	while (!q.empty()) {
		Node node = q.front();
		q.pop();
		//printf("%d %d\n", node.x, node.time);
		int x = node.x;
		int time = node.time;
		if (dong[x] != -1 && dong[x]>=time && subin[x][dong[x]%2] == true) {
			//printf("%d %d ",x,dong[x]);
			printf("%d\n", dong[x]);
			return 0;
			//min = min < dong[x] ? min : dong[x];
			//cnt++;
			//if (cnt == 2) break;
		}
		if (x - 1 >= 0 && subin[x - 1][(time+1)%2] == false) {
			subin[x - 1][(time+1)%2] = true;
			Node next = { x - 1,time + 1 };
			q.push(next);
		}
		if (x + 1 <= 500000 && subin[x + 1][(time + 1) % 2] == false) {
			subin[x + 1][(time + 1) % 2] = true;
			Node next = { x + 1,time + 1 };
			q.push(next);
		}
		if (x * 2 <= 500000 && subin[x * 2][(time + 1) % 2] == false) {
			subin[x * 2][(time + 1) % 2] = true;
			Node next = { x * 2,time + 1 };
			q.push(next);
		}
	}
	//if (min != 500000) printf("%d\n", min);
	printf("-1\n");

	return 0;
}