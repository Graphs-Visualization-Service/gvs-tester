package gvs.tester.graph;

import gvs.business.graph.GVSGraph;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestDirectedEdge;

public class EmptyString {

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Empty String");
    addVertices(graph);
    graph.display();
    graph.disconnect();
  }


  private static void addVertices(GVSGraph graph) {
    TestDefaultVertex v = new TestDefaultVertex("");
    TestDefaultVertex v2 = new TestDefaultVertex(null);
    TestDefaultVertex v3 = new TestDefaultVertex("3");
    TestDirectedEdge e = new TestDirectedEdge(v, v2, "1");
    TestDirectedEdge e2 = new TestDirectedEdge(v2, v3, "1");
    graph.add(v);
    graph.add(v2);
    graph.add(v3);
    graph.add(e);
    graph.add(e2);
  }

}
