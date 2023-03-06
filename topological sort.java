class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        int vis[]=new int[V];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(V,adj,0,vis,st);
            }
        }
        int ans[]=new int[V];
        int k=0;
        while(!st.isEmpty())
        {
            ans[k]=st.pop();
            k++;
        }
        return ans;
    }
    
    public static void dfs(int V,ArrayList<ArrayList<Integer>> adj,int start,int vis[],Stack<Integer> st)
    {
        
        vis[start]=1;
        
        for(Integer it:adj.get(start))
        {
            if(vis[it]==0)
            {
                dfs(V,adj,it,vis,st);
            }
        }
        st.push(start);
    }
}
