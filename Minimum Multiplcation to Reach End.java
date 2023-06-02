class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
       Queue<Pair>q=new LinkedList<>();
       int dist[]=new int[100000];
       for(int i=0;i<100000;i++)
       {
           dist[i]=(int)(1e9);
       }
       int mod=100000;
       q.add(new Pair(start,0));
       dist[start]=0;
       int n=arr.length;
       while(!q.isEmpty())
       {
           int node=q.peek().first;
           int dis=q.peek().second;
           q.remove();
           
           for(int i=0;i<n;i++)
           {
            
                int num=(arr[i]*node)%mod;
                
                if(dist[num]>dis+1)
                {
                    dist[num]=dis+1;
                
                if(num==end)
                {
                    return dis+1;
                }
                q.add(new Pair(num,dis+1));
            }
                
           }
       }
       return -1;
    }
}