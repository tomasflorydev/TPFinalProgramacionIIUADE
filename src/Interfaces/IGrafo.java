package Interfaces;

import java.util.*;

public interface IGrafo<T> {

    boolean Dirigido();

    Map<T, INodo<T>> getNodos();

    INodo<T> getNodo(T valor);

    void agregarNodo(T valor);

    void conectarNodo(T origenValor, T destinoValor, int peso);

    int[][] obtenerMatrizAdyacencia();

    List<T> BFS(T inicioValor);

    List<T> DFS(T inicioValor);
}