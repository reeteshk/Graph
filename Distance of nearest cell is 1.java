class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair>q=new LinkedList<>();
        int visited[][]=new int[n][m];
        int ans[][]=new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Pair(i,j,0));
                    visited[i][j]=1;
                }
                else
                {
                    visited[i][j]=0;
                }
            }
        }
      int delrow[]={-1,0,1,0};
      int delcol[]={0,1,0,-1};
      
      while(!q.isEmpty())
      {
          int row=q.peek().row;
          int col=q.peek().col;
          int val=q.peek().val;
          q.remove();
          ans[row][col]=val;
          for(int i=0;i<4;i++)
          {
              int drow=delrow[i]+row;
              int dcol=delcol[i]+col;
              if(drow>=0 && drow<n && dcol>=0 && dcol<m && visited[drow][dcol]==0)
              {
                  visited[drow][dcol]=1;
                  q.add(new Pair(drow,dcol,val+1));
              }
          }
          
      }
      return ans;
    }

}



class Pair{
    int row;
    int col;
    int val;
    
    Pair(int row,int col,int val)
    {
        this.row=row;
        this.col=col;
        this.val=val;
    }
}