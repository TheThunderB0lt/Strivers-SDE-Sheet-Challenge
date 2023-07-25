#include <bits/stdc++.h> 

int atoi(string str) {

    // Write your code here.

     string  ans ="";

     int count=0;

     for(int i=0;i<str.size();i++)

     {

          if(str[i]>='0'  &&  str[i]<='9')

          {

              ans+=str[i];

          }

           

           else if(str[i]=='-')

           {

               count++;

           }

     }

     int res = stoi(ans);

     if(count==1)

     {

         return -res;

     }

     else

     return res;

}