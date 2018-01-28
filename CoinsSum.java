
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilanashay


*/
public class CoinsSum {
    
    // Array of all the coins to hold their values  
    int arrCoins[]={200,100,50,20,10,5,2,1};
    int numOfCoins = arrCoins.length;
    
/**
 * CoinsSum constructor
 * 
 * : https://projecteuler.net/problem=31

 * : Coin sums
 * : Problem 31 
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:

 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
*/
    public CoinsSum(){
    }
/**
 * 
 * 
 * @param idx use different amount of coins from arrCoins[idx]
 * @param sum generate sum by coins
 * @param dp array to hold previous calculation. dp - dynamic programming
 * @return different ways to create sum with coins from arrCoins[idx]
 * If sum is 0, return 1. If idx is above the array size, just return 0. 
 * If not, calculate how many times the idx coin can be used to generate sum
 */
    
    private int getDiffWays( int idx, int sum, int[][] dp){
       if (sum==0) {
           return 1;
       }else if (idx >= numOfCoins){
           return 0;
       }
       if (idx >= numOfCoins){ return 0;}
       
       if (dp[idx][sum]!=-1){return dp[idx][sum];}
       // Try to use coins arrCoins[idx] as much as possible, 
       // or don't use them at all when i is 0
       int sumWays = 0;
       for (int i=0; sum-i*arrCoins[idx]>=0; i++){
            // how many times we will use the current coin
           sumWays += getDiffWays ( idx+1, sum-i*arrCoins[idx], dp);
       }
       dp[idx][sum] = sumWays;
       return sumWays;
    }
    
/**
 * 
 * recursive function to generate sum 
 * @param sum amount of money that needs to create with the coins
 * @return number of ways to calculate sum with certain amount of coins
 * @throws Exception when the sum is negative number
 */
    public int getDiffWaysGenerateSum (int sum) throws Exception{
        
        // Check error case when the amount is invalid
        if (sum<0){ throw new Exception("cannot produce less than 0 money");}
        
        
        // dp to hold previous calculations to save time
        // value of -1 means it needs to be calculated
        // Since we want to hold the value of sum, we need a range of [sum+1]
      
        int[][] dp = new int[numOfCoins][sum+1];
        for (int i=0; i<numOfCoins; i++){
            for (int j=0; j<=sum; j++){
                  dp[i][j] = -1;
            }
        }
        
        
        return getDiffWays ( 0, sum, dp);
                
    }
    


    
}
