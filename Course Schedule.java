class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int V=numCourses;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++)
        {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

         
        int indegree[]=new int[V];
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
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
        
        ArrayList<Integer>al=new ArrayList<Integer>();
        int i=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            al.add(node);
            
            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        
        if(al.size()==V)
        {
            return true;
        }
        else{
            return false;
        }
    }
}