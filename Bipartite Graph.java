class Solution {
    public boolean isBipartite(int[][] graph) {
        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        // for(int i=0;i<adj.size();i++)
        // {
        //     adj.get(i)=new ArrayList<Integer>();
        // }
        for(int i=0;i<graph.length;i++)
        {
            ArrayList<Integer>al=new ArrayList();
            for(int j=0;j<graph[i].length;j++)
            {
                al.add(graph[i][j]);
            }
            adj.add(al);
        }
         int color[]=new int[graph.length];
        // int visited[]=new int[graph.length];
        for(int i=0;i<color.length;i++)
        {
            color[i]=-1;
        }
        // for(int i=0;i<graph.length;i++)
        // {
        //     if(color[i]==-1)
        //     {
        //         if(BFS(adj,0,i,color)==false)
        //         {
        //             return false;
        //         }
        //     }
        // }

          for(int i=0;i<graph.length;i++)
        {
            if(color[i]==-1)
            {
                if(DFS(adj,-1,i,color)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean BFS(ArrayList<ArrayList<Integer>>adj,int col,int start,int color[])
    {
       Queue<Integer> q = new LinkedList<Integer>();
	    q.add(start); 
	    color[start] = 0; 
	    while(!q.isEmpty()) {
	        int node = q.peek();
	        q.remove(); 
	        
	        for(int it : adj.get(node)) {
	            if(color[it] == -1) {
	                
	                color[it] = 1 - color[node]; 
	                q.add(it); 
	            }
	            else if(color[it] == color[node]) {
	                return false; 
	            }
	        }
	    }
	    return true; 

    }
    public boolean DFS(ArrayList<ArrayList<Integer>>adj,int col,int start,int color[])
    {
        color[start]=col;
        for(int it:adj.get(start))
        {
            if(color[it]==-1)
            {
                if(DFS(adj,1-col,it,color)==false)
                return false;
            }
            else if(color[it]==col)
            {
                return false;
            }
        }
        return true;

    }
}