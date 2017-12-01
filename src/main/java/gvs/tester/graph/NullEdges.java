package gvs.tester.graph;

import gvs.graph.GVSGraph;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestDirectedEdge;

public class NullEdges {

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Null Edges");
    addVertices(graph);
    addEdges(graph);
    graph.display();
    graph.disconnect();
  }

  private static void addEdges(GVSGraph graph) {
    TestDirectedEdge e = new TestDirectedEdge(null, null, "e");
    graph.add(e);
  }

  private static void addVertices(GVSGraph graph) {
    TestDefaultVertex v = new TestDefaultVertex("v");
    graph.add(v);
  }

}
