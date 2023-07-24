vector<int> MinimumCoins(int amount)
{
    // Write your code here
    vector<int> coins = {1,2,5,10,20,50,100,500,1000} ;
    vector<int>ans;
    for(int i = 8 ; i >= 0 ; i--){
        while(amount>=coins[i]){
            amount-=coins[i] ;
            ans.push_back(coins[i]);
        }
    }
    return ans ;
}