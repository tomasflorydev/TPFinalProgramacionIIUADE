package Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import Modelado.Grafo;
import Modelado.Persona;
import Servicios.Dijkstra;
import Servicios.FloydWarshall;
import Servicios.Kruskal;
import Servicios.Prim;

public class pruebaGrafos {
    public static void main(String[] args) {
        Grafo<Persona> grafo = new Grafo(false);
        Persona esteban = new Persona("Esteban", 33);
        Persona juan = new Persona("Juan", 45);
        Persona nicolas = new Persona("Nicolás", 13);
        Persona mateo = new Persona("Mateo", 23);
        Persona sofia = new Persona("Sofia", 19);

        grafo.agregarNodo(esteban);
        grafo.agregarNodo(juan);
        grafo.agregarNodo(nicolas);
        grafo.agregarNodo(mateo);
        grafo.agregarNodo(sofia);

        grafo.conectarNodo(esteban, juan, 2);
        grafo.conectarNodo(sofia, nicolas, 3);
        grafo.conectarNodo(nicolas, mateo, 4);
        grafo.conectarNodo(mateo, esteban, 5);
        grafo.conectarNodo(juan, sofia, 1);

        System.out.println("Grafo no dirigido");
        imprimirGrafo(grafo);

        PrintStream var10000 = System.out;
        List<Persona> var10001 = grafo.recorridoDFS(juan);
        var10000.println("Recorrido DFS desde Juan: " + String.valueOf(var10001));

        var10000 = System.out;
        var10001 = grafo.recorridoBFS(juan);
        var10000.println("Recorrido BFS desde Juan: " + String.valueOf(var10001));

        System.out.println("\nMatriz de Adyacencia:");
        int[][] matriz = grafo.obtenerMatrizAdyacencia();

        List<Persona> nodosParaImprimir = grafo.getNodos();
        imprimirMatrizAlineada(matriz, nodosParaImprimir);

        int[][] pesosDePrueba = matriz;

        System.out.println("\nAlgoritmo Dijkstra: " + Arrays.toString(Dijkstra.dijkstra(pesosDePrueba, 0)));

        int[][] fw = FloydWarshall.floydWarshall(pesosDePrueba);
        System.out.println("Algoritmo Floyd-Warshall (Caminos Mínimos)");

        for(int i = 0; i < fw.length; ++i) {
            System.out.println(Arrays.toString(fw[i]));
        }

        System.out.println("Algoritmo Kruskal: " + String.valueOf(Kruskal.kruskal(pesosDePrueba)));
        System.out.println("Algoritmo Prim: " + String.valueOf(Prim.prim(pesosDePrueba)));
    }

    private static <T> void imprimirGrafo(Grafo<T> g) {
        for(T nodo : g.getNodos()) {
            PrintStream var10000 = System.out;
            String var10001 = String.valueOf(nodo);
            var10000.println(var10001 + " -> " + String.valueOf(g.vecinosDe(nodo)));
        }
    }

    private static <T> void imprimirMatrizAlineada(int[][] m, List<T> nodos) {
        int ancho = 14;
        System.out.printf("%" + ancho + "s", "");

        for(T n : nodos) {
            System.out.printf("%" + ancho + "s", n.toString());
        }

        System.out.println();

        for(int i = 0; i < m.length; ++i) {
            System.out.printf("%" + ancho + "s", nodos.get(i).toString());

            for(int j = 0; j < m[i].length; ++j) {
                System.out.printf("%" + ancho + "d", m[i][j]);
            }

            System.out.println();
        }
    }
}