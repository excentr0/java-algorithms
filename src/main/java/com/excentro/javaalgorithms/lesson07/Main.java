package com.excentro.javaalgorithms.lesson07;

class Main {
  public static void main(String[] args) {
    Graph graph = new Graph(5);

    graph.addEdge(1, 2);
    graph.addEdge(0, 4);
    graph.addEdge(1, 4);
    graph.addEdge(3, 4);
    graph.addEdge(2, 4);

    System.out.println(graph.getAdjList(1));

    DepthFirstPath dfp = new DepthFirstPath(graph, 2);
    System.out.println(dfp.hasPathTo(0));
    System.out.println(dfp.pathTo(0));
    System.out.println(dfp.hasPathTo(3));


    BreadthFirstPath bfp = new BreadthFirstPath(graph, 2);
    System.out.println(bfp.hasPathTo(0));
    System.out.println(bfp.pathTo(0));
    System.out.println(bfp.hasPathTo(3));


  }
}
