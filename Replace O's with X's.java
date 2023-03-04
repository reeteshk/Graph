class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        int vis[][]=new int[n][m];
        
        for(int j=0;j<m;j++)
        {
            if(vis[0][j]==0 && a[0][j]=='O')
            {
                dfs(0,j,vis,a,delrow,delcol);
            }
            if(vis[n-1][j]==0 && a[n-1][j]=='O')
            {
                dfs(n-1,j,vis,a,delrow,delcol);
            }
        }
        for(int j=0;j<n;j++)
        {
            if(vis[j][0]==0 && a[j][0]=='O')
            {
                dfs(j,0,vis,a,delrow,delcol);
            }
            if(vis[j][m-1]==0 && a[j][m-1]=='O')
            {
                dfs(j,m-1,vis,a,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && a[i][j]=='O' )
                {
                    a[i][j]='X';
                }
            }
        }
        return a;
    }
    
    public static void dfs(int row,int col,int vis[][],char a[][],int delrow[],int delcol[])
    {
        int n=a.length;
        int m=a[0].length;
        vis[row][col]=1;
        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && a[nrow][ncol]=='O')
            {
                dfs(nrow,ncol,vis,a,delrow,delcol);
            }
        }
        
    }
}