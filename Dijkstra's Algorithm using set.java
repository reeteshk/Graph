class Solution
{
    
     static class Pair{
    int node;
    int distance;
    public Pair(int distance,int node){
        this.node = node;
        this.distance = distance;
    }
}
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        
   //return PriorityQueue(V,adj,S);
   
   return usingTreeSet(V,adj,S);
}

static int[] usingTreeSet(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
    // Write your code here
        TreeSet<Pair> set=new TreeSet<>(new Comparator<>(){
            public int compare(Pair a,Pair b){
                if(a.distance==b.distance) return a.node-b.node;
                return a.distance-b.distance;
            }
        });
        int[] distance = new int[V];
        for(int i = 0; i < V; i ++)
            distance[i] = Integer.MAX_VALUE;
        distance[S] = 0;
        set.add(new Pair(0,S));
        while(set.size() != 0){
            Pair temp = set.iterator().next();
            set.remove(temp);
            int node = temp.node;
            int dist = temp.distance;
            for(int i = 0; i < adj.get(node).size(); i ++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int edgenode = adj.get(node).get(i).get(0);
                if(dist + edgeWeight < distance[edgenode] || distance[edgenode] == Integer.MAX_VALUE){
                        Pair x = new Pair(dist + edgeWeight, edgenode);
                        if(set.contains(x)) set.remove(x);
                        distance[edgenode] = dist + edgeWeight;
                        set.add(new Pair(dist + edgeWeight, edgenode));
                    
                }
            }
        }
        return distance;
}