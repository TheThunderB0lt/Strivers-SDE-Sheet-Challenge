int maximumMeetings(vector<int> &start, vector<int> &end)
{
    // Write your code here.
     vector<pair<int,int>> ans;

   for(int i=0; i<start.size(); i++)

   {

       ans.push_back({end[i],start[i]});

   }

   sort(ans.begin(), ans.end());

 

   int  c=1;

   int end_time=ans[0].first;

 

   for(int i=1; i<ans.size(); i++)

   {

       if(end_time<ans[i].second)

       {

           c++;

           end_time=max(end_time,ans[i].first);

       }

   }

   return c;
}