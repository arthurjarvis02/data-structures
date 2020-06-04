package me.arthurjarvis.datastructures.graph;

import java.util.*;

public class Graph {

    private Map<Vertex, List<Vertex>> vertices = new HashMap<>();

    public void addVertices(Vertex... vertices) {

        for (Vertex vertex : vertices) {

            this.vertices.putIfAbsent(vertex, new ArrayList<>());
        }
    }

    public void addEdges(Vertex vertex, Vertex... adjacentVertices) {

        for (int i = 0; i < adjacentVertices.length; i++) {

            vertices.get(vertex).add(adjacentVertices[i]);
            vertices.get(adjacentVertices[i]).add(vertex);
        }
    }

    public List<Vertex> getAdjacentVertices(Vertex vertex) {

        return vertices.get(vertex);
    }

    public static class Vertex {

        private String label;

        public Vertex(String label) {

            this.label = label;
        }

        public String getLabel() {

            return label;
        }
    }
}