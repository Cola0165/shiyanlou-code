#include <iostream>
#include <stack>
using namespace std;

int longestValidParentheses(string s)
    {
        stack<int> stk;
        int invalid = -1;
        int len = 0, max_len = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s[i] == '(')
            {
                stk.push(i);
            }
            else
            {
                if (stk.empty())
                {
                    invalid = i;
                }
                else
                {
                    stk.pop();
                    if (stk.empty())
                    {
                        max_len = max(i - invalid, max_len);
                    }
                    else
                    {
                        max_len = max(i - stk.top(), max_len);
                    }
                }
            }
        }
        return max_len;
    }

int main() {
    string str;
    cin >> str;
    cout << longestValidParentheses(str) << endl;
}

// int longestValidParentheses(string s)
//     {
//         stack<int> left;
//         left.push(-1);
//         int size = 0, maxSize = 0;
//         for (int i = 0; i < s.size(); i++)
//         {
//             if (s[i] == '(')
//                 left.push(i);
//             else
//             {
//                 if (left.size() != 1)
//                 {
//                     left.pop();
//                     size = i - left.top();
//                     maxSize = max(maxSize, size);
//                 }
//                 else
//                 {
//                     left.pop();
//                     left.push(i);
//                 }
//             }
//         }
//         maxSize = max(maxSize, size);
//         return maxSize;
//     }