package com.excentro.javaalgorithms.lesson07;

import java.util.LinkedList;

public class DepthFirstPath {
  private boolean[] marked;
  private int[] edgeTo;
  private int source;

  public DepthFirstPath(Graph graph, int i) {
    marked = new boolean[graph.getVertexCount()];
    edgeTo = new int[graph.getVertexCount()];
    bfs(graph, source);
  }

  private void bfs(Graph g, int source) {
    LinkedList<Integer> queue = new LinkedList<>();
    queue.addLast(source);
    marked[source] = true;

    while (!queue.isEmpty()) {
      int vertex = queue.removeFirst();
      for (int w : g.getAdjList(vertex)) {
        if (!marked[w]) {
          marked[w] = true;
          edgeTo[w] = vertex;
          queue.addLast(w);
        }
      }
    }
  }


  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public LinkedList<Integer> pathTo(int v) {
    LinkedList<Integer> stack = new LinkedList<>();
    if (!hasPathTo(v)) {
      return stack;
    }
    int vertex = v;
    while (vertex != source) {
      stack.push(vertex);
      vertex = edgeTo[vertex];
    }
    return stack;
  }

}
