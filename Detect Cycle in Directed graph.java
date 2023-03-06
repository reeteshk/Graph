class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int vis[]=new int[V];
        int pathVis[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(checkPathDFS(i,adj,vis,pathVis)==true)
                {
                    return true;
                }
            }
        }
        return false;
        }
        
        public boolean checkPathDFS(int i,ArrayList<ArrayList<Integer>> adj,int vis[],int pathVis[])
        {
            vis[i]=1;
            pathVis[i]=1;
            
            for(Integer it:adj.get(i))
            {
                if(vis[it]==0)
                {
                    if(checkPathDFS(it,adj,vis,pathVis)==true)
                    {
                        return true;
                    }
                }
                else if(pathVis[it]==1)
                {
                    return true;
                }
                
            }
            pathVis[i]=0;
            return false;
        }
}