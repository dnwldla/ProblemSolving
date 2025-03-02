#include <bits/stdc++.h>
using namespace std;
const int max_n = 500000; 
int a, b, ok, turn = 1;
bool visited[2][max_n+4];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> a >> b;
    if(a == b){cout << 0 << "\n"; return 0;}
    
    queue<int> q;
    visited[0][a]=true;
    q.push(a);

    while (!q.empty()){
        b+=turn;
        if (b>max_n) break;
        if (visited[turn%2][b]){
            ok=true;
            break;
        }
        int qSize=q.size();
        for (int i=0;i<qSize;i++){
            int x=q.front();q.pop();
            for (int nx:{x+1,x-1,x*2}){
                //visited[turn%2][nx] 는 수빈이가 이미 방문한 지점이라는 의미이다
                if (nx<0 || nx>max_n || visited[turn%2][nx]) continue;
                visited[turn%2][nx]=true;

                if (nx==b){
                    ok=1;
                    break;
                }
                q.push(nx);
            }
            if (ok) break;
        }
        if (ok) break;
        turn++;
    }
    if (ok) cout<<turn<<"\n";
    else cout<<-1<<"\n";
    return 0;
}
