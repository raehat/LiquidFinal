#include <iostream> 
#include <complex>
#include <queue>
#include <set>
#include <unordered_set>
#include <list>
#include <chrono>
#include <random>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <string>
#include <vector>
#include <map>
#include <unordered_map>
#include <stack>
#include <iomanip>
#include <fstream>
 
using namespace std;
 
typedef long long ll;
typedef long double ld;
typedef pair<int,int> p32;
typedef pair<ll,ll> p64;
typedef pair<double,double> pdd;
typedef vector<ll> v64;
typedef vector<int> v32;
typedef vector<vector<int> > vv32;
typedef vector<vector<ll> > vv64;
typedef vector<vector<p64> > vvp64;
typedef vector<p64> vp64;
typedef vector<p32> vp32;
typedef map<int,int> mii;
typedef map<int,v32> miv;
ll MOD = 998244353;
double eps = 1e-12;
#define rep(i,e) for(ll i = 0; i < e; i++)
#define repFR(i,s,e) for(ll i = s; i < e; i++)
#define repR(i,s) for(ll i = s; i >= 0; i--)
#define repRR(i,s,e) for(ll i = s; i >= e; i--)
#define ln "\n"
#define dbg(x) cout<<#x<<" = "<<x<<ln
#define mp make_pair
#define pb push_back
#define ff first
#define ss second
#define INF 2e18
#define fast_cin() ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)
#define all(x) (x).begin(), (x).end()
#define sz(x) ((ll)(x).size())


int main()
{
    fast_cin();
    int t;
    cin>>t;
    rep(j,t) 
    {
        int n, d, c , m;
        string str;
        bool flag = true;
        cin>>n>>d>>c>>m;
        cin>>str;
        for (int i=0; i<n; i++)
        {
            if (str[i]=='D' && (d==0 || c==-1))
            {
                flag = false;
                break;
            }
            if (str[i]=='D')
            {
                d--;
                c+=m;
            }
            if (str[i]=='C')
            {
                c--;
            }
        }
        if (flag)
            cout<<"Case #"<<j+1<<": "<<"YES"<<ln;
        else
            cout<<"Case #"<<j+1<<": "<<"NO"<<ln;
    }
    return 0;
}