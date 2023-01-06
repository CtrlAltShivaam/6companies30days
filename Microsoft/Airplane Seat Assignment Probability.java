/*
 * n passengers board an airplane with exactly n seats. The first passenger has lost the ticket and picks a seat randomly. But after that, the rest of the passengers will:
 * Take their own seat if it is still available, and
 * Pick other seats randomly when they find their seat occupied
 * Return the probability that the nth person gets his own seat.
 * 
 * 
 */

 class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1)
            return 1;
        double[] strg = new double[n];
        strg[0] = 1.0;
        strg[1] = 0.5;
        for(int i=2;i<strg.length;i++){
            double d = (1/(1.0*n)) + ((n-2)/(1.0*n))*(strg[i-1]);
            strg[i] = d;
        }
        return strg[n-1];
    }
}