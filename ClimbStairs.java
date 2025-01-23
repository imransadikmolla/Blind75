class ClimbStairs {
    public int climbStairs(int n) {
        if(n==1)
          return 1;
        int one=1;
        int two=2;
        int total=two;
        for(int i=3;i<=n;i++){
            total=one+two;
            one=two;
            two=total;
        }
        return total;
        
    }
}
