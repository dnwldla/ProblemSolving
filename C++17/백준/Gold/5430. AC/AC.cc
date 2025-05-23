#include<bits/stdc++.h>
using namespace std; 

int T,n;
string p;

int main(){
    cin>>T;

    for (int i=0;i<T;i++){
        string strAr;
        cin>>p>>n>>strAr;
        int x=0;
        deque<int> D;

        //문자열 처리
        for (char c:strAr){
            if (c=='['||c==']') continue;
            if (c>='0' && c<='9') x=x*10+c-'0';
            
            else{
                if (x>0) D.push_back(x);
                x=0;
            }
        }
        if (x>0) D.push_back(x);
        bool rev=false,error=false;

        for (auto a:p){
            if (a=='R'){
                rev=!rev;
            }else{
                if (D.empty()){
                    error=true;
                    break;
                }else{
                    if (rev) D.pop_back();
                    else D.pop_front();
                }
            }
        }

        if (error){
            cout<<"error"<<"\n";
        }else{
             if (rev) reverse(D.begin(),D.end());

             cout<<"[";
             for (int i=0;i<D.size();i++){
                cout<<D[i];
                if (i<D.size()-1) cout<<",";
             }
             cout<<"]\n";
        }
        
        

    }
}