package Servicios;

import java.util.Arrays;

public class Dijkstra {
    private static final int INF = 536870911;

    public static int[] dijkstra(int[][] pesos, int origen) {
        int n = pesos.length;
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, 536870911);
        dist[origen] = 0;

        for(int k = 0; k < n; ++k) {
            int u = -1;
            int mejor = 536870911;

            for(int i = 0; i < n; ++i) {
                if (!vis[i] && dist[i] < mejor) {
                    mejor = dist[i];
                    u = i;
                }
            }

            if (u == -1) {
                break;
            }

            vis[u] = true;

            for(int v = 0; v < n; ++v) {
                int peso = pesos[u][v];
                if (peso > 0 && !vis[v] && dist[u] + peso < dist[v]) {
                    dist[v] = dist[u] + peso;
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            if (dist[i] >= 536870911) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
