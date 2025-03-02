#include <bits/stdc++.h>
using namespace std;
int N;
pair<int,int> ar[100001];
stack<pair<int,int>> stk;
int main(){
    cin>>N;
    for (int i=0;i<N;i++){
        cin>>ar[i].first>>ar[i].second;
    }

    sort(ar,ar+N,greater<pair<int,int>>());

    for (int i=0;i<N;i++){
        if (stk.empty()){
            stk.push({ar[i].first,ar[i].second});
        }
        else{
            pair<int,int> bf=stk.top();
            pair<int,int> cur=ar[i];

            if (cur.second<=bf.first){
                stk.push({cur.first,cur.second});
            }
        }

    }

    cout<<stk.size()<<"\n";
}