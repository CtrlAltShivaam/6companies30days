/*
 * 149. Max Points on a Line
 * Hard
 * Given an array of points where points[i] = [xi, yi]
 * represents a point on the X-Y plane, 
 * return the maximum number of points that lie on the same straight line.
 */


 class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n<=2) return n;
        HashMap<Double, Integer> result = new HashMap<Double, Integer>();
        int max=0;
 
    for(int i=0; i<points.length; i++){
        int duplicate = 1;//
        int vertical = 0;
        for(int j=i+1; j<points.length; j++){
            //handle duplicates and vertical
            if(points[i][0] == points[j][0]){
                if(points[i][1] == points[j][1]){
                    duplicate++;
                }else{
                    vertical++;
                }
            }else{
                double slope = points[j][1] == points[i][1] ? 0.0
				        : (1.0 * (points[j][1] - points[i][1]))
						/ (points[j][0] - points[i][0]);
 
                if(result.get(slope) != null){
                    result.put(slope, result.get(slope) + 1);
                }else{
                    result.put(slope, 1);
                }
            }
        }
 
        for(Integer count: result.values()){
            if(count+duplicate > max){
                max = count+duplicate;
            }
        }
 
        max = Math.max(vertical + duplicate, max);
        result.clear();
    }
 
 
    return max;

/*
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int total=2;
                for(int k=0;k<n;k++){
                    if(k!=i && k!=j){
                        if(slope(points[i][0],points[j][0],points[i][1],points[j][1])== slope(points[k][0],points[j][0],points[k][1],points[j][1])) total++;
                    }
                }
                max=Math.max(max,total);
            }
        }
        return max;
        */
    }
    public double slope(int x0,int x1,int y0,int y1){
        if(y0==y1) return 0;
        if(x0==x1) return x0;
        else{
            int m= (y1-y0)/(x1-x0);
            //int b=y0-m*x0;
            return m;
        }
    }
}