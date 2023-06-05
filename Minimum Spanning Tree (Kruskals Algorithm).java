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
class Edge implements Comparable<Edge>{
    int src,dist,weight;
    Edge(int src,int dist,int weight)
    {
        this.src=src;
        this.dist=dist;
        this.weight=weight;
    }
    public int compareTo(Edge compareEdge)
    {
        return this.weight-compareEdge.weight;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	     List<Edge> edgesi=new ArrayList<Edge>();
	     for(int i=0;i<edges.length;i++)
	     {
	         Edge temp=new Edge(edges[i][0],edges[i][1],edges[i][2]);
	         Edge temp2=new Edge(edges[i][1],edges[i][0],edges[i][2]);
	         edgesi.add(temp);
	         edgesi.add(temp2);
	     }
	     DisjointSet ds=new DisjointSet(V);
	     Collections.sort(edgesi);
	     int mstWt=0;
	     for(int i=0;i<edgesi.size();i++)
	     {
	         int wt=edgesi.get(i).weight;
	         int u=edgesi.get(i).src;
	         int v=edgesi.get(i).dist;
	         
	         if(ds.findUPar(u)!=ds.findUPar(v))
	         {
	             mstWt +=wt;
	             ds.unionBySize(u,v);
	         }
	     }
	     return mstWt;
	}
}