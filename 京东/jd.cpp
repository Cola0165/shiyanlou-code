#include<iostream>
using namespace std;
int main()
{
    int i, a, b, c, d, f[4];
    for(i = 0; i < 4; i++) cin >> f[i];
    a = f[0] + f[1] + f[2] + f[3];
    a = a / f[0];
    b = f[0] + f[2] + f[3];
    b = b / a;
    c = (b * f[1] + a) / f[2];
    d = f[(b / c) % 4];
    if(f[(a + b + c + d) % 4] > f[2])
        cout << a + b << endl;
    else
        cout << c + d << endl;
    return 0;
}