// 7785번 회사에 있는 사람
#include<iostream>
#include<string>
#include<sstream>
#include<vector>
using namespace std;

int main() {
	int n;
	cin >> n;
	for (int i = 0; i <= n; i++) {
		string str,w;
		vector<string> word;
		getline(cin, str);
		for (stringstream sts(str); (sts >> w);) {
			word.push_back(w);
		}
		string name = word[0];
		//word.pop_back();
		string command = word[1];
		//word.pop_back();
		cout << name << "\n" << command << "\n";
		/*for (vector<string>::iterator it = word.begin(); it != word.end(); ++it) {
			cout << *it << "\n";
		}*/
	}

	return 0;
}