package com.excentro.javaalgorithms.lesson07;

/**
 * Реализовать программу, в которой задается граф из 10 вершин. Задать ребра и найти кратчайший путь
 * с помощью поиска в ширину. Так же укажите длину пути.
 */
class Main {
  public static void main(String[] args) {
    Graph graph = new Graph(10);

    graph.addEdge(0, 1);
    graph.addEdge(2, 5);
    graph.addEdge(2, 8);
    graph.addEdge(2, 3);
    graph.addEdge(2, 6);
    graph.addEdge(5, 3);
    graph.addEdge(5, 6);
    graph.addEdge(5, 8);
    graph.addEdge(8, 6);
    graph.addEdge(3, 1);
    graph.addEdge(3, 6);
    graph.addEdge(3, 7);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(6, 9);
    graph.addEdge(6, 7);
    graph.addEdge(6, 4);
    graph.addEdge(7, 4);

    BreadthFirstPath bfp = new BreadthFirstPath(graph, 0);
    System.out.println("Возможен ли путь к вершине: " + bfp.hasPathTo(9));
    System.out.println("Полученный путь: " + bfp.pathTo(9) + ", длиной в " + bfp.pathTo(9).size());
  }
}
