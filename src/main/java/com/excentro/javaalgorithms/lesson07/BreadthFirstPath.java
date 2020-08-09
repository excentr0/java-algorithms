package com.excentro.javaalgorithms.lesson07;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirstPath {
  private final boolean[] marked;
  private final int[] edgeTo;
  private final int source;

  /** Конструктор. */
  public BreadthFirstPath(final Graph graph, final int source) {
    this.source = source;
    marked = new boolean[graph.getVertexCount()];
    edgeTo = new int[graph.getVertexCount()];
    bfs(graph, source);
  }

  private void bfs(final Graph g, final int v) {
    marked[v] = true;
    for (final int w : g.getAdjList(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        bfs(g, w);
      }
    }
  }

  public List<Integer> pathTo(final int v) {
    final LinkedList<Integer> stack = new LinkedList<>();
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

  public boolean hasPathTo(final int v) {
    return marked[v];
  }
}
