/*
 * A transaction is possibly invalid if:
 * the amount exceeds $1000, or;
 * if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
 * You are given an array of strings transaction where transactions[i] consists of comma-separated values 
 * representing the name, time (in minutes), amount, and city of the transaction.
 * 
 *  Return a list of transactions that are possibly invalid. You may return the answer in any order.
 */

 class Solution {
    class Transaction{
        String name,city;
        int amount,time;
        Transaction(String input){
            String[] split = input.split(",");
            this.name=split[0];
            this.time=Integer.parseInt(split[1]);
            this.amount=Integer.parseInt(split[2]);
            this.city=split[3];
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans=new ArrayList();
        HashMap<String,List<Transaction>> map = new HashMap();
        for(String t: transactions){
            Transaction tran=new Transaction(t);
            map.putIfAbsent(tran.name,new ArrayList());
            map.get(tran.name).add(tran);
        }
        for(String t: transactions){
            Transaction tran=new Transaction(t);
            if(!is_valid(tran,map.get(tran.name))) ans.add(t);
        }
        return ans;
    }
    public boolean is_valid(Transaction t,List<Transaction> list){
        if(t.amount>1000) return false;
        for(Transaction l: list){
            if(!t.city.equals(l.city) && Math.abs(t.time-l.time) <=60) return false;
        }
        return true;
    }
}