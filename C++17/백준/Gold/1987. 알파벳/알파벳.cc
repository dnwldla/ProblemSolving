#include <bits/stdc++.h>
using namespace std;

int R, C, result = 0;
char alp[21][21];
bool visited[26];  
int dx[4] = {0, 0, -1, 1}, dy[4] = {1, -1, 0, 0};

void go(int x, int y, int cnt) {
    result = max(result, cnt);

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];

        if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
        int nextChar = alp[nx][ny] - 'A';
        if (visited[nextChar]) continue;

        visited[nextChar] = true;
        go(nx, ny, cnt + 1);
        visited[nextChar] = false; 
    }
}

int main() {
    cin >> R >> C;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> alp[i][j];
        }
    }

    visited[alp[0][0] - 'A'] = true;
    go(0, 0, 1);
    cout << result << "\n";
}