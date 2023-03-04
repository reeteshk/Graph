import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    cnt++;
                    DFSMarking(grid,i,j);
                }
            }
        }
        return cnt;
        
    }

   private void DFSMarking(char[][] grid, int i, int j) {
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;
    grid[i][j] = '0';
    DFSMarking(grid, i + 1, j);
    DFSMarking(grid, i - 1, j);
    DFSMarking(grid, i, j + 1);
    DFSMarking(grid, i, j - 1);
}
}

import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    cnt++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
        
    }

    public void bfs(int i,int j,int[][] vis,char [][]grid)
    {
        vis[i][j]=1;
        Queue<Pair>queue=new LinkedList<Pair>();
        queue.add(new Pair(i,j));
        int n=grid.length;
        int m=grid[0].length;


        while(!queue.isEmpty())
        {
            int row=queue.peek().first;
            int col=queue.peek().second;
            queue.remove();

            if( row-1>=0 && grid[row-1][col]=='1' && vis[row-1][col]==0 )
            {
                vis[row-1][col]=1;
                queue.add(new Pair(row-1,col));
            }
            if( row+1<n && grid[row+1][col]=='1' && vis[row+1][col]==0 )
            {
                vis[row+1][col]=1;
                queue.add(new Pair(row+1,col));
            }
            if( col-1>=0 && grid[row][col-1]=='1' && vis[row][col-1]==0 )
            {
                vis[row][col-1]=1;
                queue.add(new Pair(row,col-1));
            }
            if( col+1<m && grid[row][col+1]=='1' && vis[row][col+1]==0 )
            {
                vis[row][col+1]=1;
                queue.add(new Pair(row,col+1));
            }
        }
    }
}


class Pair{
    int first;
    int second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}