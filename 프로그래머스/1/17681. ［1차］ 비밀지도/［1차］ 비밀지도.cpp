#include<bits/stdc++.h>
using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;
    //벽은 1, 공백은 0
    for (int i=0;i<n;i++){
        int num=arr1[i]|arr2[i];
        string s="";
        while (s.length()!=n){
            if (num%2==0) s+=" ";
            else s+="#";
            num/=2;
        }
        reverse(s.begin(),s.end());
        answer.push_back(s);
    }
    return answer;
}