class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        
        HashSet<ArrayList<String>>hs=new HashSet<>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==0 && grid[i][j]==1)
                {
                    ArrayList<String>vec=new ArrayList<>();
                    dfs(i,j,visited,grid,vec,i,j);
                    hs.add(vec);
                }
            }
        }
        return hs.size();
        
    }
    private String toString(int i,int j)
    {
        return Integer.toString(i)+" "+Integer.toString(j);
    }
    public void dfs(int row,int col,int visited[][],int [][]grid,ArrayList<String>vec,int row0,int col0)
    {
        visited[row][col]=1;
        vec.add(toString(row-row0,col-col0));
        int n=grid.length;
        int m=grid[0].length;
        
       int delrow[]={-1,0,1,0};
       int delcol[]={0,1,0,-1};
        for(int i=0;i<4;i++)
        {
            int drow=row+delrow[i];
            int dcol=col+delcol[i];
            if(drow>=0 && drow<n && dcol>=0 && dcol<m && visited[drow][dcol]==0 && grid[drow][dcol]==1 )
            {
                dfs(drow,dcol,visited,grid,vec,row0,col0);
               
            }
            
        }
    }
    
    
}
class Pair{
    int first ;
    int second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
