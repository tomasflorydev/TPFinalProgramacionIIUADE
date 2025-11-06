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
    public void conectarNodo(T valorOrigen, T valorDestino, int peso) {
        INodo<T> origen = getNodo(valorOrigen);
        INodo<T> destino = getNodo(valorDestino);
        origen.agregarVecino(destino, peso);
        if (!esOrientado) {
            destino.agregarVecino(origen, peso);
        }
    }

    @Override
    public int[][] obtenerMatrizAdyacencia() {
        return new int[0][];
    }

    @Override
    public List<T> recorridoBFS(T valorInicio) {
        List<T> resultado = new ArrayList<>();
        INodo<T> inicio = getNodo(valorInicio);
        if (inicio == null) return resultado;

        Set<INodo<T>> nodosVisitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>(); // Usamos una Cola para BFS

        cola.add(inicio);
        nodosVisitados.add(inicio);

        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            resultado.add(actual.getDato());

            for (INodo<T> vecino : actual.getVecinos()) {
                if (!nodosVisitados.contains(vecino)) {
                    nodosVisitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        return resultado;
    }

    @Override
    public List<T> recorridoDFS(T valorInicio) {
        List<T> resultado = new ArrayList<>();
        INodo<T> inicio = getNodo(valorInicio);
        if (inicio == null) return resultado;

        Set<INodo<T>> nodosVisitados = new HashSet<>();
        Stack<INodo<T>> pila = new Stack<>(); //Usamos una Pila para DFS

        pila.push(inicio);

        while (!pila.isEmpty()) {
            INodo<T> actual = pila.pop();

            if (!nodosVisitados.contains(actual)) {
                nodosVisitados.add(actual);
                resultado.add(actual.getDato());

                List<INodo<T>> listaVecinos = actual.getVecinos();
                List<INodo<T>> vecinosInvertidos = new ArrayList<>(listaVecinos);
                Collections.reverse(vecinosInvertidos);

                for (INodo<T> vecino : vecinosInvertidos) {
                    if (!nodosVisitados.contains(vecino)) {
                        pila.push(vecino);
                    }
                }
            }
        }
        return resultado;
    }

    @Override
    public boolean Dirigido() {
        return this.esOrientado;
    }
}