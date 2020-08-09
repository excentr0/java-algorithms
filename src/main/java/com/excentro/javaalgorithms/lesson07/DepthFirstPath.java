package com.excentro.javaalgorithms.lesson07;

import java.util.LinkedList;
import java.util.List;

public class DepthFirstPath {
  private final boolean[] marked;
  private final int[] edgeTo;
  private final int source;

  /** Конструктор. */
  public DepthFirstPath(final Graph graph, final int source) {
    this.source = source;
    marked = new boolean[graph.getVertexCount()];
    edgeTo = new int[graph.getVertexCount()];
    dfs(graph, source);
  }

  private void dfs(final Graph g, final int source) {
    final LinkedList<Integer> queue = new LinkedList<>();
    queue.addLast(source);
    marked[source] = true;

    while (!queue.isEmpty()) {
      final int vertex = queue.removeFirst();
      for (final int w : g.getAdjList(vertex)) {
        if (!marked[w]) {
          marked[w] = true;
          edgeTo[w] = vertex;
          queue.addLast(w);
        }
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
