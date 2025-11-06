package Modelado;

import Interfaces.IGrafo;
import Interfaces.INodo;
import java.util.*;

public class Grafo<T> implements IGrafo<T> {

    private final Map<T, INodo<T>> mapaNodos;
    private final boolean esOrientado;

    public Grafo(boolean esOrientado) {
        this.mapaNodos = new HashMap<>();
        this.esOrientado = esOrientado;
    }

    @Override
    public Map<T, INodo<T>> getNodos() {
        return this.mapaNodos;
    }

    @Override
    public INodo<T> getNodo(T valor) {
        return this.mapaNodos.get(valor);
    }

    @Override
    public void agregarNodo(T valor) {
        if (!mapaNodos.containsKey(valor)) {
            mapaNodos.put(valor, new Nodo<>(valor));
        }
    }

    @Override
    public void conectarNodo(T origenValor, T destinoValor, int peso) {

    }

    @Override
    public int[][] obtenerMatrizAdyacencia() {
        return new int[0][];
    }

    @Override
    public List<T> BFS(T inicioValor) {
        return List.of();
    }

    @Override
    public List<T> DFS(T inicioValor) {
        return List.of();
    }

    @Override
    public boolean Dirigido() {
        return this.esOrientado;
    }
}