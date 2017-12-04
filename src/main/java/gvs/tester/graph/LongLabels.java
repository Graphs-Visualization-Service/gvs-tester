package gvs.tester.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gvs.graph.GVSGraph;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestUndirectedEdge;

public class LongLabels {
  private List<TestDefaultVertex> vertices = new ArrayList<>();
  private List<TestUndirectedEdge> edges = new ArrayList<>();
  private final String LONG_LABEL = "LoooooongLabelForGraphs";

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Long Labels Graph");
    LongLabels test = new LongLabels();
    test.buildGraph(graph);
    graph.add(test.getVertices());
    graph.add(test.getEdges());
    graph.display();
    graph.disconnect();
  }

  public List<TestDefaultVertex> getVertices() {
    return vertices;
  }
  
  public List<TestUndirectedEdge> getEdges() {
    return edges;
  }

  private void buildGraph(GVSGraph graph) {
    for (int i = 0; i < 5; i++) {
      TestDefaultVertex v = new TestDefaultVertex(LONG_LABEL + i);
      vertices.add(v);
    }
    Random rnd = new Random();
    for (int i = 0; i < 7; i++) {
      TestUndirectedEdge e = new TestUndirectedEdge(i + "");
      int index = rnd.nextInt(5);
      e.setFromVertex(vertices.get(index));
      index = rnd.nextInt(5);
      e.setToVertex(vertices.get(index));
      edges.add(e);
    }
  }

}
