package Servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<String> kruskal(int[][] pesos) {
        int n = pesos.length;
        List<Arista> aristas = new ArrayList();

        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                if (pesos[i][j] > 0) {
                    aristas.add(new Arista(i, j, pesos[i][j]));
                }
            }
        }

        Collections.sort(aristas);
        DSU dsu = new DSU(n);
        List<String> res = new ArrayList();

        for(Arista a : aristas) {
            if (dsu.union(a.u, a.v)) {
                res.add(a.toString());
            }
        }

        return res;
    }

    private static class Arista implements Comparable<Arista> {
        int u;
        int v;
        int peso;

        Arista(int u, int v, int peso) {
            this.u = u;
            this.v = v;
            this.peso = peso;
        }

        public int compareTo(Arista o) {
            return Integer.compare(this.peso, o.peso);
        }

        public String toString() {
            return "(" + this.u + "-" + this.v + ":" + this.peso + ")";
        }
    }

    private static class DSU {
        int[] p;

        DSU(int n) {
            this.p = new int[n];

            for(int i = 0; i < n; this.p[i] = i++) {
            }

        }

        int find(int x) {
            return this.p[x] == x ? x : (this.p[x] = this.find(this.p[x]));
        }

        boolean union(int a, int b) {
            a = this.find(a);
            b = this.find(b);
            if (a == b) {
                return false;
            } else {
                this.p[b] = a;
                return true;
            }
        }
    }
}
