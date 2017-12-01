package gvs.tester.graph;

import gvs.graph.GVSGraph;

public class EmptyGraph {
  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Empty Graph");
    graph.display();
    graph.disconnect();
  }
}
