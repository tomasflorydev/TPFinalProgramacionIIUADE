package Servicios;

public class FloydWarshall {
    private static final int INF = 536870911;

    public static int[][] floydWarshall(int[][] pesos) {
        int n = pesos.length;
        int[][] dist = new int[n][n];

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                dist[i][j] = i == j ? 0 : (pesos[i][j] > 0 ? pesos[i][j] : 536870911);
            }
        }

        for(int k = 0; k < n; ++k) {
            for(int i = 0; i < n; ++i) {
                for(int j = 0; j < n; ++j) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if (dist[i][j] >= 536870911) {
                    dist[i][j] = -1;
                }
            }
        }

        return dist;
    }
}
