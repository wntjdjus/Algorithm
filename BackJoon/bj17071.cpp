// bj17071 ¼û¹Ù²ÀÁú5
#include<iostream>
#include<queue>
using namespace std;

typedef struct Node {
	int x;
	int time;
	int man;
	int dongs;
}Node;

int main() {
	int count = 0;
	int maxTime = 0;
	bool *chk = new bool[500001];
	for (int i = 0; i <= 500000; i++) chk[i] = false;
	int n, k, dong = 0;
	scanf("%d %d", &n, &k);
	queue<Node> q;
	Node node2 = { n,0,1,k };
	q.push(node2);
	dong = k;
	while (!q.empty()) {
		count++;
		Node temp = q.front();
		q.pop();
		int x = temp.x;
		int time = temp.time;
		/*if (time > maxTime) {
			for (int i = 0; i <= 500000; i++) chk[i] = false;
			maxTime = time;
		}*/
		//printf("%d\n", time);
		int man = temp.man;
		int dongs = temp.dongs;
		if (dongs > 500000) {
			printf("%d", -1);
			return 0;
		}
		if (man == 1) {
			if (x == dongs) {
				printf("%d %d", time,count);
				return 0;
			}
			else {
				if (x - 1 >= 0 && !chk[x - 1]) {
					chk[x - 1] = true;
					Node next = { x - 1,time + 1,1,dongs + (time + 1) };
					q.push(next);
				}
				if (x * 2 <= 500000 && !chk[x * 2]) {
					chk[x * 2] = true;
					Node next = { x * 2,time + 1,1,dongs+(time+1) };
					q.push(next);
				}
				if (x + 1 <= 500000&&!chk[x+1]) {
					chk[x + 1] = true;
					Node next = { x + 1,time + 1,1,dongs + (time + 1)};
					q.push(next);
				}
			}
		}
	}
	printf("%d", -1);
	return 0;
}