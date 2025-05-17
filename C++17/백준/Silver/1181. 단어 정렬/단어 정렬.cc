#include<bits/stdc++.h>
using namespace std;
int N;
set<string> word;
vector<string> v;

bool cmp(string a, string b) {
	if (a.length() == b.length()) {
		return a < b;
	}
	return a.length() < b.length();
}

int main()
{
	cin >> N;
	for (int i = 0; i < N; i++) {
		string k;
		cin >> k;
		word.insert(k);
	}

	for (auto it : word) {
		v.push_back(it);
	}

	sort(v.begin(), v.end(), cmp);

	for (auto it : v) {
		cout << it << "\n";
	}
	
}


