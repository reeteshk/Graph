class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int intcolor=image[sr][sc];
        int ans[][]=image;

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        dfs(sr,sc,ans,image,color,delrow,delcol,intcolor);
        return ans;
    }
    public void dfs(int sr,int sc,int ans[][],int image[][],int color,int delrow[],int delcol[],int intcolor)
    {
        ans[sr][sc]=color;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow=sr+delrow[i];
            int ncol=sc+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==intcolor && image[nrow][ncol]!=color)
            {
                dfs(nrow,ncol,image,ans,color,delrow,delcol,intcolor);
            }
        }
    }
}