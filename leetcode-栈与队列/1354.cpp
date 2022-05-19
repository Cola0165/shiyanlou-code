#include <iostream>
#include <stack>
#include <map>
using namespace std;

bool isValid(string s)
    {
        if (s.length() == 0)
        {
            return true;
        }
        if (s.length() % 2 != 0)
        {
            return false;
        }
        stack<char> st;
        for (auto item : s)
        {
            if (item == '(' || item == '[' || item == '{')
                st.push(item);
            if (st.empty())
                return false;
            if (item == ')')
            {
                if (st.top() == '(')
                {
                    st.pop();
                }
                else
                    return false;
            }
            else if (item == ']')
            {
                if (st.top() == '[')
                {
                    st.pop();
                }
                else
                    return false;
            }
            else if (item == '}')
            {
                if (st.top() == '{')
                {
                    st.pop();
                }
                else
                    return false;
            }
        }
        return st.empty();
    }

int main() {
    string str;
    cin >> str;
    cout << (isValid(str)?"OK":"Wrong") << endl;
}

// bool isValid(string s)
//     {
//         stack<char> data;
//         map<char, char> match = {{'{', '}'}, {'[', ']'}, {'(', ')'}};
//         for (auto &i : s)
//         {
//             if (i == '(' || i == '[' || i == '{')
//             {
//                 /* code */
//                 data.push(i);
//             }
//             else
//             {
//                 if (data.empty())
//                     return false;
//                 char top = data.top();
//                 data.pop();
//                 if (match[top] != i)
//                     return false;
//             }
//         }
//         return data.size() == 0;
//     }

// bool isValid(string s)
//     {
//         if (s.size() % 2 != 0)
//             return false;
//         if (s.size() == 0)
//             return true;

//         string temp;
//         temp.push_back(s[0]);
//         for (int i = 1; i < s.size(); ++i)
//         {
//             int k = temp.size() - 1;
//             if (temp[k] == '(' && s[i] == ')')
//                 temp.pop_back();
//             else if (temp[k] == '[' && s[i] == ']')
//                 temp.pop_back();
//             else if (temp[k] == '{' && s[i] == '}')
//                 temp.pop_back();
//             else
//                 temp.push_back(s[i]);
//         }
//         return temp.size() == 0;
//     }