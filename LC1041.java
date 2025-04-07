// TC : O(n)
// SC : O(1)


public class LC1041 {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        int x = 0, y = 1;
        int i = 0, j = 0;
        for(int k=0;k<n;k++){
            char ch = instructions.charAt(k);
            if (ch=='G'){
                i += x;
                j += y;
            } else if(ch=='L'){
                int t = x;
                x = -y;
                y = t;
            } else {
                int s = y;
                y = -x;
                x = s;
            }
        }
        return (i==0 && j==0) || !(x==0 && y==1);
    }
}