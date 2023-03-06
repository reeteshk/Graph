class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean visited[] = new boolean[n];
        boolean dfsVisited[] = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            if(isCycle(i, graph, visited, dfsVisited) == false)
                ans.add(i);
        }
        
        Collections.sort(ans);
        return ans;
    }
    
    public boolean isCycle(int node, int[][] graph, boolean visited[], boolean dfsVisited[]){
        dfsVisited[node] = true;
        visited[node] = true;
        
        for(int it : graph[node]){
            if(visited[it] != true){
                if(isCycle(it, graph, visited, dfsVisited)){
                    return true;
                }
            }else if(dfsVisited[it] == true){
                    return true;
            }
        }
        return dfsVisited[node] = false;
    }
}