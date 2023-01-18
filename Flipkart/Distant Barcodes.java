/* 1054. Distant Barcodes */

/* In a warehouse, there is a row of barcodes, 
where the ith barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal. 
You may return any answer, and it is guaranteed an answer exists. */

// using priority queue

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n=barcodes.length;
        int[] result = new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        for(int a: barcodes) map.put(a,map.getOrDefault(a,0)+1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        maxHeap.addAll(map.keySet());
        int index=0;
        while(maxHeap.size() >0){
            int a = maxHeap.poll();
            result[index++] = a;
            if(maxHeap.size()==0) break;
            int b=maxHeap.poll();
            result[index++] = b;

            modify(map,maxHeap,a);
            modify(map,maxHeap,b);
        }
        return result;
    }
    private void modify(Map<Integer,Integer> map,PriorityQueue<Integer> maxHeap,int m){
        if(map.get(m)==1) map.remove(m);
        else{
            map.put(m,map.get(m)-1);
            maxHeap.offer(m);
        }
    }
}