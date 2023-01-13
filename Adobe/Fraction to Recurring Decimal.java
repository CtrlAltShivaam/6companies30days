/* 166. Fraction to Recurring Decimal */

/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.

 
 */
//34/39 test cases passed

 class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder ans= new StringBuilder();
        boolean neg = false;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            neg = true;
        }
        if (numerator < 0) {
            numerator = -numerator;
        }
        if (denominator < 0) {
            denominator = -denominator;
        }
        int q=numerator/denominator;
        int r= numerator%denominator;
        ans.append(q);
        if(r==0) return ans.toString();
        else{
            ans.append("."); 
            HashMap<Integer,Integer> map=new HashMap<>();

            while(r!=0){
                if(map.containsKey(r)){
                    int len = map.get(r);
                    ans.insert(len,"(");
                    ans.append(")");
                    break;
                }
                else{
                    map.put(r,ans.length());
                    r*=10;
                    q=r/denominator;
                    r=r%denominator;
                    ans.append(q);
                }
            }
        } 
        String s=ans.toString();
        if (neg == true) {
            s = '-' + s;
        }
        return s;
    }
}