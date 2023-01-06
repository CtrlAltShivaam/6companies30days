/*
 * Given the coordinates of four points in 2D space p1, p2, p3 and p4, 
 * return true if the four points construct a square.
 * 
 *  The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
 * 
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).

 
 */

 //Naive Approach 252/254 test cases passed
class Solution {
    static int DistanceSq(int[] A,int[] B){
        return (A[0]-B[0])*(A[0]-B[0]) + (A[1]-B[1])*(A[1]-B[1]);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d1 = DistanceSq(p1,p2);
        int d2 = DistanceSq(p1,p3);
        int d3 = DistanceSq(p1,p4);

        if(d1==0 || d2==0 || d3==0) return false;
        if(d1==d2 && 2*d1==d3 && 2*DistanceSq(p2,p4)==DistanceSq(p2,p3)) return true;
        if(d2==d3 && 2*d2==d1 && 2*DistanceSq(p3,p2)==DistanceSq(p3,p4)) return true;
        if(d1==d3 && 2*d1==d2 && 2*DistanceSq(p2,p3)==DistanceSq(p2,p4)) return true;
        return false;
    }
}