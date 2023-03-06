import java.util.*;
class Solution {
    public int numEnclaves(int[][] grid) {
        
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];

    Queue<Pair>q=new LinkedList<Pair>();

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(i==0 || j==0 || i==n-1 || j==m-1)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Pair(i,j));
                    visited[i][j]=1;
                }
            }
        }
    }
    int delrow[]={-1,0,1,0};
    int delcol[]={0,1,0,-1};

    while(!q.isEmpty())
    {
        int row=q.peek().first;
        int col=q.peek().second;
        q.remove();
        for(int i=0;i<4;i++)
        {
            int drow=row+delrow[i];
            int dcol=col+delcol[i];
            if(drow>=0 && drow<n && dcol>=0 && dcol<m && visited[drow][dcol]==0 && grid[drow][dcol]==1 )
            {
                 q.add(new Pair(drow,dcol));
                visited[drow][dcol]=1;
               
            }
    }
    }
    int count=0;
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if(grid[i][j]==1 & visited[i][j]==0)
            {
                count++;
            }
        }
    }
    return count;
    

    }
}

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
