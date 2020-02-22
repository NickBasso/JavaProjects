#include <bits/stdc++.h>

using namespace std;

int main(){
    freopen("input.txt", "r", stdin);
    
    int q;
    
	cin>>q;
	
    while(q--){
        int N, M;
        
		cin>>N>>M;
        
        vector<int> t(N), l(N), r(N);
        
        for(int i = 0; i < N; i++) 
			cin >> t[i] >> l[i] >> r[i];
        
        bool ok = true;
        int canl = M, canr = M, nowt = 0;
        
        for(int i = 0; i < N; i++){
            int tol = max(canl - (t[i] - nowt), l[i]);
            int tor = min(canr + (t[i] - nowt), r[i]);
            
            if(tol > tor){
                ok = false;
                break;
            }
            
            canl = tol;
            canr = tor;
            nowt = t[i];
        }
        
        if(ok) 
			cout << "YES" << endl;
        else 
			cout << "NO" << endl;
    }
}



