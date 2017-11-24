package gvs;

import gvs.graph.GVSDefaultVertex;
import gvs.graph.GVSGraph;

public class TestSpecialValuesGraph {

  public void empty() {
    GVSGraph gempty = new GVSGraph("Empty");
    gempty.display();
    gempty.display();
    MyDefaultVertex v1 = new MyDefaultVertex("v1", null);
    gempty.add(v1);
    gempty.display();
    gempty.remove(v1);
    gempty.display();
    gempty.disconnect();
  }

  public void mixedVertex() {
    GVSGraph gMixedVertex = new GVSGraph("Mixed Reltiv and Default");
    gMixedVertex.add(new MyRelativVertex("", null, 50, 50));
    gMixedVertex.add(new MyDefaultVertex("", null));
    gMixedVertex.display();
    gMixedVertex.disconnect();
  }

  public void smallWithArrow() {
    GVSGraph smallWithArrow = new GVSGraph("smallWithArrow");
    MyRelativVertex rv1 = new MyRelativVertex("rv1", null, 30, 20);
    MyRelativVertex rv2 = new MyRelativVertex("rv2", null, 60, 67);
    MyUndirectedEdge ue1 = new MyUndirectedEdge("ue1", null,
        new GVSDefaultVertex[] { rv1, rv2 });
    smallWithArrow.add(rv1);
    smallWithArrow.add(rv2);
    smallWithArrow.add(ue1);
    smallWithArrow.display();
    ue1.setArrow(2);
    smallWithArrow.display();
    ue1.setArrow(1);
    smallWithArrow.display();
    ue1.setArrow(3);
    smallWithArrow.display();
    smallWithArrow.disconnect();
  }

  public static void main(String args[]) {
    TestSpecialValuesGraph test = new TestSpecialValuesGraph();
    test.empty();
    // test.mixedVertex();
    // test.smallWithArrow();
  }

}
