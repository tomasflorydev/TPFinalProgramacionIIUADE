package Modelado;

import Interfaces.INodo;
import java.util.ArrayList;
import java.util.List;

public class Nodo<T> implements INodo<T> {

    private T valor;
    private final List<INodo<T>> adyacentes;
    private final List<Integer> pesosAristas;

    public Nodo(T valor) {
        this.valor = valor;
        this.adyacentes = new ArrayList<>();
        this.pesosAristas = new ArrayList<>();
    }

    @Override
    public T getDato() {
        return this.valor;
    }

    @Override
    public void setDato(T valor) {
        this.valor = valor;
    }

    @Override
    public List<INodo<T>> getVecinos() {
        return this.adyacentes;
    }

    @Override
    public List<Integer> getPesos() {
        return this.pesosAristas;
    }
}