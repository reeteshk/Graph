import java.util.Scanner;

public class Graphrepresentation {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int adj[][]=new int[n+1][n+1];
        for (int i=0;i<=n;i++)
        {
            int u=s.nextInt();
            int v=s.nextInt();
            adj[u][v]=1;
            adj[v][u]=1;
        }
    }
}
