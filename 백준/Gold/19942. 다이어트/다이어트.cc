#include<bits/stdc++.h>
using namespace std;
int n, mp, mf, ms, mv;
const int INF = 987654321;
int b, c, d, e, ret = INF, sum;
map<int, vector<vector<int>>> ret_v;
struct A {
	int mp, mf, ms, mv, cost;
}a[16];

int main()
{
	cin >> n;
	cin >> mp >> mf >> ms >> mv;
	for (int i = 0; i < n; i++) {
		cin >> a[i].mp >> a[i].mf >> a[i].ms >> a[i].mv >> a[i].cost;
	}

	
	for (int i = 1; i < (1 << n); i++) { //001부터 111까지
		b = c = d = e = sum = 0;
		vector<int> v; //식재료번호
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				v.push_back(j+1); 
				b += a[j].mp;
				c += a[j].mf;
				d += a[j].ms;
				e += a[j].mv;
				sum += a[j].cost;
			}
		}
		if (b >= mp && c >= mf && d >= ms && e >= mv) {
			if (ret >= sum) {
				ret = sum;
				ret_v[ret].push_back(v);
			}
		}
	}

	if (ret == INF) cout << -1<<"\n";
	else {
		sort(ret_v[ret].begin(), ret_v[ret].end());
		cout << ret << "\n";
		for (auto a : ret_v[ret][0]) {
			cout << a << " ";
		}
	}

	
}
