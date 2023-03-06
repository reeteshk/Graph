class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int V=graph.length;
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
        ArrayList<ArrayList<Integer>>adjRev=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adjRev.add(new ArrayList<>());
        }
       int indegree[]=new int[V];
       for(int i=0;i<V;i++)
       {
           for(int it:adj.get(i))
           {
              adjRev.get(it).add(i);
              indegree[i]++;
           }
       }

        Queue<Integer>q=new LinkedList<Integer>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        
        List<Integer>al=new ArrayList<Integer>();
        int i=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            al.add(node);
            
            for(int it:adjRev.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }

        Collections.sort(al);
        return al;
        
        
    }