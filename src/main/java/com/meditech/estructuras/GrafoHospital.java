package com.meditech.estructuras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GrafoHospital {

    private Map<Integer, List<Arista>> adyacencias = new HashMap<>();

    public void agregarConexion(int origen, int destino, int peso, String descripcion) {
        adyacencias.computeIfAbsent(origen, k -> new ArrayList<>())
                .add(new Arista(destino, peso, descripcion));
    }

    public List<String> describirRuta(int origen, int destino) {
        Map<Integer, Integer> anteriores = new HashMap<>();
        Map<Integer, Arista> caminoUsado = new HashMap<>();
        Map<Integer, Integer> distancias = new HashMap<>();
        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.distancia));

        for (Integer nodo : adyacencias.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        cola.add(new Nodo(origen, 0));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            if (actual.id == destino)
                break;

            for (Arista arista : adyacencias.getOrDefault(actual.id, new ArrayList<>())) {
                int nuevaDistancia = distancias.get(actual.id) + arista.peso;
                if (nuevaDistancia < distancias.getOrDefault(arista.destino, Integer.MAX_VALUE)) {
                    distancias.put(arista.destino, nuevaDistancia);
                    anteriores.put(arista.destino, actual.id);
                    caminoUsado.put(arista.destino, arista);
                    cola.add(new Nodo(arista.destino, nuevaDistancia));
                }
            }
        }

        List<String> rutaDetallada = new ArrayList<>();
        Integer actual = destino;
        while (actual != null && anteriores.containsKey(actual)) {
            int anterior = anteriores.get(actual);
            Arista paso = caminoUsado.get(actual);
            rutaDetallada.add(0, "De " + anterior + " a " + actual + " por " + paso.descripcion);
            actual = anteriores.get(actual);
        }

        return rutaDetallada;
    }

    public List<String> describirRutaDetallada(int origen, int destino, Map<Integer, String> servicioNombres) {
        Map<Integer, Integer> anteriores = new HashMap<>();
        Map<Integer, Arista> caminoUsado = new HashMap<>();
        Map<Integer, Integer> distancias = new HashMap<>();
        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.distancia));

        for (Integer nodo : adyacencias.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        cola.add(new Nodo(origen, 0));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            if (actual.id == destino)
                break;

            for (Arista arista : adyacencias.getOrDefault(actual.id, new ArrayList<>())) {
                int nuevaDistancia = distancias.get(actual.id) + arista.peso;
                if (nuevaDistancia < distancias.getOrDefault(arista.destino, Integer.MAX_VALUE)) {
                    distancias.put(arista.destino, nuevaDistancia);
                    anteriores.put(arista.destino, actual.id);
                    caminoUsado.put(arista.destino, arista);
                    cola.add(new Nodo(arista.destino, nuevaDistancia));
                }
            }
        }

        List<String> rutaDetallada = new ArrayList<>();
        Integer actual = destino;
        while (actual != null && anteriores.containsKey(actual)) {
            int anterior = anteriores.get(actual);
            Arista paso = caminoUsado.get(actual);
            String nombreOrigen = servicioNombres.getOrDefault(anterior, "Desconocido");
            String nombreDestino = servicioNombres.getOrDefault(actual, "Desconocido");
            rutaDetallada.add(0, "De " + nombreOrigen + " a " + nombreDestino + " por " + paso.descripcion);
            actual = anteriores.get(actual);
        }

        return rutaDetallada;
    }

    public List<Integer> caminoMasCorto(int origen, int destino) {
        Map<Integer, Integer> distancias = new HashMap<>();
        Map<Integer, Integer> anteriores = new HashMap<>();
        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.distancia));

        for (Integer nodo : adyacencias.keySet()) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        cola.add(new Nodo(origen, 0));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();

            if (actual.id == destino)
                break;

            for (Arista arista : adyacencias.getOrDefault(actual.id, new ArrayList<>())) {
                int nuevaDistancia = distancias.get(actual.id) + arista.peso;
                if (nuevaDistancia < distancias.getOrDefault(arista.destino, Integer.MAX_VALUE)) {
                    distancias.put(arista.destino, nuevaDistancia);
                    anteriores.put(arista.destino, actual.id);
                    cola.add(new Nodo(arista.destino, nuevaDistancia));
                }
            }
        }

        List<Integer> camino = new ArrayList<>();
        Integer actual = destino;
        while (actual != null) {
            camino.add(0, actual);
            actual = anteriores.get(actual);
        }

        return camino.get(0) == origen ? camino : Collections.emptyList();
    }

    private static class Nodo {
        int id;
        int distancia;

        Nodo(int id, int distancia) {
            this.id = id;
            this.distancia = distancia;
        }
    }

    public static class Arista {
        int destino;
        int peso;
        String descripcion;

        Arista(int destino, int peso, String descripcion) {
            this.destino = destino;
            this.peso = peso;
            this.descripcion = descripcion;
        }
    }
}
