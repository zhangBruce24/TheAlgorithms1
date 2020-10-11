/*

Non-brute force solution to Project Euler Problem 18 (Also works for Problem 67)
www.projecteuler.net/problem=18
www.projecteuler.net/problem=67

While this problem can be solved using brute-force, a DP solution is much more efficient.
Consider the triangle given in the example:
    3
   7 4
  2 4 6
 8 5 9 3

consider the second row 7,4.
If the path reaches 7 (counting from the top), we must have come from 3, meaning our 
running sum until now is 7+3 = 10. The same goes for 4 ; (4+3 = 7). This effectively means we can
replace 7 and 4 with 10 and 7, and reduce our problem to this triangle:
     
   10 7
  2  4  6
8  5  9   3

Which further reduces to:

  12 14 13
 8  5  9  3

Repeating the process a final time :

22 19 23 17

And the maximum of the numbers in this row will give us the answer. This is because
we have effectively calculated all the n*(n-1) running sums - 2 for each element,only
taking the maximum of the two adjacent.

The same would work starting from the bottom row of the triangle, in which case
the final element left at the tip of the triangle would be the answer.

*/


public class MaximumPathSum {
    static int [][] triangle = new int[][]{
      {75},
      {95, 64},
      {17, 47, 82},
      {18, 35, 87, 10},
      {20, 04, 82, 47, 65},
      {19, 01, 23, 75, 03, 34},
      {88, 02, 77, 73, 07, 63, 67},
      {99, 65, 04, 28, 06, 16, 70, 92},
      {41, 41, 26, 56, 83, 40, 80, 70, 33},
      {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
      {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
      {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
      {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
      {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
      {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23},
    };
    

    public static int maxSum(int[][] tri){
        int answer = 0;
        
        for(int i = 1; i < tri.length; i++){
            tri[i][0] += tri[i-1][0];
            tri[i][i] += tri[i-1][i-1];
            for(int j = 1; j < i; j++){
                tri[i][j] += Math.max(tri[i-1][j], tri[i-1][j-1]);
            }
        }
        for(int k = 0; k < tri.length; k++) {
            answer = Math.max(tri[tri.length - 1][k], answer);
        }
        return answer;
    }
    
    public static void main(String[] args){
        System.out.println(maxSum(triangle));
    }

}
    

