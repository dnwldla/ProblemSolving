#include <bits/stdc++.h>
using namespace std;
int N,p,del,parent;
vector<int> ar[51];
bool visited[51];
int go(int cur,int prev){
    int ret=0;
    if (ar[cur].size()==0 && cur==del && ar[prev].size()==1) return 1;
    if (cur==del) return 0;
    if (ar[cur].size()==0) return 1;

    for (auto child:ar[cur]){
        if (visited[child]) continue;
        visited[child]=true;
        ret+=go(child,cur);
    }
    return ret;
}



int main(){
    cin>>N;
    for (int i=0;i<N;i++){
        cin>>p;
        if (p==-1){
            parent=i;
            continue;
        }
        ar[p].push_back(i);
    }
    cin>>del;

    visited[parent]=true;
    int ret=go(parent,0);
    cout<<ret;

}