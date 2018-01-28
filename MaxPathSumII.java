
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/


/**
 * https://projecteuler.net/problem=67
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, 
as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over 
twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
*/

/**
 *
 * @author ilanashay
 */
public class MaxPathSumII {
 
    String fname = "/NetBeansProjects/JavaProject1/resource/p067_triangle.txt";
    
    List<int[]> lstTraingle = new ArrayList<>();
            
    /**
     *  MaxPathSumII constructor
     *  read the triangle numbers from a file:
     *  "/Users/ilanashay/NetBeansProjects/JavaProject1/resource/p067_triangle.txt"
     * 
 * https://projecteuler.net/problem=67 : 
By starting at the top of the triangle below and moving to adjacent numbers on the row below, 
* the maximum total from top to bottom is 23 : 

3 
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, 
as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over 
twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
     */
    public MaxPathSumII(){    
        String filePath = System.getProperty("user.home")+fname;
        // read triangle file
        File file = new File(filePath);
        Scanner sc;
        try {
            sc = new Scanner(file.getAbsoluteFile());
            while (sc.hasNextLine()){
              String line = sc.nextLine();
              String arrStr[] = line.split(" ");
              int arr[] = new int[arrStr.length];
              for (int i=0; i<arrStr.length; i++){
                  arr[i] = Integer.valueOf(arrStr[i]);
              }
              lstTraingle.add(arr);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MaxPathSumII.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    // going backward
    /**
     * 
     * @return max path from top of the triangle to bottom: 
     * go over each of the numbers in the lower row, 
     * for each two adjacent numbers, add the max number to the parent in the row above
     * decrement both of the indexes, of current row and previous row
     * when we get to row 0, the max path is in the single element.
     */
    public int getMaxPath(){
        if ((lstTraingle.isEmpty())||(lstTraingle.get(0)==null)||(lstTraingle.get(0).length==0)){ return 0;}
        for (int i=lstTraingle.size()-1; i>0; i--){
            int arrPrevRow[] = lstTraingle.get(i-1);
            int arrCurrRow[] = lstTraingle.get(i);
            int currRowIdx=0, prevRowIdx=0;
            while (currRowIdx < arrCurrRow.length-1){
                arrPrevRow[prevRowIdx] += Math.max(arrCurrRow[currRowIdx], arrCurrRow[currRowIdx+1]);
                prevRowIdx += 1;
                currRowIdx += 1;
            }
        }
        // Line 0 will hold the result
        return lstTraingle.get(0)[0];
    }
        
}

