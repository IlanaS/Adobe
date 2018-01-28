
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilanashay
 */
public class PowerDigitSum {
    /**
     * 
    * Power digit sum
    * 
    * https://projecteuler.net/problem=16 
    * Problem 16 
    * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

    * What is the sum of the digits of the number 2 power 1000?
     */
    public PowerDigitSum(){
        
    }
    
   

/**

 * Calculate 2 power of num,  
 * numPower2 - 2 in power of num
 * sum summarize the digits in numPower2
 * while numPower2 is bigger than 0: 
 *    mod operation will get the right most digit:
 *    division will get rid of right most digit to get to the next digit   
 * 
 * @param num
 * @return summarize the digits of (2 power of num)
 */

    public int calc2power(int num){
        BigInteger two = new BigInteger ("2");
        BigInteger numPower2 = two.pow(num);
        BigInteger sum = new BigInteger("0");
        while (numPower2.signum()>0){
            BigInteger mod = numPower2.mod(BigInteger.TEN);
            sum = sum.add(mod);
            numPower2 = numPower2.divide(BigInteger.TEN);
        }
        return sum.intValue();
    }       
}
