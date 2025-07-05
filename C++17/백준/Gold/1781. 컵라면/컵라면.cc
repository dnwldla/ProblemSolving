#include <bits/stdc++.h>
using namespace std;
int N,ret;
vector<pair<int,int>> v;
priority_queue<int,vector<int>,greater<int>> pq;
int main(){
    cin>>N;
    for (int i=0;i<N;i++){
        int d,c;
        cin>>d>>c;
        v.push_back({d,c});
    }
    sort(v.begin(),v.end());

    for (int i=0;i<N;i++){
        pq.push(v[i].second);

        if (pq.size()>v[i].first){
            pq.pop();
        }
    }

    while (!pq.empty()){
        ret+=pq.top();
        pq.pop();
    }
    cout<<ret;

}

