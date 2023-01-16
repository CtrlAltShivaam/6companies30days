/* 692. Top K Frequent Words */

/*
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest. 
 * Sort the words with the same frequency by their lexicographical order.
 */

 class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){   // Counting Freq 
           map.put(words[i], map.getOrDefault(words[i],0) + 1);
        }
        
        List<String> ans = new ArrayList<>(map.keySet()); // List with all words
        
        Collections.sort(ans, (A1, A2) ->  // sorting
                        map.get(A1) == map.get(A2) //if two has same freq
                        ? A1.compareTo(A2)  //(True) one with lower alphabetical order comes first(lexicographical order) 
                        : map.get(A2) - map.get(A1)); //(False) else most freq will come first
        
        return ans.subList(0, k); 


        //using arrays 
        /*
        List<String> ans = new ArrayList<>();
        ArrayList<String>[] list = new ArrayList[words.length+1];
        
        Arrays.sort(words);
        
        String prev = words[0];
        int count = 1;
        for(int i = 1 ; i<words.length ; i++){
            if(!words[i].equals(prev)){
                
                if(list[count]==null){
                    list[count] = new ArrayList<>();
                }
                
                list[count].add(prev);
                prev = words[i];
                count = 1;
            }
            else{
                count++;
            }
        }
        
        if(list[count]==null){
            list[count] = new ArrayList<>();
        }
        list[count].add(prev);
        
        for(int i = words.length ; i>0 && k>0 ; i--){
            if(list[i]!=null && list[i].size()>0){
                int j = 0;
                while(k>0 && j<list[i].size()){
                    ans.add(list[i].get(j));
                    j++;
                    k--;
                }
            }
        }
        
        return ans;
        */
    }
}