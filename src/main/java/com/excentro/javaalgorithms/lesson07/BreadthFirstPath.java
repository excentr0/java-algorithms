package com.excentro.javaalgorithms.lesson07;

import java.util.LinkedList;

public class BreadthFirstPath {
  private boolean[] marked;
  private int[] edgeTo;
  private int source;

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
