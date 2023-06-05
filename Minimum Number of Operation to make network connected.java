import java.util.*;

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
    
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int cntExtra=0;
        int m=connections.length;
        for(int i=0;i<m;i++)
        {
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.findUPar(u)==ds.findUPar(v))
            {
                cntExtra++;
            }
            else
            {
                ds.unionBySize(u,v);
            }
        }
        int cntC=0;
        for(int i=0;i<n;i++)
        {
            if(ds.parent.get(i)==i) cntC++;
        }
        int ans=cntC-1;
        if(cntExtra>=ans) return ans;
        return -1;
    }
}