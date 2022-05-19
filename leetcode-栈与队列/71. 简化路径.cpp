#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

class Solution
{
public:
    string simplifyPath(string path)
    {
        stringstream ss(path);
        vector<string> strs;
        strs.reserve(20);
        string curr;
        while (getline(ss, curr, '/'))
        {
            if (curr != "." && curr != "")
            {
                if (curr != "..")
                {
                    strs.push_back(curr);
                }
                else if (!strs.empty())
                {
                    strs.pop_back();
                }
            }
        }

        if (!strs.empty())
        {
            string res = "";
            for (string str : strs)
            {
                res.append("/");
                res.append(str);
            }
            return res;
        }
        else
        {

            return "/";
        }
    }
};

int main() {
    Solution solution;
    string path;
    cin >> path;
    cout << solution.simplifyPath(path) << endl;
}