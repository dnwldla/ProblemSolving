#include <bits/stdc++.h>
#define MAX_N 1001
using namespace std;
map<string,int> map1,ret;
map<int,string> map2;
int visited[MAX_N][MAX_N];
int N,M;
vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    N=id_list.size();
    vector<int> answer(N, 0); 
    M=report.size();
    for (int i=0;i<N;i++){
        map1[id_list[i]]=i;
        map2[i]=id_list[i];
    }
    
    for (string r:report){
        int idx=r.find(" ");
        string from=r.substr(0,idx);
        string to=r.substr(idx+1);
        
        //이미 신고했다면
        if (visited[map1[from]][map1[to]]) continue;
        
        visited[map1[from]][map1[to]]=true;
        
        //신고횟수
        ret[to]+=1;
    }
    
    for (int i=0;i<N;i++){
        for (int j=0;j<N;j++){
            if (i==j) continue;
            
            //if 신고했다면
            if (visited[i][j]){
               
                if (ret[map2[j]]>=k) answer[i]++;
            }
        }
    }
    
    
    return answer;
}