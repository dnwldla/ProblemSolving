#include<bits/stdc++.h>
#define maxn 200005
typedef long long ll;
using namespace std;
const int INF = 987654321;
const int dy[] = { -1, 0, 1, 0 };
const int dx[] = { 0, 1, 0, -1 };
int n, a[44], ret = INF;
string s;

void go(int here) {
	if (here == n + 1) {
		int sum = 0;
		for (int i = 0; i < n;i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (a[j] & (1<<i)) cnt++;
			}
			sum += min(cnt, n - cnt);
		}
		ret = min(sum, ret);
		return;
	}
	go(here + 1);
	a[here] = ~a[here]; //행 뒤집기
	go(here + 1);
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> n;

	for (int i = 1; i <= n; i++) {
		int value = 1;
		cin >> s;
		for (int j = s.length()-1; j >=0; j--) {
			if (s[j] == 'T') a[i] = a[i] | value;
			value *= 2;
		}
	}
	go(1);
	cout << ret;
	return 0;
}