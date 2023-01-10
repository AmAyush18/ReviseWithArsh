// LeetCode Problem Link: https://leetcode.com/problems/max-points-on-a-line/

class Solution {
    public int maxPoints(int[][] points) {
        // becoz with any two points we can form a line
        if(points.length <= 2){
            return points.length;
        }
        // if there are more than 2 points 
        // that means any two points can be chosen to form a line 
        // so atleast two points would definitely fall on same line
        int max_points = 2;

        // now traverse throw points array
        // and for every two points check which points lie on it

        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                // total points that fall on line formed using ith and jth point
                int total = 2;

                for(int k = 0; k < points.length; k++){
                    if(k != i && k != j){
                        // slope = (x2 - x1)/(y2 - y1)
                        // since both slopes should be equal 
                        // so (xk - xi) / (yk - yi) = (xj - xi) / (yj - yi)
                        // which we can write as (xk - xi) * (yj - yi) = (yk - yi) * (xj - xi)
                        long m1 = (points[k][0] - points[i][0]) * (points[j][1] - points[i][1]);
                        long m2 = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);
                        // if they are equal we got a point on this line
                        if(m1 == m2) total++;
                    }
                }
                // now if total is greater than max_points update it
                max_points = Math.max(total, max_points);
            }
        }
        return max_points;
    }
}
