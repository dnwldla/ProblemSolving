#include <bits/stdc++.h>

using namespace std;
static int n,ret,win;
vector<int> cmp_a,cmp_b,tmp_sum,answer;
vector<vector<int>> dices;
bool visited[10];
void getSum(int idx,vector<int> charIdx,char state){
    if (idx==n/2){
        int tot=0;
        for (int i=0;i<tmp_sum.size();i++){
            tot+=tmp_sum[i];
        }
        if (state=='a') cmp_a.push_back(tot); 
        else cmp_b.push_back(tot);
        return;
    }
    for (int i=0;i<6;i++){
        tmp_sum.push_back(dices[charIdx[idx]][i]); //tmp_sum: 재귀로 (1), (1,3)
        getSum(idx+1,charIdx,state); 
        tmp_sum.pop_back();
    }
   
}

int binarySearch(){
    int ret=0;
    //cmp_a,cmp_b
    for (int i=0;i<cmp_a.size();i++){
        int a=cmp_a[i];
        
        int lo=0; int hi=cmp_b.size()-1;
        int mid;
        while (lo<=hi){
            mid=(lo+hi)/2;
            if (a<=cmp_b[mid]) hi=mid-1;
            else lo=mid+1;
        }
       
        ret+=(hi+1);
    }
 
   return ret;
}
void findCase(int start,int cnt){
    if (cnt==n/2){
        vector<int> aIdx,bIdx; //(0,1)->dice[0],dice[1] 접근 
        for (int i=0;i<n;i++){
            if (visited[i]) aIdx.push_back(i);
            else bIdx.push_back(i);
        }
        getSum(0,aIdx,'a');
        getSum(0,bIdx,'b');
        sort(cmp_a.begin(),cmp_a.end());
        sort(cmp_b.begin(),cmp_b.end());
        int ret=binarySearch();
      
        if (ret>win){ //win: 616 , ret: 596, 560.. 
            win=ret;
            answer=aIdx;
        }
      
        while (cmp_a.size()) cmp_a.pop_back(); //cmp_a-> 합:(4,4,4,...10,10)
        while (cmp_b.size()) cmp_b.pop_back();
        
         return;
    }
    
    for (int i=start;i<n;i++){
            visited[i]=true;
            findCase(i+1,cnt+1);
            visited[i]=false;
    }
}

vector<int> solution(vector<vector<int>> dice) {
    dices=dice;
 
    n=dice.size();
    
    findCase(0,0);
    for (int i=0;i<answer.size();i++) answer[i]+=1;
    return answer;
}