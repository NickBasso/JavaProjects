#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
	freopen("input.txt", "r", stdin);
	
	int x, y, a, b, n;
	
	cin >> n;
	
	for(int i = 0; i < n; i++){
		cin >> x >> y >> a >> b;
	
		y -= x;
		a += b;
		
		if(y % a)
			cout << "-1\n";
		else
			cout << y / a << "\n";
	}
	
	return 0;
}
