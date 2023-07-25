#include <bits/stdc++.h> 

vector<int> kMaxSumCombination(vector<int> &A, vector<int> &B, int n, int k){

      sort(A.begin(), A.end());

      vector<int> v;

      priority_queue<int, vector<int>, greater<int> > pq;

      for(int i=n-1; i>=0; i--){

          for(int j=n-1; j>=0; j--){

             pq.push(A[i] + B[j]);

             if(pq.size() > k){

                 pq.pop();

             }      

          }

      }

      while(!pq.empty()){

          v.push_back(pq.top());

          pq.pop();

      }

      reverse(v.begin(), v.end());

      return v;

}