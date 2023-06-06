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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer>mapMailNode=new HashMap<String,Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String mail=accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail)==false)
                {
                    mapMailNode.put(mail,i);
                }
                else
                {
                    ds.unionBySize(i,mapMailNode.get(mail));
                }
            }
        }
        ArrayList<String>[] mergeMail=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            mergeMail[i]=new ArrayList<String>();
        }
        for(Map.Entry<String,Integer>it:mapMailNode.entrySet())
        {
            String mail=it.getKey();
            int node=ds.findUPar(it.getValue());
            mergeMail[node].add(mail);
        }
        List<List<String>>ans=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(mergeMail[i].size()==0) continue;
            Collections.sort(mergeMail[i]);
            List<String>temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:mergeMail[i])
            {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }
}