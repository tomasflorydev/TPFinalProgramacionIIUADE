package Servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prim {
    public static List<String> prim(int[][] pesos) {
        int n = pesos.length;
        if (n == 0) {
            return Collections.emptyList();
        } else {
            boolean[] inMST = new boolean[n];
            int[] clave = new int[n];
            int[] padre = new int[n];
            Arrays.fill(clave, Integer.MAX_VALUE);
            Arrays.fill(padre, -1);
            clave[0] = 0;

            for(int i = 0; i < n - 1; ++i) {
                int u = -1;
                int mejor = Integer.MAX_VALUE;

                for(int v = 0; v < n; ++v) {
                    if (!inMST[v] && clave[v] < mejor) {
                        mejor = clave[v];
                        u = v;
                    }
                }

                if (u == -1) {
                    break;
                }

                inMST[u] = true;

                for(int v = 0; v < n; ++v) {
                    int peso = pesos[u][v];
                    if (peso > 0 && !inMST[v] && peso < clave[v]) {
                        clave[v] = peso;
                        padre[v] = u;
                    }
                }
            }

            List<String> res = new ArrayList();

            for(int v = 1; v < n; ++v) {
                if (padre[v] != -1) {
                    res.add(padre[v] + "-" + v + "(" + pesos[padre[v]][v] + ")");
                }
            }

            return res;
        }
    }
}
