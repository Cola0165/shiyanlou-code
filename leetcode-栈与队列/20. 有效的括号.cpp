#include <iostream>
#include <stack>
#include <map>
using namespace std;

bool isValid(string s)
    {
        stack<char> data;
        map<char, char> match = {{'{', '}'}, {'[', ']'}, {'(', ')'}};
        for (auto &i : s)
        {
            if (i == '(' || i == '[' || i == '{')
            {
                /* code */
                data.push(i);
            }
            else
            {
                if (data.empty())
                    return false;
                char top = data.top();
                data.pop();
                if (match[top] != i)
                    return false;
            }
        }
        return data.size() == 0;
    }

int main() {
    string str;
    cin >> str;
    cout << (isValid(str)?"YES":"NO") << endl;
}