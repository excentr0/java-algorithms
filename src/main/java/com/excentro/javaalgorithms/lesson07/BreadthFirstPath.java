package com.excentro.javaalgorithms.lesson07;

import java.util.LinkedList;

public class BreadthFirstPath {
  private final boolean[] marked;
  private final int[] edgeTo;
  private final int source;

  public BreadthFirstPath(Graph g, int source) {
    this.source = source;
    marked = new boolean[g.getVertexCount()];
    edgeTo = new int[g.getVertexCount()];
    dfs(g, source);
  }

  private void dfs(Graph g, int v) {
    marked[v] = true;
    for (int w : g.getAdjList(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(g, w);
      }
    }
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

  public boolean hasPathTo(int v) {
    return marked[v];
  }
}
