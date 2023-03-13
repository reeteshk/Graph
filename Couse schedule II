class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
           int V=numCourses;
        int indegree[]=new int[V];
         ArrayList<Integer>al=new ArrayList<Integer>();

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        int m=prerequisites.length;

        for(int i=0;i<m;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i=0;i<V;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        int k=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
           al.add(node);
            q.remove();
            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }

        if(al.size()<V)
        {
            int ans[]={};
            return ans;
        }
        int ans[]=new int[al.size()];
        for(int i=0;i<al.size();i++)
        {
            ans[i]=al.get(i);
        }
        return ans;
    }
}