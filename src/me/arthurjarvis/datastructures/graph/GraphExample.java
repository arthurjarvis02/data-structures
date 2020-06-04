package me.arthurjarvis.datastructures.graph;

import java.util.*;

public class GraphExample implements Runnable {

    @Override
    public void run() {

        Graph graph = new Graph();

        Graph.Vertex router = new Graph.Vertex("Router");
        Graph.Vertex _switch = new Graph.Vertex("Switch");

        Graph.Vertex wiredClient1 = new Graph.Vertex("Wired Client 1");
        Graph.Vertex wiredClient2 = new Graph.Vertex("Wired Client 2");
        Graph.Vertex ap = new Graph.Vertex("Wireless Access Point");

        Graph.Vertex wirelessClient1 = new Graph.Vertex("Wireless Client 1");
        Graph.Vertex wirelessClient2 = new Graph.Vertex("Wireless Client 2");


        graph.addVertices(router, _switch, wiredClient1, wiredClient2, ap, wirelessClient1, wirelessClient2);

        graph.addEdges(router, _switch);
        graph.addEdges(_switch, wiredClient1, wiredClient2, ap);
        graph.addEdges(ap, wirelessClient1, wirelessClient2);


        System.out.println("-- Depth-first traversal - Explores each branch as deeply as possible before moving onto the next branch --");
        System.out.println();
        visualiseDepthFirstTraversal(graph, router);

        System.out.println();
        System.out.println("--");
        System.out.println();


        System.out.println("-- Breadth-first traversal - Explores all vertices at the same level before going one level deeper in the graph --");
        System.out.println();
        visualiseBreadthFirstTraversal(graph, router);
        System.out.println("--");

    }

    private void visualiseDepthFirstTraversal(Graph graph, Graph.Vertex root) {

        Set<Graph.Vertex> visited = new LinkedHashSet<>();
        Stack<Graph.Vertex> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Graph.Vertex current = stack.pop();

            if(!visited.contains(current)) {

                visited.add(current);
                System.out.println(current.getLabel());

                for (Graph.Vertex adjacent : graph.getAdjacentVertices(current)) {

                    stack.push(adjacent);
                }
            }
        }
    }

    private void visualiseBreadthFirstTraversal(Graph graph, Graph.Vertex root) {

        Set<Graph.Vertex> visited = new LinkedHashSet<>();
        Queue<Graph.Vertex> queue = new LinkedList<>();
        visited.add(root);
        queue.add(root);

        System.out.println(root.getLabel());

        while(!queue.isEmpty()) {

            Graph.Vertex current = queue.poll();

            for (Graph.Vertex adjacent : graph.getAdjacentVertices(current)) {

                if (!visited.contains(adjacent)) {

                    System.out.println(adjacent.getLabel());

                    visited.add(adjacent);
                    queue.add(adjacent);
                }
            }
        }
    }
}