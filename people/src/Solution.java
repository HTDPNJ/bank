public class Solution {
    public double Power(double base, int exponent) {
        if(base==0&&exponent==0){
            return 1;
        }else if(base==0&&exponent!=0){
            return 0;
        }else{
            int absexponent=Math.abs(exponent);
            if(exponent>=0){
                return get(base,absexponent);
            }else{
                return 1.0/get(base,absexponent);
            }
        }
    }
    public double get(double base,int absexponent){
        if(absexponent==0)
            return 1;
        else if(absexponent==1)
            return base;
        double res=get(base,absexponent>>1);
        res*=res;
        if((absexponent&1)==1){
            res=res*base;
        }
        return res;
    }
}