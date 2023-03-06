class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int color[]=new int[graph.length];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            ArrayList<Integer>al=new ArrayList<>();
            for(int j=0;j<graph[i].length;j++)
            {
                al.add(graph[i][j]);
            }
            adj.add(al);
        } 
        for(int i=0;i<graph.length;i++)
        {
            color[i]=-1;
        }
        for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1)
            {
                if(check(i,graph.length,adj,color)==false)
                {
                    return false;
                }
            }
        }
        return true;

    }
    public boolean check(int i,int V,ArrayList<ArrayList<Integer>> adj,int color[])
    {
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        color[i]=0;
        while(!q.isEmpty())
        {
            int node=q.remove();
            for(int it:adj.get(node))
            {
                if(color[it]==-1)
                {
                    color[it]=1-color[node];
                    q.add(it);
                }
                else if(color[node]==color[it])
                {
                    return false;
                }
            }
        }
        return true;
    }
}