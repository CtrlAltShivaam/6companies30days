/* 447. Number of Boomerangs */

/*
 * You are given n points in the plane that are all distinct, 
 * where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) 
 * such that the distance between i and j equals the distance between i and k 
 * (the order of the tuple matters).
 * Return the number of boomerangs.
 */

 class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n=points.length;
        int total=0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> mp=new HashMap<>();
            for(int j=0;j<n;j++){
                int dist= ((points[i][0]-points[j][0])*(points[i][0]-points[j][0]) + (points[i][1]-points[j][1])*(points[i][1]-points[j][1]));
                mp.put(dist,mp.getOrDefault(dist, 0) + 1);
            }
            for(int val: mp.values())
            total+=val*(val-1);
            mp.clear();
        }
        return total;
    }
}