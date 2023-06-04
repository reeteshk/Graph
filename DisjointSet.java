import java.util.*;
import java.util.ArrayList;

class DisjointSet{
    List<Integer>rank;
    List<Integer>parent;
    List<Integer>size>;
    public DisjointSet(int n){
        rank=new ArrayList<>();
        parent=new ArrayList<>();
        size=new ArrayList<>();
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node)
    {
        if(node==parent.get(node))
            return node;
        return parent.set(node,findUPar(parent.get(node)));
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
            size.set(uPar,size.get(uPar)+size.get(vPar));
        }
        else if(rank.get(uPar)<rank.get(vPar))
        {
            parent.set(uPar,vPar);
            size.set(vPar,size.get(vPar)+size.get(uPar));
        }
        else{
            parent.set(vPar,uPar);
            size.set(uPar,size.get(uPar)+size.get(vPar));
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