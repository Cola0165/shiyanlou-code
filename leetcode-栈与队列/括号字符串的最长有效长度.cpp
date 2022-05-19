#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int longestValidParentheses(string s)
    {
        queue<pair<int, int>> q;
        bool *valid = new bool[s.length() + 1];
        int imax = -1;
        memset(valid, 0, sizeof(bool) * (s.length() + 1));
        for (int i = 0; i < int(s.length()) - 1; i++)
        {
            if (s[i] == '(' && s[i + 1] == ')')
            {
                valid[i] = true;
                valid[i + 1] = true;
                q.push(make_pair(i, i + 1));
            }
        }
        while (!q.empty())
        {
            pair<int, int> parentheses;
            parentheses = q.front();
            q.pop();
            int l = parentheses.first, r = parentheses.second;
            while (l >= 0 && valid[l])
                l--;
            while (r < s.length() && valid[r])
                r++;
            if (!valid[l] && !valid[r])
            {
                if (s[l] == '(' && s[r] == ')')
                {
                    valid[l] = true;
                    valid[r] = true;
                    q.push(make_pair(l, r));
                }
                else
                {
                    l = l + 1;
                    r = r - 1;
                }
            }
            if (r - l > imax)
                imax = r - l;
        }
        return imax + 1;
    }

int main() {
    string str;
    cin >> str;
    cout << longestValidParentheses(str) << endl;
}