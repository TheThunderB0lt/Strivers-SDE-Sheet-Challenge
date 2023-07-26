#include <bits/stdc++.h> 
vector<int> dijkstra(vector<vector<int>> &vec, int V, int edges, int S) {
    // Write your code here.

    unordered_map<int,list<pair<int,int>>>adj;
    for(int i= 0;i<edges;i++){
        int u = vec[i][0];
        int v = vec[i][1];
        int wt = vec[i][2];
        adj[u].push_back({v,wt});
        adj[v].push_back({u,wt});
    }
    vector<int>dist(V,INT_MAX);
    set<pair<int,int>>st;
    dist[S] = 0;
    st.insert({0,S});

    while(!st.empty()){
        auto it = *(st.begin());
        int NodeDist= it.first;
        int u = it.second;
        st.erase(it);

        for(auto i:adj[u]){
            int edgeWt = i.second;
            int adjNode = i.first;
            if(NodeDist+ edgeWt< dist[adjNode]){
                if(dist[adjNode] != INT_MAX)
                        st.erase({dist[adjNode], adjNode});
                    
                    dist[adjNode] = NodeDist+ edgeWt;
                    st.insert({dist[adjNode],adjNode});
            }
        }
    }
    return dist;
}