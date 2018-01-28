
import java.time.Duration;
import java.time.Instant;
import static java.time.Instant.now;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilanashay
 */


public class SolutionMain {
    public SolutionMain(){}
    
    /**
     *
     * @param args
     */
    public static void main( String[] args ) {
        System.out.println ("main solution");
        Instant startTime, endTime;
        Duration timeElapsed;

//  Question 16:
        startTime = now();
        PowerDigitSum powerDigit = new PowerDigitSum();
        endTime = now();
        timeElapsed = Duration.between(startTime, endTime);
        System.out.println("16: Sum of digits of (2 power 1000) = "+powerDigit.calc2power(1000)+" running time: "+timeElapsed.toMillis()+" milliseconds");
        
// Question 31:
        try{
            int i=200;
            startTime = now();
            CoinsSum coinsSum = new CoinsSum();
            int ways=coinsSum.getDiffWaysGenerateSum(i);
            endTime = now();
            timeElapsed = Duration.between(startTime, endTime);
            System.out.println("31: num of different ways to use coins for "+i+" is="+ ways+" running time: "+timeElapsed.toMillis()+" milliseconds");
        }catch (Exception e){
        }
        
// Question 67:
        startTime = now();
        MaxPathSumII maxPathSum = new MaxPathSumII();        
        endTime = now();
        timeElapsed = Duration.between(startTime, endTime);
        System.out.println ("67: Max path of p067_triangle.txt="+maxPathSum.getMaxPath()+" running time: "+timeElapsed.toMillis()+" milliseconds");
    }
         
}
