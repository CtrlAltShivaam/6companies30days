/* 478. Generate Random Point in a Circle */

/* Given the radius and the position of the center of a circle, implement the function randPoint which generates a uniform random point inside the circle.

Implement the Solution class:

Solution(double radius, double x_center, double y_center) initializes the object with the radius of the circle radius and the position of the center (x_center, y_center).
randPoint() returns a random point inside the circle. A point on the circumference of the circle is considered to be in the circle. The answer is returned as an array [x, y].

*/

class Solution {
    private double radius;
    private double x_center;
    private double y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double length = Math.sqrt(Math.random()) * radius;
        double degree = Math.random() * 2 * Math.PI;
        double x = x_center + length * Math.cos(degree);
        double y = y_center + length * Math.sin(degree);
        return new double[] {x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */