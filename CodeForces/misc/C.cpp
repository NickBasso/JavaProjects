#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	freopen("input.txt", "r", stdin);
	
	int i, j, q, n, m, temp[102][2], time[102], cTemp;
	
	cin >> q;
	
	for(i = 0; i < q; i++){		
		cin >> n >> m;
		
		time[0] = 0;
		cTemp = temp[0][0] = temp[0][1] = m; 
		
		for(j = 1; j <= n; j++)
			cin >> time[j] >> temp[j][0] >> temp[j][1];
		
		for(j = 0; j <= n - 2; j++){
			if(time[j + 1] - time[j] >= abs(temp[j + 1][0] - cTemp)){
				if(temp[j + 2][0] >= temp[j + 1][1]){
					if(temp[j + 1][0] >= cTemp){
						if(temp[j + 1][1] - cTemp >= time[j + 1] - time[j]){
							cTemp += time[j + 1] - time[j];
						}
						else{
							cTemp += temp[j + 1][1] - cTemp;
						}	
					}
					else if(temp[j + 1][0] < cTemp){
						cTemp -= cTemp - temp[j + 1][1];	
					}	
				}
				else if(temp[j + 2][0] < temp[j + 1][1]){
					if(cTemp >= temp[j + 1][0]){
						if(time[j + 1] - time[j] >= cTemp - temp[j + 1][0]){
							cTemp -= cTemp - temp[j + 1][0];
						}	
						else{
							cTemp -= time[j + 1] - time[j];
						}
					}
					else if(cTemp < temp[j + 1][0]){
						cTemp += temp[j + 1][0] - cTemp;
					}
				}
			}
		}
		
		if((time[j + 1] - time[j] >= abs(cTemp - temp[j + 1][0])) || (time[j + 1] - time[j] >= abs(cTemp - temp[j + 1][1])))
			j++;
		
		if(j == n)
			cout << "YES\n";
		else
			cout << "NO\n";
		
	}
	
	return 0;
}
