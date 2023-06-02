class Solution {
    
    class Pair{
        int node, time;
        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }

    int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < roads.size(); i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1), roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0), roads.get(i).get(2)));
        }
        int[] dist = new int[n];
        int[] ways = new int[n];
        
        for(int i = 0; i < n ; i++) dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;
        ways[0] = 1;
        int MOD = (int) (1e9) + 7; 
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.time-y.time);
        pq.add(new Pair(0, 0));
        
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int time = pq.peek().time;
            pq.poll();
            for(Pair it: adj.get(node)){
                if(dist[it.node] > time + it.time){
                    if(time + it.time > 0){
                        dist[it.node] = time + it.time;
                        pq.add(new Pair(it.node, dist[it.node]));
                        ways[it.node] = ways[node] % MOD;
                    }
                } else if (dist[it.node] == time + it.time){
                    ways[it.node] = (ways[it.node] + ways[node]) % MOD;
                }
            }
        }
        return ways[n-1] % MOD;
    }
}