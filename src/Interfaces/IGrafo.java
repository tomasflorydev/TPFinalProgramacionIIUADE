package Interfaces;

import java.util.*;

public interface IGrafo<T> {

    boolean Dirigido();

    List<T> getNodos();

    INodo<T> getNodo(T valor);

    void agregarNodo(T valor);

    List<T> vecinosDe(T dato);

    void conectarNodo(T valorOrigen, T valorDestino, int peso);

    int[][] obtenerMatrizAdyacencia();

    List<T> recorridoBFS(T valorInicio);

    List<T> recorridoDFS(T valorInicio);
}