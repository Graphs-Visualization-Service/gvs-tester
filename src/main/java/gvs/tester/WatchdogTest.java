package gvs.tester;

import java.util.List;

import gvs.business.graph.GVSGraph;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestDirectedEdge;

public class WatchdogTest {
  private static List<TestDirectedEdge> edges ;

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Watchdog test");
    graph.add(new TestDefaultVertex("watch"));
    graph.display();
    createEdge(graph);
    graph.display();
    graph.disconnect();
  }

  private static void createEdge(GVSGraph graph) {
    TestDirectedEdge e = new TestDirectedEdge(null, null, "dog");
    edges.add(e);
  }

}
