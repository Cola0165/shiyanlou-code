#include <iostream>
using namespace std;

int main(){
    int n,realmax,rmax,realmaxt,rmaxt=0;
    double r;
    bool flag=true;
    cin >> n;
    r=double(n)/2.718;
    int a[n];
    cin >> a[0];
    realmax=a[0];
    for(int i=1;i<n;i++){
        cin >> a[i];
        if(a[i]>realmax) realmax=a[i],realmaxt=i+1;
        if(flag==true){
            if(i==int(r)){
                rmax=realmax;
            }
            if(i>r+1 && realmax>rmax){
                rmax=realmax;
                rmaxt=realmaxt;
                flag=false;
            }
        }
    }
    cout << rmaxt << ' ' << realmaxt;
    return 0;
}