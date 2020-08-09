package com.excentro.javaalgorithms.lesson07;

import java.util.LinkedList;
import java.util.List;

public class Graph {
  private final int vertexCount;
  private final LinkedList<Integer>[] adjList;
  private int edgeCount;

  /**
   * Создает граф.
   *
   * @param vertexCount колличество вершин
   */
  public Graph(final int vertexCount) {
    if (vertexCount < 0) {
      throw new IllegalArgumentException("vertexCount: " + vertexCount);
    }
    this.vertexCount = vertexCount;
    adjList = new LinkedList[vertexCount];
    for (int i = 0; i < adjList.length; i++) {
      adjList[i] = new LinkedList<>();
    }
  }

  public int getVertexCount() {
    return vertexCount;
  }

  public int getEdgeCount() {
    return edgeCount;
  }

  public List<Integer> getAdjList(final int vertex) {
    return (LinkedList<Integer>) adjList[vertex].clone();
  }

  /**
   * Добавляет вершину в граф.
   *
   * @param v1 откуда
   * @param v2 куда
   */
  public void addEdge(final int v1, final int v2) {
    if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
      throw new IllegalArgumentException();
    }

    adjList[v1].add(v2);
    if (v1 == v2) {
      return;
    }
    adjList[v2].add(v1);
  }
}
