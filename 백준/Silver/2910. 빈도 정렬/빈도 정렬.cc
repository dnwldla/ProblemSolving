#include <bits/stdc++.h>
using namespace std;
int n, c,a[1004];
map<int, int>mp, mp_first;
vector<pair<int, int>> v;

bool cmp(pair<int, int> v1, pair<int, int>v2) {
	//등장횟수가 같다면 먼저 나온 것이 앞에 있다
	if (v1.second == v2.second) {
		return mp_first[v1.first] < mp_first[v2.first];
	}
	//많이 등장한게 앞에 있다
	return v1.second > v2.second;
}

int main()
{
   //map을 sort해야 한다
	cin >> n >> c;

	for (int i = 0; i < n; i++) {
		cin >> a[i]; mp[a[i]]++;
		if (mp_first[a[i]] == 0) mp_first[a[i]] = i + 1;
	}
	//first는 숫자, second는 개수
	for (auto it : mp) {
		v.push_back({ it.first,it.second });
	}

	sort(v.begin(), v.end(), cmp);
	
	for (auto i : v) {
		for (int j = 0; j < i.second; j++) {
			cout << i.first << " ";
		}
	}

}

