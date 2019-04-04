// 7785번 회사에 있는 사람
#include<iostream>
#include<string>
#include<sstream>
#include<vector>
using namespace std;

#define sosu 13
#define MAX_SIZE 131071

typedef struct Node {
	string value;
	Node* next = nullptr;
	Node* prev = nullptr;
}Node;
typedef struct List {
	Node* head;
	int list_size = 0;
	bool isEmpty() {
		if (list_size==0) return true;
		return false;
	}
	int size() {
		return list_size;
	}
	void add(string str) {
		if (isEmpty()) {
			head = new Node();
			head->value = str;
			head->next = nullptr;
			head->prev = nullptr;
		}
		else {
			Node* node = new Node();
			node->value = str;
			Node* ptr = head;
			while (ptr->next != NULL) ptr = ptr->next;
			ptr->next = node;
			node->prev = ptr;
		}
		++list_size;
	}
	bool search(string str) {
		Node* ptr = head;
		while (ptr != nullptr&&ptr->value.compare(str)!=0) {
			ptr = ptr->next;
		}
		if (ptr == nullptr) return false;
		else return true;
	}
	void remove(string str) {
		if (isEmpty()) return;
		if (!search(str)) return;
		Node* ptr = head;
		while (ptr->value.compare(str)!=0) {
			ptr = ptr->next;
		}
		if (ptr->prev != nullptr) ptr->prev->next = ptr->next;
		else head = ptr->next;
		if (ptr->next != nullptr) ptr->next->prev = ptr->prev;
		delete ptr;
		list_size -= 1;
		if (list_size == 0) delete head;
	}
	void toString() {
		Node* ptr = head;
		while (ptr != nullptr) {
			cout << ptr->value << "\n";
			ptr = ptr->next;
		}
	}
};
typedef struct HashMap {
	List** listArray = new List*[MAX_SIZE];
	int hash = 0;
	void init() {
		for (int i = 0; i < MAX_SIZE; i++) listArray[i] = new List();
	}
	int H(string key) {
		int h = hash;
		if(h==0)
	}
};

int main() {
	/*int n;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		string name, command;
		cin >> name >> command;
	}*/
	List* list = new List();
	list->add("AAAAA");
	list->add("AAAAB");
	list->add("AAAAA");
	list->toString();
	list->remove("c");
	list->toString();
	if (list->search("AAAAA")) printf("찾음\n");

	return 0;
}