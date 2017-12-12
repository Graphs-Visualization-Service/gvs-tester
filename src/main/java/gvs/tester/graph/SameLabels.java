package gvs.tester.graph;

import java.util.ArrayList;
import java.util.List;

import gvs.graph.GVSDefaultVertex;
import gvs.graph.GVSDirectedEdge;
import gvs.graph.GVSGraph;
import gvs.graph.GVSUndirectedEdge;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestDirectedEdge;
import gvs.model.graph.TestUndirectedEdge;

public class SameLabels {

  private static List<GVSDefaultVertex> vertices = new ArrayList<>();
  private static List<GVSDirectedEdge> directedEdges = new ArrayList<>();
  private static List<GVSUndirectedEdge> undirectedEdges = new ArrayList<>();

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Default Graph");
    createVertices(graph);
    createEdges(graph);
    graph.display();
    graph.disconnect();
  }

  private static void createEdges(GVSGraph graph) {
    int j = 1;
    for (int i = 0; i < 5; i++) {
      if (i % 2 == 0) {
        TestDirectedEdge e = new TestDirectedEdge(vertices.get(i),
            vertices.get(j), i + "");
        directedEdges.add(e);
        graph.add(e);
      } else {
        TestUndirectedEdge e = new TestUndirectedEdge(vertices.get(i),
            vertices.get(j), i + "");
        undirectedEdges.add(e);
        graph.add(e);
      }
      j++;
      j %= 4;
    }
  }

  private static void createVertices(GVSGraph graph) {
    for (int i = 0; i < 5; i++) {
      TestDefaultVertex v = new TestDefaultVertex("v");
      vertices.add(v);
      graph.add(v);
    }
  }

}
