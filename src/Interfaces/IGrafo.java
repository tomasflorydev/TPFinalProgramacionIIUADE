package Interfaces;

import java.util.*;

public interface IGrafo<T> {

    boolean Dirigido();

    Map<T, INodo<T>> getNodos();

    INodo<T> getNodo(T valor);

    void agregarNodo(T valor);

    void conectarNodo(T valorOrigen, T valorDestino, int peso);

    int[][] obtenerMatrizAdyacencia();

    List<T> recorridoBFS(T valorInicio);

    List<T> DFS(T inicioValor);
}