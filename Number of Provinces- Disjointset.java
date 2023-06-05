class DisjointSet{
    List<Integer>rank;
    List<Integer>parent;
    List<Integer>size;
    public DisjointSet(int n){
        rank=new ArrayList<>();
        parent=new ArrayList<>();
        size=new ArrayList<>();
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node)
    {
        if(node==parent.get(node))
            return node;
         parent.set(node,findUPar(parent.get(node)));
         return parent.get(node);
    }
    public void unionByRank(int u,int v)
    {
        int uPar=findUPar(u);
        int vPar=findUPar(v);
        if(uPar==vPar)
            return;
        if(rank.get(uPar)>rank.get(vPar))
        {
            parent.set(vPar,uPar);
        }
        else if(rank.get(uPar)<rank.get(vPar))
        {
            parent.set(uPar,vPar);
        }
        else{
            parent.set(vPar,uPar);
            rank.set(uPar,rank.get(uPar)+1);
        }
    }
    public void unionBySize(int u,int v)
    {
        int uPar=findUPar(u);
        int vPar=findUPar(v);
        if(uPar==vPar)
            return;
        if(size.get(uPar)>size.get(vPar))
        {
            parent.set(vPar,uPar);
            size.set(uPar,size.get(uPar)+size.get(vPar));
        }
        else{
            parent.set(uPar,vPar);
            size.set(vPar,size.get(vPar)+size.get(uPar));
        }
    }
}
class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet ds= new DisjointSet(V);
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if(adj.get(i).get(j)==1)
                {
                    ds.unionBySize(i+1,j+1);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<V;i++)
        {
            if(ds.findUPar(i+1)==i+1)
            {
                cnt++;
            }
        }
        return cnt;
    }
};